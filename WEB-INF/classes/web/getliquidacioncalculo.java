package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliquidacioncalculo extends GXProcedure
{
   public getliquidacioncalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliquidacioncalculo.class ), "" );
   }

   public getliquidacioncalculo( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              String aP4 ,
                              String[] aP5 ,
                              java.math.BigDecimal[] aP6 ,
                              java.math.BigDecimal[] aP7 )
   {
      getliquidacioncalculo.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             boolean[] aP8 )
   {
      getliquidacioncalculo.this.AV13CliCod = aP0;
      getliquidacioncalculo.this.AV12EmpCod = aP1;
      getliquidacioncalculo.this.AV11LiqNro = aP2;
      getliquidacioncalculo.this.AV10LegNumero = aP3;
      getliquidacioncalculo.this.AV14LiqDOpeOrig = aP4;
      getliquidacioncalculo.this.aP5 = aP5;
      getliquidacioncalculo.this.aP6 = aP6;
      getliquidacioncalculo.this.aP7 = aP7;
      getliquidacioncalculo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01Y92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LiqNro), Integer.valueOf(AV10LegNumero), AV14LiqDOpeOrig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1035LiqDOpeOrig = P01Y92_A1035LiqDOpeOrig[0] ;
         A6LegNumero = P01Y92_A6LegNumero[0] ;
         A31LiqNro = P01Y92_A31LiqNro[0] ;
         A1EmpCod = P01Y92_A1EmpCod[0] ;
         A3CliCod = P01Y92_A3CliCod[0] ;
         A2074LiqDOpeLog = P01Y92_A2074LiqDOpeLog[0] ;
         A2075LiqdOpeRes = P01Y92_A2075LiqdOpeRes[0] ;
         A2076LiqdOpeCant = P01Y92_A2076LiqdOpeCant[0] ;
         AV9LiqDOpeLog = A2074LiqDOpeLog ;
         AV8LiqdOpeRes = A2075LiqdOpeRes ;
         AV16LiqdOpeCant = A2076LiqdOpeCant ;
         AV15existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getliquidacioncalculo.this.AV9LiqDOpeLog;
      this.aP6[0] = getliquidacioncalculo.this.AV8LiqdOpeRes;
      this.aP7[0] = getliquidacioncalculo.this.AV16LiqdOpeCant;
      this.aP8[0] = getliquidacioncalculo.this.AV15existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LiqDOpeLog = "" ;
      AV8LiqdOpeRes = DecimalUtil.ZERO ;
      AV16LiqdOpeCant = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01Y92_A1035LiqDOpeOrig = new String[] {""} ;
      P01Y92_A6LegNumero = new int[1] ;
      P01Y92_A31LiqNro = new int[1] ;
      P01Y92_A1EmpCod = new short[1] ;
      P01Y92_A3CliCod = new int[1] ;
      P01Y92_A2074LiqDOpeLog = new String[] {""} ;
      P01Y92_A2075LiqdOpeRes = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Y92_A2076LiqdOpeCant = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1035LiqDOpeOrig = "" ;
      A2074LiqDOpeLog = "" ;
      A2075LiqdOpeRes = DecimalUtil.ZERO ;
      A2076LiqdOpeCant = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliquidacioncalculo__default(),
         new Object[] {
             new Object[] {
            P01Y92_A1035LiqDOpeOrig, P01Y92_A6LegNumero, P01Y92_A31LiqNro, P01Y92_A1EmpCod, P01Y92_A3CliCod, P01Y92_A2074LiqDOpeLog, P01Y92_A2075LiqdOpeRes, P01Y92_A2076LiqdOpeCant
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private java.math.BigDecimal AV8LiqdOpeRes ;
   private java.math.BigDecimal AV16LiqdOpeCant ;
   private java.math.BigDecimal A2075LiqdOpeRes ;
   private java.math.BigDecimal A2076LiqdOpeCant ;
   private String AV14LiqDOpeOrig ;
   private String scmdbuf ;
   private String A1035LiqDOpeOrig ;
   private boolean AV15existe ;
   private String AV9LiqDOpeLog ;
   private String A2074LiqDOpeLog ;
   private boolean[] aP8 ;
   private String[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P01Y92_A1035LiqDOpeOrig ;
   private int[] P01Y92_A6LegNumero ;
   private int[] P01Y92_A31LiqNro ;
   private short[] P01Y92_A1EmpCod ;
   private int[] P01Y92_A3CliCod ;
   private String[] P01Y92_A2074LiqDOpeLog ;
   private java.math.BigDecimal[] P01Y92_A2075LiqdOpeRes ;
   private java.math.BigDecimal[] P01Y92_A2076LiqdOpeCant ;
}

final  class getliquidacioncalculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Y92", "SELECT LiqDOpeOrig, LegNumero, LiqNro, EmpCod, CliCod, LiqDOpeLog, LiqdOpeRes, LiqdOpeCant FROM liquidacionLegajoCalculos WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and LiqDOpeOrig = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDOpeOrig ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 100);
               return;
      }
   }

}

