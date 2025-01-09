package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtbasicovalorhora extends GXProcedure
{
   public obtbasicovalorhora( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtbasicovalorhora.class ), "" );
   }

   public obtbasicovalorhora( int remoteHandle ,
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
                                           String[] aP6 )
   {
      obtbasicovalorhora.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String[] aP6 ,
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
                             String[] aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      obtbasicovalorhora.this.AV11CliCod = aP0;
      obtbasicovalorhora.this.AV8EmpCod = aP1;
      obtbasicovalorhora.this.AV20LiqNro = aP2;
      obtbasicovalorhora.this.AV9LegNumero = aP3;
      obtbasicovalorhora.this.AV14LiqPeriodo = aP4;
      obtbasicovalorhora.this.AV19que = aP5;
      obtbasicovalorhora.this.aP6 = aP6;
      obtbasicovalorhora.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10valorHora = DecimalUtil.ZERO ;
      GXv_char1[0] = AV21LegCatCodigo ;
      GXv_char2[0] = AV22LegConveCodigo ;
      new web.obtcategorialegajo(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV20LiqNro, AV9LegNumero, GXv_char1, GXv_char2) ;
      obtbasicovalorhora.this.AV21LegCatCodigo = GXv_char1[0] ;
      obtbasicovalorhora.this.AV22LegConveCodigo = GXv_char2[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "1") ;
      /* Using cursor P00PK2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00PK2_A6LegNumero[0] ;
         A1EmpCod = P00PK2_A1EmpCod[0] ;
         A3CliCod = P00PK2_A3CliCod[0] ;
         A22LegPaiCod = P00PK2_A22LegPaiCod[0] ;
         n22LegPaiCod = P00PK2_n22LegPaiCod[0] ;
         A235LegClase = P00PK2_A235LegClase[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, "2") ;
         if ( ! (GXutil.strcmp("", AV21LegCatCodigo)==0) && ! (GXutil.strcmp("", AV22LegConveCodigo)==0) )
         {
            GXv_int3[0] = AV18CliConveVer ;
            new web.getversiondelegajo(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, GXv_int3) ;
            obtbasicovalorhora.this.AV18CliConveVer = GXv_int3[0] ;
            GXv_int4[0] = AV24CliPaiConve ;
            new web.getpaisdeconvenio(remoteHandle, context).execute( AV22LegConveCodigo, A22LegPaiCod, GXv_int4) ;
            obtbasicovalorhora.this.AV24CliPaiConve = GXv_int4[0] ;
            GXv_boolean5[0] = false ;
            GXv_char2[0] = AV16error ;
            GXv_decimal6[0] = AV15CatValorHora ;
            new web.getescalasalarialvigente3(remoteHandle, context).execute( AV18CliConveVer, AV24CliPaiConve, AV22LegConveCodigo, AV21LegCatCodigo, AV14LiqPeriodo, A235LegClase, AV19que, GXv_boolean5, GXv_char2, GXv_decimal6) ;
            obtbasicovalorhora.this.AV16error = GXv_char2[0] ;
            obtbasicovalorhora.this.AV15CatValorHora = GXv_decimal6[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&CatValorHora ", "")+GXutil.trim( GXutil.str( AV15CatValorHora, 14, 2))) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15CatValorHora)==0) )
            {
               AV10valorHora = AV15CatValorHora ;
            }
         }
         else
         {
            GXv_decimal6[0] = AV10valorHora ;
            GXv_char2[0] = AV23LegSuelTipo ;
            GXv_int4[0] = (short)(0) ;
            GXv_boolean5[0] = false ;
            new web.getlegajosueldoultimo(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV20LiqNro, AV9LegNumero, AV14LiqPeriodo, GXv_decimal6, GXv_char2, GXv_int4, GXv_boolean5) ;
            obtbasicovalorhora.this.AV10valorHora = GXv_decimal6[0] ;
            obtbasicovalorhora.this.AV23LegSuelTipo = GXv_char2[0] ;
         }
         if ( A235LegClase == 1 )
         {
            /* Execute user subroutine: 'HORAS MES' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'HORAS MES' Routine */
      returnInSub = false ;
      GXv_decimal6[0] = DecimalUtil.doubleToDec(AV12horasmesCant) ;
      GXv_char2[0] = "" ;
      GXv_char1[0] = "" ;
      new web.horasmes(remoteHandle, context).execute( AV11CliCod, AV8EmpCod, AV9LegNumero, AV14LiqPeriodo, GXv_decimal6, GXv_char2, GXv_char1) ;
      obtbasicovalorhora.this.AV12horasmesCant = (short)(DecimalUtil.decToDouble(GXv_decimal6[0])) ;
      if ( ! (0==AV12horasmesCant) )
      {
         AV10valorHora = AV10valorHora.divide(DecimalUtil.doubleToDec(AV12horasmesCant), 18, java.math.RoundingMode.DOWN) ;
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = obtbasicovalorhora.this.AV16error;
      this.aP7[0] = obtbasicovalorhora.this.AV10valorHora;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16error = "" ;
      AV10valorHora = DecimalUtil.ZERO ;
      AV21LegCatCodigo = "" ;
      AV22LegConveCodigo = "" ;
      AV27Pgmname = "" ;
      scmdbuf = "" ;
      P00PK2_A6LegNumero = new int[1] ;
      P00PK2_A1EmpCod = new short[1] ;
      P00PK2_A3CliCod = new int[1] ;
      P00PK2_A22LegPaiCod = new short[1] ;
      P00PK2_n22LegPaiCod = new boolean[] {false} ;
      P00PK2_A235LegClase = new byte[1] ;
      GXv_int3 = new int[1] ;
      AV15CatValorHora = DecimalUtil.ZERO ;
      AV23LegSuelTipo = "" ;
      GXv_int4 = new short[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtbasicovalorhora__default(),
         new Object[] {
             new Object[] {
            P00PK2_A6LegNumero, P00PK2_A1EmpCod, P00PK2_A3CliCod, P00PK2_A22LegPaiCod, P00PK2_n22LegPaiCod, P00PK2_A235LegClase
            }
         }
      );
      AV27Pgmname = "ObtBasicoValorHora" ;
      /* GeneXus formulas. */
      AV27Pgmname = "ObtBasicoValorHora" ;
      Gx_err = (short)(0) ;
   }

   private byte A235LegClase ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A22LegPaiCod ;
   private short AV24CliPaiConve ;
   private short GXv_int4[] ;
   private short AV12horasmesCant ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV20LiqNro ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV18CliConveVer ;
   private int GXv_int3[] ;
   private java.math.BigDecimal AV10valorHora ;
   private java.math.BigDecimal AV15CatValorHora ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private String AV19que ;
   private String AV21LegCatCodigo ;
   private String AV22LegConveCodigo ;
   private String AV27Pgmname ;
   private String scmdbuf ;
   private String AV23LegSuelTipo ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean n22LegPaiCod ;
   private boolean GXv_boolean5[] ;
   private boolean returnInSub ;
   private String AV16error ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P00PK2_A6LegNumero ;
   private short[] P00PK2_A1EmpCod ;
   private int[] P00PK2_A3CliCod ;
   private short[] P00PK2_A22LegPaiCod ;
   private boolean[] P00PK2_n22LegPaiCod ;
   private byte[] P00PK2_A235LegClase ;
}

final  class obtbasicovalorhora__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00PK2", "SELECT LegNumero, EmpCod, CliCod, LegPaiCod, LegClase FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
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
               return;
      }
   }

}

