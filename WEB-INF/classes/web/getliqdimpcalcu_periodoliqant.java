package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcu_periodoliqant extends GXProcedure
{
   public getliqdimpcalcu_periodoliqant( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcu_periodoliqant.class ), "" );
   }

   public getliqdimpcalcu_periodoliqant( int remoteHandle ,
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
                                           boolean aP6 )
   {
      getliqdimpcalcu_periodoliqant.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      getliqdimpcalcu_periodoliqant.this.AV13CliCod = aP0;
      getliqdimpcalcu_periodoliqant.this.AV8EmpCod = aP1;
      getliqdimpcalcu_periodoliqant.this.AV9LiqNro = aP2;
      getliqdimpcalcu_periodoliqant.this.AV10LegNumero = aP3;
      getliqdimpcalcu_periodoliqant.this.AV18LiqPeriodo = aP4;
      getliqdimpcalcu_periodoliqant.this.AV11ConCodigo = aP5;
      getliqdimpcalcu_periodoliqant.this.AV20excluirNoAcumuladores = aP6;
      getliqdimpcalcu_periodoliqant.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P015D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV18LiqPeriodo, Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P015D2_A31LiqNro[0] ;
         A397DLiqPeriodo = P015D2_A397DLiqPeriodo[0] ;
         A394DConCodigo = P015D2_A394DConCodigo[0] ;
         A6LegNumero = P015D2_A6LegNumero[0] ;
         A1EmpCod = P015D2_A1EmpCod[0] ;
         A3CliCod = P015D2_A3CliCod[0] ;
         A400DTLiqCod = P015D2_A400DTLiqCod[0] ;
         A275LiqDImpCalcu = P015D2_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P015D2_n275LiqDImpCalcu[0] ;
         A81LiqDSecuencial = P015D2_A81LiqDSecuencial[0] ;
         if ( ! AV20excluirNoAcumuladores )
         {
            AV19aplica = true ;
         }
         else
         {
            GXv_boolean1[0] = AV19aplica ;
            new web.gettipoliqacumula(remoteHandle, context).execute( AV13CliCod, A400DTLiqCod, GXv_boolean1) ;
            getliqdimpcalcu_periodoliqant.this.AV19aplica = GXv_boolean1[0] ;
         }
         if ( AV19aplica )
         {
            AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A275LiqDImpCalcu) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.dependenciasesion(remoteHandle, context).execute( AV11ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getliqdimpcalcu_periodoliqant.this.AV12LiqDImpCalcu;
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
      P015D2_A31LiqNro = new int[1] ;
      P015D2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P015D2_A394DConCodigo = new String[] {""} ;
      P015D2_A6LegNumero = new int[1] ;
      P015D2_A1EmpCod = new short[1] ;
      P015D2_A3CliCod = new int[1] ;
      P015D2_A400DTLiqCod = new String[] {""} ;
      P015D2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P015D2_n275LiqDImpCalcu = new boolean[] {false} ;
      P015D2_A81LiqDSecuencial = new int[1] ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A400DTLiqCod = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcu_periodoliqant__default(),
         new Object[] {
             new Object[] {
            P015D2_A31LiqNro, P015D2_A397DLiqPeriodo, P015D2_A394DConCodigo, P015D2_A6LegNumero, P015D2_A1EmpCod, P015D2_A3CliCod, P015D2_A400DTLiqCod, P015D2_A275LiqDImpCalcu, P015D2_n275LiqDImpCalcu, P015D2_A81LiqDSecuencial
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
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A400DTLiqCod ;
   private java.util.Date AV18LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV20excluirNoAcumuladores ;
   private boolean n275LiqDImpCalcu ;
   private boolean AV19aplica ;
   private boolean GXv_boolean1[] ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P015D2_A31LiqNro ;
   private java.util.Date[] P015D2_A397DLiqPeriodo ;
   private String[] P015D2_A394DConCodigo ;
   private int[] P015D2_A6LegNumero ;
   private short[] P015D2_A1EmpCod ;
   private int[] P015D2_A3CliCod ;
   private String[] P015D2_A400DTLiqCod ;
   private java.math.BigDecimal[] P015D2_A275LiqDImpCalcu ;
   private boolean[] P015D2_n275LiqDImpCalcu ;
   private int[] P015D2_A81LiqDSecuencial ;
}

final  class getliqdimpcalcu_periodoliqant__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P015D2", "SELECT LiqNro, DLiqPeriodo, DConCodigo, LegNumero, EmpCod, CliCod, DTLiqCod, LiqDImpCalcu, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DConCodigo = ( ?) and DLiqPeriodo = ?) AND (LiqNro < ?) ORDER BY CliCod, EmpCod, LegNumero, DConCodigo, DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
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
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

