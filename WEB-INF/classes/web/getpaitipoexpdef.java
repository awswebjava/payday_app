package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaitipoexpdef extends GXProcedure
{
   public getpaitipoexpdef( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaitipoexpdef.class ), "" );
   }

   public getpaitipoexpdef( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( short aP0 )
   {
      getpaitipoexpdef.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             byte[] aP1 )
   {
      getpaitipoexpdef.this.AV8PaiCod = aP0;
      getpaitipoexpdef.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01N12 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A46PaiCod = P01N12_A46PaiCod[0] ;
         A1793PaiTipoExpDef = P01N12_A1793PaiTipoExpDef[0] ;
         AV9PaiTipoExpDef = A1793PaiTipoExpDef ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpaitipoexpdef.this.AV9PaiTipoExpDef;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01N12_A46PaiCod = new short[1] ;
      P01N12_A1793PaiTipoExpDef = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaitipoexpdef__default(),
         new Object[] {
             new Object[] {
            P01N12_A46PaiCod, P01N12_A1793PaiTipoExpDef
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9PaiTipoExpDef ;
   private byte A1793PaiTipoExpDef ;
   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String scmdbuf ;
   private byte[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P01N12_A46PaiCod ;
   private byte[] P01N12_A1793PaiTipoExpDef ;
}

final  class getpaitipoexpdef__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01N12", "SELECT PaiCod, PaiTipoExpDef FROM Pais WHERE PaiCod = ? ORDER BY PaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

