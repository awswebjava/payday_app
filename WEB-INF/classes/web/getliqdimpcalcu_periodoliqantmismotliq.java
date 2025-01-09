package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcu_periodoliqantmismotliq extends GXProcedure
{
   public getliqdimpcalcu_periodoliqantmismotliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcu_periodoliqantmismotliq.class ), "" );
   }

   public getliqdimpcalcu_periodoliqantmismotliq( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           java.util.Date aP4 ,
                                           String aP5 ,
                                           boolean aP6 ,
                                           String aP7 ,
                                           String aP8 ,
                                           String aP9 )
   {
      getliqdimpcalcu_periodoliqantmismotliq.this.aP10 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        java.math.BigDecimal[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             java.math.BigDecimal[] aP10 )
   {
      getliqdimpcalcu_periodoliqantmismotliq.this.AV13CliCod = aP0;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV8EmpCod = aP1;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV9LiqNro = aP2;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV10LegNumero = aP3;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV18LiqPeriodo = aP4;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV11ConCodigo = aP5;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV20excluirNoAcumuladores = aP6;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV21DTLiqCod = aP7;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV25sacTLiqCod = aP8;
      getliqdimpcalcu_periodoliqantmismotliq.this.AV24adelVacTLiqCod = aP9;
      getliqdimpcalcu_periodoliqantmismotliq.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( GXutil.strcmp(AV21DTLiqCod, AV24adelVacTLiqCod) != 0 ) && ( GXutil.strcmp(AV21DTLiqCod, AV25sacTLiqCod) != 0 ) )
      {
         /* Using cursor P01S62 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV18LiqPeriodo, AV25sacTLiqCod, Integer.valueOf(AV9LiqNro)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A31LiqNro = P01S62_A31LiqNro[0] ;
            A400DTLiqCod = P01S62_A400DTLiqCod[0] ;
            A397DLiqPeriodo = P01S62_A397DLiqPeriodo[0] ;
            A394DConCodigo = P01S62_A394DConCodigo[0] ;
            A6LegNumero = P01S62_A6LegNumero[0] ;
            A1EmpCod = P01S62_A1EmpCod[0] ;
            A3CliCod = P01S62_A3CliCod[0] ;
            A275LiqDImpCalcu = P01S62_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = P01S62_n275LiqDImpCalcu[0] ;
            A81LiqDSecuencial = P01S62_A81LiqDSecuencial[0] ;
            if ( ! AV20excluirNoAcumuladores )
            {
               AV19aplica = true ;
            }
            else
            {
               GXv_boolean1[0] = AV19aplica ;
               new web.gettipoliqacumula(remoteHandle, context).execute( AV13CliCod, A400DTLiqCod, GXv_boolean1) ;
               getliqdimpcalcu_periodoliqantmismotliq.this.AV19aplica = GXv_boolean1[0] ;
            }
            if ( AV19aplica )
            {
               AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A275LiqDImpCalcu) ;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         /* Using cursor P01S63 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV18LiqPeriodo, Integer.valueOf(AV9LiqNro), AV21DTLiqCod});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A31LiqNro = P01S63_A31LiqNro[0] ;
            A400DTLiqCod = P01S63_A400DTLiqCod[0] ;
            A397DLiqPeriodo = P01S63_A397DLiqPeriodo[0] ;
            A394DConCodigo = P01S63_A394DConCodigo[0] ;
            A6LegNumero = P01S63_A6LegNumero[0] ;
            A1EmpCod = P01S63_A1EmpCod[0] ;
            A3CliCod = P01S63_A3CliCod[0] ;
            A275LiqDImpCalcu = P01S63_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = P01S63_n275LiqDImpCalcu[0] ;
            A81LiqDSecuencial = P01S63_A81LiqDSecuencial[0] ;
            if ( ! AV20excluirNoAcumuladores )
            {
               AV19aplica = true ;
            }
            else
            {
               GXv_boolean1[0] = AV19aplica ;
               new web.gettipoliqacumula(remoteHandle, context).execute( AV13CliCod, A400DTLiqCod, GXv_boolean1) ;
               getliqdimpcalcu_periodoliqantmismotliq.this.AV19aplica = GXv_boolean1[0] ;
            }
            if ( AV19aplica )
            {
               AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A275LiqDImpCalcu) ;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      new web.dependenciasesion(remoteHandle, context).execute( AV11ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = getliqdimpcalcu_periodoliqantmismotliq.this.AV12LiqDImpCalcu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqDImpCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01S62_A31LiqNro = new int[1] ;
      P01S62_A400DTLiqCod = new String[] {""} ;
      P01S62_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01S62_A394DConCodigo = new String[] {""} ;
      P01S62_A6LegNumero = new int[1] ;
      P01S62_A1EmpCod = new short[1] ;
      P01S62_A3CliCod = new int[1] ;
      P01S62_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01S62_n275LiqDImpCalcu = new boolean[] {false} ;
      P01S62_A81LiqDSecuencial = new int[1] ;
      A400DTLiqCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      P01S63_A31LiqNro = new int[1] ;
      P01S63_A400DTLiqCod = new String[] {""} ;
      P01S63_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01S63_A394DConCodigo = new String[] {""} ;
      P01S63_A6LegNumero = new int[1] ;
      P01S63_A1EmpCod = new short[1] ;
      P01S63_A3CliCod = new int[1] ;
      P01S63_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01S63_n275LiqDImpCalcu = new boolean[] {false} ;
      P01S63_A81LiqDSecuencial = new int[1] ;
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcu_periodoliqantmismotliq__default(),
         new Object[] {
             new Object[] {
            P01S62_A31LiqNro, P01S62_A400DTLiqCod, P01S62_A397DLiqPeriodo, P01S62_A394DConCodigo, P01S62_A6LegNumero, P01S62_A1EmpCod, P01S62_A3CliCod, P01S62_A275LiqDImpCalcu, P01S62_n275LiqDImpCalcu, P01S62_A81LiqDSecuencial
            }
            , new Object[] {
            P01S63_A31LiqNro, P01S63_A400DTLiqCod, P01S63_A397DLiqPeriodo, P01S63_A394DConCodigo, P01S63_A6LegNumero, P01S63_A1EmpCod, P01S63_A3CliCod, P01S63_A275LiqDImpCalcu, P01S63_n275LiqDImpCalcu, P01S63_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private String AV11ConCodigo ;
   private String AV21DTLiqCod ;
   private String AV25sacTLiqCod ;
   private String AV24adelVacTLiqCod ;
   private String scmdbuf ;
   private String A400DTLiqCod ;
   private String A394DConCodigo ;
   private java.util.Date AV18LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV20excluirNoAcumuladores ;
   private boolean n275LiqDImpCalcu ;
   private boolean AV19aplica ;
   private boolean GXv_boolean1[] ;
   private java.math.BigDecimal[] aP10 ;
   private IDataStoreProvider pr_default ;
   private int[] P01S62_A31LiqNro ;
   private String[] P01S62_A400DTLiqCod ;
   private java.util.Date[] P01S62_A397DLiqPeriodo ;
   private String[] P01S62_A394DConCodigo ;
   private int[] P01S62_A6LegNumero ;
   private short[] P01S62_A1EmpCod ;
   private int[] P01S62_A3CliCod ;
   private java.math.BigDecimal[] P01S62_A275LiqDImpCalcu ;
   private boolean[] P01S62_n275LiqDImpCalcu ;
   private int[] P01S62_A81LiqDSecuencial ;
   private int[] P01S63_A31LiqNro ;
   private String[] P01S63_A400DTLiqCod ;
   private java.util.Date[] P01S63_A397DLiqPeriodo ;
   private String[] P01S63_A394DConCodigo ;
   private int[] P01S63_A6LegNumero ;
   private short[] P01S63_A1EmpCod ;
   private int[] P01S63_A3CliCod ;
   private java.math.BigDecimal[] P01S63_A275LiqDImpCalcu ;
   private boolean[] P01S63_n275LiqDImpCalcu ;
   private int[] P01S63_A81LiqDSecuencial ;
}

final  class getliqdimpcalcu_periodoliqantmismotliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01S62", "SELECT LiqNro, DTLiqCod, DLiqPeriodo, DConCodigo, LegNumero, EmpCod, CliCod, LiqDImpCalcu, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) and DLiqPeriodo = ?) AND (DTLiqCod <> ( ?)) AND (LiqNro < ?) ORDER BY CliCod, EmpCod, LegNumero, DConCodigo, DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01S63", "SELECT LiqNro, DTLiqCod, DLiqPeriodo, DConCodigo, LegNumero, EmpCod, CliCod, LiqDImpCalcu, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) and DLiqPeriodo = ?) AND (LiqNro < ?) AND (DTLiqCod = ( ?)) ORDER BY CliCod, EmpCod, LegNumero, DConCodigo, DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(9);
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
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 20);
               return;
      }
   }

}

