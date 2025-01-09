package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsexonombre extends GXProcedure
{
   public getsexonombre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsexonombre.class ), "" );
   }

   public getsexonombre( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( byte aP0 )
   {
      getsexonombre.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( byte aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( byte aP0 ,
                             String[] aP1 )
   {
      getsexonombre.this.AV8SexoId = aP0;
      getsexonombre.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02592 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV8SexoId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1743SexoId = P02592_A1743SexoId[0] ;
         A1744SexoNombre = P02592_A1744SexoNombre[0] ;
         AV9SexoNombre = A1744SexoNombre ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getsexonombre.this.AV9SexoNombre;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SexoNombre = "" ;
      scmdbuf = "" ;
      P02592_A1743SexoId = new byte[1] ;
      P02592_A1744SexoNombre = new String[] {""} ;
      A1744SexoNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsexonombre__default(),
         new Object[] {
             new Object[] {
            P02592_A1743SexoId, P02592_A1744SexoNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8SexoId ;
   private byte A1743SexoId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV9SexoNombre ;
   private String A1744SexoNombre ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private byte[] P02592_A1743SexoId ;
   private String[] P02592_A1744SexoNombre ;
}

final  class getsexonombre__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02592", "SELECT SexoId, SexoNombre FROM Sexos WHERE SexoId = ? ORDER BY SexoId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               return;
      }
   }

}

