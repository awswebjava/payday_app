package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class leglicccagraprmanual extends GXProcedure
{
   public leglicccagraprmanual( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( leglicccagraprmanual.class ), "" );
   }

   public leglicccagraprmanual( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 )
   {
      leglicccagraprmanual.this.AV13CliCod = aP0;
      leglicccagraprmanual.this.AV12EmpCod = aP1;
      leglicccagraprmanual.this.AV11LegNumero = aP2;
      leglicccagraprmanual.this.AV10LegCuenLicTpo = aP3;
      leglicccagraprmanual.this.AV9LegCuenAnio = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P02BS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LegNumero), AV10LegCuenLicTpo, Short.valueOf(AV9LegCuenAnio)});
      c2325LegCuLAprLicCnt = P02BS2_A2325LegCuLAprLicCnt[0] ;
      pr_default.close(0);
      AV8LegCuLAprLicCnt = (short)(AV8LegCuLAprLicCnt+c2325LegCuLAprLicCnt) ;
      /* End optimized group. */
      /* Optimized UPDATE. */
      /* Using cursor P02BS3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV8LegCuLAprLicCnt), Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LegNumero), AV10LegCuenLicTpo, Short.valueOf(AV9LegCuenAnio)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "leglicccagraprmanual");
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
      P02BS2_A2325LegCuLAprLicCnt = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.leglicccagraprmanual__default(),
         new Object[] {
             new Object[] {
            P02BS2_A2325LegCuLAprLicCnt
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV9LegCuenAnio ;
   private short c2325LegCuLAprLicCnt ;
   private short AV8LegCuLAprLicCnt ;
   private short A2248LegCuenDiasGoz ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LegNumero ;
   private String AV10LegCuenLicTpo ;
   private String scmdbuf ;
   private IDataStoreProvider pr_default ;
   private short[] P02BS2_A2325LegCuLAprLicCnt ;
}

final  class leglicccagraprmanual__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BS2", "SELECT SUM(LegCuLAprLicCnt) FROM legajo_cuenta_licenciasaprobaciones WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ?) AND (LegCuLAprLicOri = ( 'manual')) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02BS3", "UPDATE legajo_cuenta_licencias SET LegCuenDiasGoz=?  WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
      }
   }

}

