package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelveconceptosporhabitualidad extends GXProcedure
{
   public devuelveconceptosporhabitualidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelveconceptosporhabitualidad.class ), "" );
   }

   public devuelveconceptosporhabitualidad( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 ,
                                                 int aP2 ,
                                                 java.util.Date aP3 ,
                                                 java.util.Date aP4 ,
                                                 String aP5 )
   {
      devuelveconceptosporhabitualidad.this.aP6 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        GXSimpleCollection<String>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             GXSimpleCollection<String>[] aP6 )
   {
      devuelveconceptosporhabitualidad.this.AV10CliCod = aP0;
      devuelveconceptosporhabitualidad.this.AV11EmpCod = aP1;
      devuelveconceptosporhabitualidad.this.AV12LegNumero = aP2;
      devuelveconceptosporhabitualidad.this.AV14desde_LiqPeriodo = aP3;
      devuelveconceptosporhabitualidad.this.AV9hasta_LiqPeriodo = aP4;
      devuelveconceptosporhabitualidad.this.AV20devolver = aP5;
      devuelveconceptosporhabitualidad.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8cantidadDePeriodos = (short)(0) ;
      GXv_char1[0] = AV22ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( ), GXv_char1) ;
      devuelveconceptosporhabitualidad.this.AV22ParmValue = GXv_char1[0] ;
      AV21proporcionHabitualPorUnaje = CommonUtil.decimalVal( AV22ParmValue, ".") ;
      /* Using cursor P00Y12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LegNumero), AV14desde_LiqPeriodo, AV9hasta_LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkY12 = false ;
         A3CliCod = P00Y12_A3CliCod[0] ;
         A1EmpCod = P00Y12_A1EmpCod[0] ;
         A6LegNumero = P00Y12_A6LegNumero[0] ;
         A397DLiqPeriodo = P00Y12_A397DLiqPeriodo[0] ;
         A31LiqNro = P00Y12_A31LiqNro[0] ;
         A81LiqDSecuencial = P00Y12_A81LiqDSecuencial[0] ;
         while ( (pr_default.getStatus(0) != 101) && ( P00Y12_A3CliCod[0] == A3CliCod ) && ( P00Y12_A1EmpCod[0] == A1EmpCod ) && ( P00Y12_A6LegNumero[0] == A6LegNumero ) && GXutil.dateCompare(GXutil.resetTime(P00Y12_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) )
         {
            brkY12 = false ;
            A31LiqNro = P00Y12_A31LiqNro[0] ;
            A81LiqDSecuencial = P00Y12_A81LiqDSecuencial[0] ;
            brkY12 = true ;
            pr_default.readNext(0);
         }
         AV8cantidadDePeriodos = (short)(AV8cantidadDePeriodos+1) ;
         if ( ! brkY12 )
         {
            brkY12 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      /* Using cursor P00Y13 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV12LegNumero), AV14desde_LiqPeriodo, AV9hasta_LiqPeriodo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkY14 = false ;
         A397DLiqPeriodo = P00Y13_A397DLiqPeriodo[0] ;
         A394DConCodigo = P00Y13_A394DConCodigo[0] ;
         A6LegNumero = P00Y13_A6LegNumero[0] ;
         A1EmpCod = P00Y13_A1EmpCod[0] ;
         A3CliCod = P00Y13_A3CliCod[0] ;
         A464DTipoConCod = P00Y13_A464DTipoConCod[0] ;
         A31LiqNro = P00Y13_A31LiqNro[0] ;
         A81LiqDSecuencial = P00Y13_A81LiqDSecuencial[0] ;
         AV19cantidadDeVecesLiquidado = (short)(0) ;
         while ( (pr_default.getStatus(1) != 101) && ( P00Y13_A3CliCod[0] == A3CliCod ) && ( P00Y13_A1EmpCod[0] == A1EmpCod ) && ( P00Y13_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P00Y13_A394DConCodigo[0], A394DConCodigo) == 0 ) )
         {
            brkY14 = false ;
            A397DLiqPeriodo = P00Y13_A397DLiqPeriodo[0] ;
            A31LiqNro = P00Y13_A31LiqNro[0] ;
            A81LiqDSecuencial = P00Y13_A81LiqDSecuencial[0] ;
            while ( (pr_default.getStatus(1) != 101) && ( P00Y13_A3CliCod[0] == A3CliCod ) && ( P00Y13_A1EmpCod[0] == A1EmpCod ) && ( P00Y13_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P00Y13_A394DConCodigo[0], A394DConCodigo) == 0 ) )
            {
               if ( ! ( GXutil.dateCompare(GXutil.resetTime(P00Y13_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) ) )
               {
                  if (true) break;
               }
               brkY14 = false ;
               A31LiqNro = P00Y13_A31LiqNro[0] ;
               A81LiqDSecuencial = P00Y13_A81LiqDSecuencial[0] ;
               brkY14 = true ;
               pr_default.readNext(1);
            }
            AV19cantidadDeVecesLiquidado = (short)(AV19cantidadDeVecesLiquidado+1) ;
            if ( ! brkY14 )
            {
               brkY14 = true ;
               pr_default.readNext(1);
            }
         }
         if ( GXutil.strcmp(AV20devolver, httpContext.getMessage( "HABITUALES", "")) == 0 )
         {
            if ( AV19cantidadDeVecesLiquidado > (DecimalUtil.doubleToDec(AV8cantidadDePeriodos).multiply(AV21proporcionHabitualPorUnaje)).doubleValue() )
            {
               AV15conceptos.add(A394DConCodigo, 0);
            }
         }
         else
         {
            if ( AV19cantidadDeVecesLiquidado <= (DecimalUtil.doubleToDec(AV8cantidadDePeriodos).multiply(AV21proporcionHabitualPorUnaje)).doubleValue() )
            {
               if ( ! (AV23forzadosHabConCodigo.indexof(GXutil.rtrim( A394DConCodigo))>0) )
               {
                  AV15conceptos.add(A394DConCodigo, 0);
               }
            }
         }
         if ( ! brkY14 )
         {
            brkY14 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
      if ( GXutil.strcmp(AV20devolver, httpContext.getMessage( "HABITUALES", "")) == 0 )
      {
         GXt_char2 = AV22ParmValue ;
         GXt_char3 = AV22ParmValue ;
         GXv_char1[0] = GXt_char3 ;
         new web.forzados_habitual_param(remoteHandle, context).execute( GXv_char1) ;
         devuelveconceptosporhabitualidad.this.GXt_char3 = GXv_char1[0] ;
         GXv_char4[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char3, GXv_char4) ;
         devuelveconceptosporhabitualidad.this.GXt_char2 = GXv_char4[0] ;
         AV22ParmValue = GXt_char2 ;
         AV23forzadosHabConCodigo.fromJSonString(AV22ParmValue, null);
         AV24i = (short)(1) ;
         while ( AV24i <= AV23forzadosHabConCodigo.size() )
         {
            AV15conceptos.add((String)AV23forzadosHabConCodigo.elementAt(-1+AV24i), 0);
            AV24i = (short)(AV24i+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = devuelveconceptosporhabitualidad.this.AV15conceptos;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15conceptos = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22ParmValue = "" ;
      AV21proporcionHabitualPorUnaje = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00Y12_A3CliCod = new int[1] ;
      P00Y12_A1EmpCod = new short[1] ;
      P00Y12_A6LegNumero = new int[1] ;
      P00Y12_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00Y12_A31LiqNro = new int[1] ;
      P00Y12_A81LiqDSecuencial = new int[1] ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      P00Y13_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00Y13_A394DConCodigo = new String[] {""} ;
      P00Y13_A6LegNumero = new int[1] ;
      P00Y13_A1EmpCod = new short[1] ;
      P00Y13_A3CliCod = new int[1] ;
      P00Y13_A464DTipoConCod = new String[] {""} ;
      P00Y13_A31LiqNro = new int[1] ;
      P00Y13_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      AV23forzadosHabConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_char2 = "" ;
      GXt_char3 = "" ;
      GXv_char1 = new String[1] ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.devuelveconceptosporhabitualidad__default(),
         new Object[] {
             new Object[] {
            P00Y12_A3CliCod, P00Y12_A1EmpCod, P00Y12_A6LegNumero, P00Y12_A397DLiqPeriodo, P00Y12_A31LiqNro, P00Y12_A81LiqDSecuencial
            }
            , new Object[] {
            P00Y13_A397DLiqPeriodo, P00Y13_A394DConCodigo, P00Y13_A6LegNumero, P00Y13_A1EmpCod, P00Y13_A3CliCod, P00Y13_A464DTipoConCod, P00Y13_A31LiqNro, P00Y13_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV8cantidadDePeriodos ;
   private short A1EmpCod ;
   private short AV19cantidadDeVecesLiquidado ;
   private short AV24i ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV21proporcionHabitualPorUnaje ;
   private String AV20devolver ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String GXt_char2 ;
   private String GXt_char3 ;
   private String GXv_char1[] ;
   private String GXv_char4[] ;
   private java.util.Date AV14desde_LiqPeriodo ;
   private java.util.Date AV9hasta_LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean brkY12 ;
   private boolean brkY14 ;
   private String AV22ParmValue ;
   private GXSimpleCollection<String> AV23forzadosHabConCodigo ;
   private GXSimpleCollection<String>[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P00Y12_A3CliCod ;
   private short[] P00Y12_A1EmpCod ;
   private int[] P00Y12_A6LegNumero ;
   private java.util.Date[] P00Y12_A397DLiqPeriodo ;
   private int[] P00Y12_A31LiqNro ;
   private int[] P00Y12_A81LiqDSecuencial ;
   private java.util.Date[] P00Y13_A397DLiqPeriodo ;
   private String[] P00Y13_A394DConCodigo ;
   private int[] P00Y13_A6LegNumero ;
   private short[] P00Y13_A1EmpCod ;
   private int[] P00Y13_A3CliCod ;
   private String[] P00Y13_A464DTipoConCod ;
   private int[] P00Y13_A31LiqNro ;
   private int[] P00Y13_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV15conceptos ;
}

final  class devuelveconceptosporhabitualidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00Y12", "SELECT CliCod, EmpCod, LegNumero, DLiqPeriodo, LiqNro, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and DLiqPeriodo >= ?) AND (DLiqPeriodo <= ?) ORDER BY CliCod, EmpCod, LegNumero, DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00Y13", "SELECT DLiqPeriodo, DConCodigo, LegNumero, EmpCod, CliCod, DTipoConCod, LiqNro, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (DLiqPeriodo >= ?) AND (DLiqPeriodo <= ?) AND (DTipoConCod = ( 'REM_ARG') or DTipoConCod = ( 'NRE_ARG')) ORDER BY CliCod, EmpCod, LegNumero, DConCodigo, DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

