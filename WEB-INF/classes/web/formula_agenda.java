package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formula_agenda extends GXProcedure
{
   public formula_agenda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formula_agenda.class ), "" );
   }

   public formula_agenda( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      formula_agenda.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        java.util.Date aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 )
   {
      formula_agenda.this.AV11CliCod = aP0;
      formula_agenda.this.AV12EmpCod = aP1;
      formula_agenda.this.AV13LegNumero = aP2;
      formula_agenda.this.AV28desdeTipoConCod = aP3;
      formula_agenda.this.AV29hastaTipoConCod = aP4;
      formula_agenda.this.AV23AgeFecDes = aP5;
      formula_agenda.this.AV21AgeFecHas = aP6;
      formula_agenda.this.aP7 = aP7;
      formula_agenda.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV25BasicoConCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.concepto_basico_segunclase(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LegNumero, GXv_char2) ;
      formula_agenda.this.GXt_char1 = GXv_char2[0] ;
      AV25BasicoConCodigo = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "1 &CliCod", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV12EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV13LegNumero, 8, 0))+httpContext.getMessage( "&desdeTipoConCod ", "")+GXutil.trim( AV28desdeTipoConCod)+httpContext.getMessage( " hasta ", "")+GXutil.trim( AV29hastaTipoConCod)+httpContext.getMessage( "hastafech ", "")+GXutil.trim( localUtil.dtoc( AV21AgeFecHas, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( "  desdefec ", "")+GXutil.trim( localUtil.dtoc( AV23AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      /* Using cursor P01882 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LegNumero), AV28desdeTipoConCod, AV29hastaTipoConCod, AV23AgeFecDes, AV21AgeFecHas});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01882_A3CliCod[0] ;
         A1EmpCod = P01882_A1EmpCod[0] ;
         A6LegNumero = P01882_A6LegNumero[0] ;
         A150ConHabilitado = P01882_A150ConHabilitado[0] ;
         A112AgeFecHas = P01882_A112AgeFecHas[0] ;
         n112AgeFecHas = P01882_n112AgeFecHas[0] ;
         A111AgeFecDes = P01882_A111AgeFecDes[0] ;
         n111AgeFecDes = P01882_n111AgeFecDes[0] ;
         A37TipoConCod = P01882_A37TipoConCod[0] ;
         A26ConCodigo = P01882_A26ConCodigo[0] ;
         A113AgeImporte = P01882_A113AgeImporte[0] ;
         n113AgeImporte = P01882_n113AgeImporte[0] ;
         A110AgeCanti = P01882_A110AgeCanti[0] ;
         n110AgeCanti = P01882_n110AgeCanti[0] ;
         A25AgeOrden = P01882_A25AgeOrden[0] ;
         A150ConHabilitado = P01882_A150ConHabilitado[0] ;
         A37TipoConCod = P01882_A37TipoConCod[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "2") ;
         if ( GXutil.strcmp(A26ConCodigo, AV25BasicoConCodigo) == 0 )
         {
            AV26agregoBasico = true ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, A113AgeImporte)==0) )
         {
            AV16Importes = AV16Importes.add(A113AgeImporte) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "3 ConCodigo ", "")+GXutil.trim( A26ConCodigo)) ;
            GXv_decimal3[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char2[0] = "" ;
            GXv_decimal4[0] = AV33auxImportes ;
            GXv_char5[0] = AV19importeStr ;
            new web.previsualizacionnovedad(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LegNumero, A26ConCodigo, A110AgeCanti, DecimalUtil.doubleToDec(0), AV23AgeFecDes, AV21AgeFecHas, true, GXv_decimal3, GXv_char2, GXv_decimal4, GXv_char5) ;
            formula_agenda.this.AV33auxImportes = GXv_decimal4[0] ;
            formula_agenda.this.AV19importeStr = GXv_char5[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "3 &importeStr ", "")+AV19importeStr) ;
            AV16Importes = AV16Importes.add(AV33auxImportes) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( ( GXutil.strcmp(AV29hastaTipoConCod, "REM_ARG") == 0 ) && ! AV26agregoBasico )
      {
         GXv_int6[0] = AV27LegClase ;
         new web.getlegajoclase(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LegNumero, GXv_int6) ;
         formula_agenda.this.AV27LegClase = GXv_int6[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, "4 ") ;
         if ( AV27LegClase == 1 )
         {
            AV30auxAgeCanti = DecimalUtil.doubleToDec(30) ;
         }
         else
         {
            GXv_decimal4[0] = DecimalUtil.doubleToDec(AV31horas_mes) ;
            GXv_char5[0] = "" ;
            GXv_char2[0] = "" ;
            new web.horasmes(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LegNumero, AV14LiqPeriodo, GXv_decimal4, GXv_char5, GXv_char2) ;
            formula_agenda.this.AV31horas_mes = (short)(DecimalUtil.decToDouble(GXv_decimal4[0])) ;
            if ( AV27LegClase == 2 )
            {
               AV34divisor = (short)(2) ;
            }
            else
            {
               if ( AV27LegClase == 3 )
               {
                  AV34divisor = (short)(4) ;
               }
               else
               {
                  GXt_int7 = AV34divisor ;
                  GXv_int8[0] = GXt_int7 ;
                  new web.diasmes(remoteHandle, context).execute( AV11CliCod, AV14LiqPeriodo, GXv_int8) ;
                  formula_agenda.this.GXt_int7 = GXv_int8[0] ;
                  AV34divisor = GXt_int7 ;
               }
            }
            AV30auxAgeCanti = DecimalUtil.doubleToDec(AV31horas_mes/ (double) (AV34divisor)) ;
         }
         GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char5[0] = "" ;
         GXv_decimal3[0] = AV33auxImportes ;
         GXv_char2[0] = AV19importeStr ;
         new web.previsualizacionnovedad(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LegNumero, AV25BasicoConCodigo, AV30auxAgeCanti, DecimalUtil.doubleToDec(0), AV23AgeFecDes, AV21AgeFecHas, true, GXv_decimal4, GXv_char5, GXv_decimal3, GXv_char2) ;
         formula_agenda.this.AV33auxImportes = GXv_decimal3[0] ;
         formula_agenda.this.AV19importeStr = GXv_char2[0] ;
         AV16Importes = AV16Importes.add(AV33auxImportes) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV37Pgmname, httpContext.getMessage( "5 &importeStr ", "")+AV19importeStr) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = formula_agenda.this.AV16Importes;
      this.aP8[0] = formula_agenda.this.AV10LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16Importes = DecimalUtil.ZERO ;
      AV10LiqDLog = "" ;
      AV25BasicoConCodigo = "" ;
      GXt_char1 = "" ;
      AV37Pgmname = "" ;
      scmdbuf = "" ;
      P01882_A3CliCod = new int[1] ;
      P01882_A1EmpCod = new short[1] ;
      P01882_A6LegNumero = new int[1] ;
      P01882_A150ConHabilitado = new boolean[] {false} ;
      P01882_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P01882_n112AgeFecHas = new boolean[] {false} ;
      P01882_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P01882_n111AgeFecDes = new boolean[] {false} ;
      P01882_A37TipoConCod = new String[] {""} ;
      P01882_A26ConCodigo = new String[] {""} ;
      P01882_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01882_n113AgeImporte = new boolean[] {false} ;
      P01882_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01882_n110AgeCanti = new boolean[] {false} ;
      P01882_A25AgeOrden = new short[1] ;
      A112AgeFecHas = GXutil.nullDate() ;
      A111AgeFecDes = GXutil.nullDate() ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      A113AgeImporte = DecimalUtil.ZERO ;
      A110AgeCanti = DecimalUtil.ZERO ;
      AV33auxImportes = DecimalUtil.ZERO ;
      AV19importeStr = "" ;
      GXv_int6 = new byte[1] ;
      AV30auxAgeCanti = DecimalUtil.ZERO ;
      AV14LiqPeriodo = GXutil.nullDate() ;
      GXv_int8 = new short[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_char5 = new String[1] ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.formula_agenda__default(),
         new Object[] {
             new Object[] {
            P01882_A3CliCod, P01882_A1EmpCod, P01882_A6LegNumero, P01882_A150ConHabilitado, P01882_A112AgeFecHas, P01882_n112AgeFecHas, P01882_A111AgeFecDes, P01882_n111AgeFecDes, P01882_A37TipoConCod, P01882_A26ConCodigo,
            P01882_A113AgeImporte, P01882_n113AgeImporte, P01882_A110AgeCanti, P01882_n110AgeCanti, P01882_A25AgeOrden
            }
         }
      );
      AV37Pgmname = "formula_agenda" ;
      /* GeneXus formulas. */
      AV37Pgmname = "formula_agenda" ;
      Gx_err = (short)(0) ;
   }

   private byte AV27LegClase ;
   private byte GXv_int6[] ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short AV31horas_mes ;
   private short AV34divisor ;
   private short GXt_int7 ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV13LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV16Importes ;
   private java.math.BigDecimal A113AgeImporte ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal AV33auxImportes ;
   private java.math.BigDecimal AV30auxAgeCanti ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV28desdeTipoConCod ;
   private String AV29hastaTipoConCod ;
   private String AV25BasicoConCodigo ;
   private String GXt_char1 ;
   private String AV37Pgmname ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String AV19importeStr ;
   private String GXv_char5[] ;
   private String GXv_char2[] ;
   private java.util.Date AV23AgeFecDes ;
   private java.util.Date AV21AgeFecHas ;
   private java.util.Date A112AgeFecHas ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean A150ConHabilitado ;
   private boolean n112AgeFecHas ;
   private boolean n111AgeFecDes ;
   private boolean n113AgeImporte ;
   private boolean n110AgeCanti ;
   private boolean AV26agregoBasico ;
   private String AV10LiqDLog ;
   private String[] aP8 ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P01882_A3CliCod ;
   private short[] P01882_A1EmpCod ;
   private int[] P01882_A6LegNumero ;
   private boolean[] P01882_A150ConHabilitado ;
   private java.util.Date[] P01882_A112AgeFecHas ;
   private boolean[] P01882_n112AgeFecHas ;
   private java.util.Date[] P01882_A111AgeFecDes ;
   private boolean[] P01882_n111AgeFecDes ;
   private String[] P01882_A37TipoConCod ;
   private String[] P01882_A26ConCodigo ;
   private java.math.BigDecimal[] P01882_A113AgeImporte ;
   private boolean[] P01882_n113AgeImporte ;
   private java.math.BigDecimal[] P01882_A110AgeCanti ;
   private boolean[] P01882_n110AgeCanti ;
   private short[] P01882_A25AgeOrden ;
}

final  class formula_agenda__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01882", "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T2.ConHabilitado, T1.AgeFecHas, T1.AgeFecDes, T2.TipoConCod, T1.ConCodigo, T1.AgeImporte, T1.AgeCanti, T1.AgeOrden FROM (AgendaNovedades T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.ConCodigo) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T2.TipoConCod >= ( ?)) AND (T2.TipoConCod <= ( ?)) AND (T1.AgeFecHas >= ? or (T1.AgeFecHas = DATE '00010101') or T1.AgeFecHas IS NULL) AND (T2.ConHabilitado = TRUE) AND (T1.AgeFecDes <= ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.AgeFecDes ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((String[]) buf[9])[0] = rslt.getString(8, 10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(11);
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
               stmt.setString(5, (String)parms[4], 20);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
      }
   }

}

