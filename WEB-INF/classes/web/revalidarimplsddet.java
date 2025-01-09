package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class revalidarimplsddet extends GXProcedure
{
   public revalidarimplsddet( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( revalidarimplsddet.class ), "" );
   }

   public revalidarimplsddet( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 )
   {
      revalidarimplsddet.this.AV8CliCod = aP0;
      revalidarimplsddet.this.AV9EmpCod = aP1;
      revalidarimplsddet.this.AV10ImpLiqSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00OI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Short.valueOf(AV10ImpLiqSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A88ImpLiqSec = P00OI2_A88ImpLiqSec[0] ;
         A1EmpCod = P00OI2_A1EmpCod[0] ;
         A3CliCod = P00OI2_A3CliCod[0] ;
         A666ImpLiqDetConCod = P00OI2_A666ImpLiqDetConCod[0] ;
         A663ImpLiqDetCUIL = P00OI2_A663ImpLiqDetCUIL[0] ;
         A661ImpLiqDetPer = P00OI2_A661ImpLiqDetPer[0] ;
         A712ImpLiqDetLegSis = P00OI2_A712ImpLiqDetLegSis[0] ;
         A713ImpLiqDetConSis = P00OI2_A713ImpLiqDetConSis[0] ;
         A714ImpLiqDetConSisYDes = P00OI2_A714ImpLiqDetConSisYDes[0] ;
         A709ImpLiqDetError = P00OI2_A709ImpLiqDetError[0] ;
         A90ImpLiqDetSec = P00OI2_A90ImpLiqDetSec[0] ;
         GXv_char1[0] = AV12ImpLiqDetLegSis ;
         GXv_char2[0] = AV11ImpLiqDetConSis ;
         GXv_char3[0] = AV13ImpLiqDetConSisYDes ;
         GXv_char4[0] = "" ;
         GXv_char5[0] = "" ;
         GXv_char6[0] = AV14ImpLiqDetError ;
         new web.liqdetimplsd_validar(remoteHandle, context).execute( A3CliCod, A1EmpCod, A88ImpLiqSec, A666ImpLiqDetConCod, A663ImpLiqDetCUIL, A661ImpLiqDetPer, GXv_char1, GXv_char2, GXv_char3, GXv_char4, GXv_char5, GXv_char6) ;
         revalidarimplsddet.this.AV12ImpLiqDetLegSis = GXv_char1[0] ;
         revalidarimplsddet.this.AV11ImpLiqDetConSis = GXv_char2[0] ;
         revalidarimplsddet.this.AV13ImpLiqDetConSisYDes = GXv_char3[0] ;
         revalidarimplsddet.this.AV14ImpLiqDetError = GXv_char6[0] ;
         A712ImpLiqDetLegSis = AV12ImpLiqDetLegSis ;
         A713ImpLiqDetConSis = AV11ImpLiqDetConSis ;
         A714ImpLiqDetConSisYDes = AV13ImpLiqDetConSisYDes ;
         A709ImpLiqDetError = AV14ImpLiqDetError ;
         /* Using cursor P00OI3 */
         pr_default.execute(1, new Object[] {A712ImpLiqDetLegSis, A713ImpLiqDetConSis, A714ImpLiqDetConSisYDes, A709ImpLiqDetError, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_detalle");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "revalidarimplsddet");
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
      P00OI2_A88ImpLiqSec = new short[1] ;
      P00OI2_A1EmpCod = new short[1] ;
      P00OI2_A3CliCod = new int[1] ;
      P00OI2_A666ImpLiqDetConCod = new String[] {""} ;
      P00OI2_A663ImpLiqDetCUIL = new String[] {""} ;
      P00OI2_A661ImpLiqDetPer = new String[] {""} ;
      P00OI2_A712ImpLiqDetLegSis = new String[] {""} ;
      P00OI2_A713ImpLiqDetConSis = new String[] {""} ;
      P00OI2_A714ImpLiqDetConSisYDes = new String[] {""} ;
      P00OI2_A709ImpLiqDetError = new String[] {""} ;
      P00OI2_A90ImpLiqDetSec = new short[1] ;
      A666ImpLiqDetConCod = "" ;
      A663ImpLiqDetCUIL = "" ;
      A661ImpLiqDetPer = "" ;
      A712ImpLiqDetLegSis = "" ;
      A713ImpLiqDetConSis = "" ;
      A714ImpLiqDetConSisYDes = "" ;
      A709ImpLiqDetError = "" ;
      AV12ImpLiqDetLegSis = "" ;
      GXv_char1 = new String[1] ;
      AV11ImpLiqDetConSis = "" ;
      GXv_char2 = new String[1] ;
      AV13ImpLiqDetConSisYDes = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      AV14ImpLiqDetError = "" ;
      GXv_char6 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.revalidarimplsddet__default(),
         new Object[] {
             new Object[] {
            P00OI2_A88ImpLiqSec, P00OI2_A1EmpCod, P00OI2_A3CliCod, P00OI2_A666ImpLiqDetConCod, P00OI2_A663ImpLiqDetCUIL, P00OI2_A661ImpLiqDetPer, P00OI2_A712ImpLiqDetLegSis, P00OI2_A713ImpLiqDetConSis, P00OI2_A714ImpLiqDetConSisYDes, P00OI2_A709ImpLiqDetError,
            P00OI2_A90ImpLiqDetSec
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV10ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short A90ImpLiqDetSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A666ImpLiqDetConCod ;
   private String A663ImpLiqDetCUIL ;
   private String A661ImpLiqDetPer ;
   private String A713ImpLiqDetConSis ;
   private String GXv_char1[] ;
   private String AV11ImpLiqDetConSis ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String A712ImpLiqDetLegSis ;
   private String A714ImpLiqDetConSisYDes ;
   private String A709ImpLiqDetError ;
   private String AV12ImpLiqDetLegSis ;
   private String AV13ImpLiqDetConSisYDes ;
   private String AV14ImpLiqDetError ;
   private IDataStoreProvider pr_default ;
   private short[] P00OI2_A88ImpLiqSec ;
   private short[] P00OI2_A1EmpCod ;
   private int[] P00OI2_A3CliCod ;
   private String[] P00OI2_A666ImpLiqDetConCod ;
   private String[] P00OI2_A663ImpLiqDetCUIL ;
   private String[] P00OI2_A661ImpLiqDetPer ;
   private String[] P00OI2_A712ImpLiqDetLegSis ;
   private String[] P00OI2_A713ImpLiqDetConSis ;
   private String[] P00OI2_A714ImpLiqDetConSisYDes ;
   private String[] P00OI2_A709ImpLiqDetError ;
   private short[] P00OI2_A90ImpLiqDetSec ;
}

final  class revalidarimplsddet__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OI2", "SELECT ImpLiqSec, EmpCod, CliCod, ImpLiqDetConCod, ImpLiqDetCUIL, ImpLiqDetPer, ImpLiqDetLegSis, ImpLiqDetConSis, ImpLiqDetConSisYDes, ImpLiqDetError, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec  FOR UPDATE OF importacion_liquidacion_detalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00OI3", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_detalle SET ImpLiqDetLegSis=?, ImpLiqDetConSis=?, ImpLiqDetConSisYDes=?, ImpLiqDetError=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((String[]) buf[4])[0] = rslt.getString(5, 11);
               ((String[]) buf[5])[0] = rslt.getString(6, 6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 10);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 10);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
      }
   }

}

