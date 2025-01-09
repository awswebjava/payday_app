package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class opcionsetnomostrar extends GXProcedure
{
   public opcionsetnomostrar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( opcionsetnomostrar.class ), "" );
   }

   public opcionsetnomostrar( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      opcionsetnomostrar.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      opcionsetnomostrar.this.AV11MenuOpcCod = aP0;
      opcionsetnomostrar.this.AV12MenuBienveVisible = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV13SecUserId ;
      GXv_int2[0] = GXt_int1 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int2) ;
      opcionsetnomostrar.this.GXt_int1 = GXv_int2[0] ;
      AV13SecUserId = GXt_int1 ;
      GXv_int3[0] = AV8RolId ;
      GXv_int4[0] = AV9PerfilId ;
      GXv_int5[0] = AV10MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV13SecUserId, GXv_int3, GXv_int4, GXv_int5) ;
      opcionsetnomostrar.this.AV8RolId = GXv_int3[0] ;
      opcionsetnomostrar.this.AV9PerfilId = GXv_int4[0] ;
      opcionsetnomostrar.this.AV10MenuVerId = GXv_int5[0] ;
      /* Optimized UPDATE. */
      /* Using cursor P01VA2 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(AV12MenuBienveVisible), Byte.valueOf(AV8RolId), Byte.valueOf(AV9PerfilId), Long.valueOf(AV10MenuVerId), AV11MenuOpcCod});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = opcionsetnomostrar.this.AV12MenuBienveVisible;
      Application.commitDataStores(context, remoteHandle, pr_default, "opcionsetnomostrar");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.opcionsetnomostrar__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8RolId ;
   private byte GXv_int3[] ;
   private byte AV9PerfilId ;
   private byte GXv_int4[] ;
   private short AV13SecUserId ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private long AV10MenuVerId ;
   private long GXv_int5[] ;
   private boolean AV12MenuBienveVisible ;
   private boolean A1951MenuBienveVisible ;
   private String AV11MenuOpcCod ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
}

final  class opcionsetnomostrar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01VA2", "UPDATE MenuVersionesOpciones SET MenuBienveVisible=?  WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setVarchar(5, (String)parms[4], 100);
               return;
      }
   }

}

