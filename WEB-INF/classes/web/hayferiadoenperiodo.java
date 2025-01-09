package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayferiadoenperiodo extends GXProcedure
{
   public hayferiadoenperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayferiadoenperiodo.class ), "" );
   }

   public hayferiadoenperiodo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              int aP3 ,
                              java.util.Date aP4 ,
                              String aP5 ,
                              boolean aP6 ,
                              boolean[] aP7 )
   {
      hayferiadoenperiodo.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        boolean[] aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             boolean[] aP7 ,
                             boolean[] aP8 )
   {
      hayferiadoenperiodo.this.AV14CliCod = aP0;
      hayferiadoenperiodo.this.AV15EmpCod = aP1;
      hayferiadoenperiodo.this.AV18TLiqCod = aP2;
      hayferiadoenperiodo.this.AV17LegNumero = aP3;
      hayferiadoenperiodo.this.AV20LiqPeriodo = aP4;
      hayferiadoenperiodo.this.AV30tipo_feriado = aP5;
      hayferiadoenperiodo.this.AV31chequearConPlus = aP6;
      hayferiadoenperiodo.this.aP7 = aP7;
      hayferiadoenperiodo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV8PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getpaicod(remoteHandle, context).execute( AV14CliCod, GXv_int2) ;
      hayferiadoenperiodo.this.GXt_int1 = GXv_int2[0] ;
      AV8PaiCod = GXt_int1 ;
      GXv_int3[0] = AV19LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, GXv_int3) ;
      hayferiadoenperiodo.this.AV19LegClase = GXv_int3[0] ;
      GXv_date4[0] = AV9desdeFerFecha ;
      GXv_date5[0] = AV10hastaFerFecha ;
      new web.getrangoperiodos(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, 0, AV17LegNumero, AV18TLiqCod, AV19LegClase, AV20LiqPeriodo, false, GXv_date4, GXv_date5) ;
      hayferiadoenperiodo.this.AV9desdeFerFecha = GXv_date4[0] ;
      hayferiadoenperiodo.this.AV10hastaFerFecha = GXv_date5[0] ;
      GXv_char6[0] = AV24LegConveCodigo ;
      GXv_char7[0] = AV26LegReligion ;
      GXv_char8[0] = AV25LegOrigen ;
      GXv_boolean9[0] = AV23empresaliquidaReligion ;
      GXv_boolean10[0] = AV22empresaliquidaOrigen ;
      GXv_boolean11[0] = AV21empresaliquidaConvenio ;
      new web.getreligorigconvenio(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, AV8PaiCod, GXv_char6, GXv_char7, GXv_char8, GXv_boolean9, GXv_boolean10, GXv_boolean11) ;
      hayferiadoenperiodo.this.AV24LegConveCodigo = GXv_char6[0] ;
      hayferiadoenperiodo.this.AV26LegReligion = GXv_char7[0] ;
      hayferiadoenperiodo.this.AV25LegOrigen = GXv_char8[0] ;
      hayferiadoenperiodo.this.AV23empresaliquidaReligion = GXv_boolean9[0] ;
      hayferiadoenperiodo.this.AV22empresaliquidaOrigen = GXv_boolean10[0] ;
      hayferiadoenperiodo.this.AV21empresaliquidaConvenio = GXv_boolean11[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&PaiCod ", "")+GXutil.trim( GXutil.str( AV8PaiCod, 4, 0))+httpContext.getMessage( " desde ", "")+GXutil.trim( localUtil.dtoc( AV9desdeFerFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " hasta ", "")+GXutil.trim( localUtil.dtoc( AV10hastaFerFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &tipo_feriado ", "")+GXutil.trim( AV30tipo_feriado)) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV30tipo_feriado ,
                                           A1233FeriadoTipo ,
                                           A1227FerFecha ,
                                           AV9desdeFerFecha ,
                                           AV10hastaFerFecha ,
                                           Short.valueOf(AV8PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01BB2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV9desdeFerFecha, AV10hastaFerFecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1223FerId = P01BB2_A1223FerId[0] ;
         A1233FeriadoTipo = P01BB2_A1233FeriadoTipo[0] ;
         A1227FerFecha = P01BB2_A1227FerFecha[0] ;
         A46PaiCod = P01BB2_A46PaiCod[0] ;
         A1230FerReligId = P01BB2_A1230FerReligId[0] ;
         n1230FerReligId = P01BB2_n1230FerReligId[0] ;
         A1232FerOrigId = P01BB2_A1232FerOrigId[0] ;
         n1232FerOrigId = P01BB2_n1232FerOrigId[0] ;
         A1234FeriadoConvenio = P01BB2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BB2_n1234FeriadoConvenio[0] ;
         A1226FerAnio = P01BB2_A1226FerAnio[0] ;
         A1233FeriadoTipo = P01BB2_A1233FeriadoTipo[0] ;
         A1230FerReligId = P01BB2_A1230FerReligId[0] ;
         n1230FerReligId = P01BB2_n1230FerReligId[0] ;
         A1232FerOrigId = P01BB2_A1232FerOrigId[0] ;
         n1232FerOrigId = P01BB2_n1232FerOrigId[0] ;
         A1234FeriadoConvenio = P01BB2_A1234FeriadoConvenio[0] ;
         n1234FeriadoConvenio = P01BB2_n1234FeriadoConvenio[0] ;
         GXv_boolean11[0] = AV27liquida ;
         new web.evaluanolaborable(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, A1227FerFecha, AV19LegClase, A1230FerReligId, AV26LegReligion, AV23empresaliquidaReligion, A1232FerOrigId, AV25LegOrigen, AV22empresaliquidaOrigen, A1234FeriadoConvenio, AV24LegConveCodigo, AV21empresaliquidaConvenio, GXv_boolean11) ;
         hayferiadoenperiodo.this.AV27liquida = GXv_boolean11[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "FerFecha ", "")+GXutil.trim( localUtil.dtoc( A1227FerFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &liquida ", "")+GXutil.trim( GXutil.booltostr( AV27liquida))) ;
         if ( AV27liquida )
         {
            AV29hayFeriadoTrabajado = false ;
            GXv_boolean11[0] = AV12hayLicenciaQueAbsorbe ;
            GXv_char8[0] = "" ;
            new web.haylicenciaqueabsorbefer(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, A1227FerFecha, A1227FerFecha, GXv_boolean11, GXv_char8) ;
            hayferiadoenperiodo.this.AV12hayLicenciaQueAbsorbe = GXv_boolean11[0] ;
            if ( ! AV12hayLicenciaQueAbsorbe )
            {
               GXv_boolean11[0] = AV29hayFeriadoTrabajado ;
               new web.hayferiadotrabajado(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, A1227FerFecha, A1227FerFecha, GXv_boolean11) ;
               hayferiadoenperiodo.this.AV29hayFeriadoTrabajado = GXv_boolean11[0] ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "1") ;
            if ( ! AV12hayLicenciaQueAbsorbe && ! AV29hayFeriadoTrabajado )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "2") ;
               AV13hay = true ;
               if ( AV31chequearConPlus )
               {
                  GXv_char8[0] = AV34ConveCodigo ;
                  new web.empleadogetconvenio(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV17LegNumero, GXv_char8) ;
                  hayferiadoenperiodo.this.AV34ConveCodigo = GXv_char8[0] ;
                  if ( GXutil.strcmp(A1233FeriadoTipo, "nolaborable") == 0 )
                  {
                     GXt_char12 = AV35codigo1Palabra ;
                     GXv_char8[0] = GXt_char12 ;
                     new web.palabracod1nolaborableopcional(remoteHandle, context).execute( AV14CliCod, GXv_char8) ;
                     hayferiadoenperiodo.this.GXt_char12 = GXv_char8[0] ;
                     AV35codigo1Palabra = GXt_char12 ;
                  }
                  else
                  {
                     GXt_char12 = AV35codigo1Palabra ;
                     GXv_char8[0] = GXt_char12 ;
                     new web.palabracod1feriadoobligatorio(remoteHandle, context).execute( AV14CliCod, GXv_char8) ;
                     hayferiadoenperiodo.this.GXt_char12 = GXv_char8[0] ;
                     AV35codigo1Palabra = GXt_char12 ;
                  }
                  GXv_decimal13[0] = AV32LiqDPlus ;
                  new web.getplusdebasedecalculo(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LiqNro, AV17LegNumero, AV8PaiCod, AV34ConveCodigo, AV19LegClase, "feriado", AV35codigo1Palabra, httpContext.getMessage( "No Trabajado", ""), GXv_decimal13) ;
                  hayferiadoenperiodo.this.AV32LiqDPlus = GXv_decimal13[0] ;
                  if ( AV32LiqDPlus.doubleValue() > 0 )
                  {
                     AV33hayConPlus = true ;
                  }
               }
               if ( ! AV31chequearConPlus || ( AV32LiqDPlus.doubleValue() > 0 ) )
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = hayferiadoenperiodo.this.AV13hay;
      this.aP8[0] = hayferiadoenperiodo.this.AV33hayConPlus;
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
      AV9desdeFerFecha = GXutil.nullDate() ;
      GXv_date4 = new java.util.Date[1] ;
      AV10hastaFerFecha = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV24LegConveCodigo = "" ;
      GXv_char6 = new String[1] ;
      AV26LegReligion = "" ;
      GXv_char7 = new String[1] ;
      AV25LegOrigen = "" ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      AV38Pgmname = "" ;
      scmdbuf = "" ;
      A1233FeriadoTipo = "" ;
      A1227FerFecha = GXutil.nullDate() ;
      P01BB2_A1223FerId = new String[] {""} ;
      P01BB2_A1233FeriadoTipo = new String[] {""} ;
      P01BB2_A1227FerFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01BB2_A46PaiCod = new short[1] ;
      P01BB2_A1230FerReligId = new String[] {""} ;
      P01BB2_n1230FerReligId = new boolean[] {false} ;
      P01BB2_A1232FerOrigId = new String[] {""} ;
      P01BB2_n1232FerOrigId = new boolean[] {false} ;
      P01BB2_A1234FeriadoConvenio = new String[] {""} ;
      P01BB2_n1234FeriadoConvenio = new boolean[] {false} ;
      P01BB2_A1226FerAnio = new short[1] ;
      A1223FerId = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      A1234FeriadoConvenio = "" ;
      GXv_boolean11 = new boolean[1] ;
      AV34ConveCodigo = "" ;
      AV35codigo1Palabra = "" ;
      GXt_char12 = "" ;
      GXv_char8 = new String[1] ;
      AV32LiqDPlus = DecimalUtil.ZERO ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayferiadoenperiodo__default(),
         new Object[] {
             new Object[] {
            P01BB2_A1223FerId, P01BB2_A1233FeriadoTipo, P01BB2_A1227FerFecha, P01BB2_A46PaiCod, P01BB2_A1230FerReligId, P01BB2_n1230FerReligId, P01BB2_A1232FerOrigId, P01BB2_n1232FerOrigId, P01BB2_A1234FeriadoConvenio, P01BB2_n1234FeriadoConvenio,
            P01BB2_A1226FerAnio
            }
         }
      );
      AV38Pgmname = "hayFeriadoEnPeriodo" ;
      /* GeneXus formulas. */
      AV38Pgmname = "hayFeriadoEnPeriodo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19LegClase ;
   private byte GXv_int3[] ;
   private short AV15EmpCod ;
   private short AV8PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short A1226FerAnio ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV17LegNumero ;
   private int AV16LiqNro ;
   private java.math.BigDecimal AV32LiqDPlus ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private String AV18TLiqCod ;
   private String AV30tipo_feriado ;
   private String AV24LegConveCodigo ;
   private String GXv_char6[] ;
   private String AV26LegReligion ;
   private String GXv_char7[] ;
   private String AV25LegOrigen ;
   private String AV38Pgmname ;
   private String scmdbuf ;
   private String A1233FeriadoTipo ;
   private String A1223FerId ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String A1234FeriadoConvenio ;
   private String AV34ConveCodigo ;
   private String AV35codigo1Palabra ;
   private String GXt_char12 ;
   private String GXv_char8[] ;
   private java.util.Date AV20LiqPeriodo ;
   private java.util.Date AV9desdeFerFecha ;
   private java.util.Date GXv_date4[] ;
   private java.util.Date AV10hastaFerFecha ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date A1227FerFecha ;
   private boolean AV31chequearConPlus ;
   private boolean AV13hay ;
   private boolean AV33hayConPlus ;
   private boolean AV23empresaliquidaReligion ;
   private boolean GXv_boolean9[] ;
   private boolean AV22empresaliquidaOrigen ;
   private boolean GXv_boolean10[] ;
   private boolean AV21empresaliquidaConvenio ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private boolean n1234FeriadoConvenio ;
   private boolean AV27liquida ;
   private boolean AV29hayFeriadoTrabajado ;
   private boolean AV12hayLicenciaQueAbsorbe ;
   private boolean GXv_boolean11[] ;
   private boolean[] aP8 ;
   private boolean[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BB2_A1223FerId ;
   private String[] P01BB2_A1233FeriadoTipo ;
   private java.util.Date[] P01BB2_A1227FerFecha ;
   private short[] P01BB2_A46PaiCod ;
   private String[] P01BB2_A1230FerReligId ;
   private boolean[] P01BB2_n1230FerReligId ;
   private String[] P01BB2_A1232FerOrigId ;
   private boolean[] P01BB2_n1232FerOrigId ;
   private String[] P01BB2_A1234FeriadoConvenio ;
   private boolean[] P01BB2_n1234FeriadoConvenio ;
   private short[] P01BB2_A1226FerAnio ;
}

final  class hayferiadoenperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01BB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV30tipo_feriado ,
                                          String A1233FeriadoTipo ,
                                          java.util.Date A1227FerFecha ,
                                          java.util.Date AV9desdeFerFecha ,
                                          java.util.Date AV10hastaFerFecha ,
                                          short AV8PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[3];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.FerId, T2.FeriadoTipo, T1.FerFecha, T1.PaiCod, T2.FerReligId, T2.FerOrigId, T2.FeriadoConvenio, T1.FerAnio FROM (feriado_agenda T1 INNER JOIN feriado T2" ;
      scmdbuf += " ON T2.PaiCod = T1.PaiCod AND T2.FerId = T1.FerId)" ;
      addWhere(sWhereString, "(T1.PaiCod = ?)");
      addWhere(sWhereString, "(T1.FerFecha >= ?)");
      addWhere(sWhereString, "(T1.FerFecha <= ?)");
      if ( GXutil.strcmp(AV30tipo_feriado, "nolaborable") == 0 )
      {
         addWhere(sWhereString, "(T2.FeriadoTipo = ( 'nolaborable'))");
      }
      if ( ! (GXutil.strcmp("", AV30tipo_feriado)==0) && ( GXutil.strcmp(AV30tipo_feriado, "nolaborable") != 0 ) )
      {
         addWhere(sWhereString, "(T2.FeriadoTipo <> ( 'nolaborable'))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.PaiCod" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01BB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[4]);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[5]);
               }
               return;
      }
   }

}

