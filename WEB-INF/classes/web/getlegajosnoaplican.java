package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajosnoaplican extends GXProcedure
{
   public getlegajosnoaplican( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajosnoaplican.class ), "" );
   }

   public getlegajosnoaplican( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Integer> executeUdp( int aP0 ,
                                                  short aP1 ,
                                                  String aP2 ,
                                                  java.util.Date aP3 ,
                                                  GXSimpleCollection<Integer> aP4 ,
                                                  GXSimpleCollection<Integer>[] aP5 )
   {
      getlegajosnoaplican.this.aP6 = new GXSimpleCollection[] {new GXSimpleCollection<Integer>(Integer.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        GXSimpleCollection<Integer> aP4 ,
                        GXSimpleCollection<Integer>[] aP5 ,
                        GXSimpleCollection<Integer>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             GXSimpleCollection<Integer> aP4 ,
                             GXSimpleCollection<Integer>[] aP5 ,
                             GXSimpleCollection<Integer>[] aP6 )
   {
      getlegajosnoaplican.this.AV13CliCod = aP0;
      getlegajosnoaplican.this.AV10EmpCod = aP1;
      getlegajosnoaplican.this.AV17TLiqCod = aP2;
      getlegajosnoaplican.this.AV15LiqPeriodo = aP3;
      getlegajosnoaplican.this.AV8LegNumero = aP4;
      getlegajosnoaplican.this.aP5 = aP5;
      getlegajosnoaplican.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV21quincenaTLiqCod ;
      GXt_char2 = AV21quincenaTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getlegajosnoaplican.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char2, GXv_char4) ;
      getlegajosnoaplican.this.GXt_char1 = GXv_char4[0] ;
      AV21quincenaTLiqCod = GXt_char1 ;
      GXt_char2 = AV18mensualTLiqCod ;
      GXt_char1 = AV18mensualTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      getlegajosnoaplican.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
      getlegajosnoaplican.this.GXt_char2 = GXv_char3[0] ;
      AV18mensualTLiqCod = GXt_char2 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "&TLiqCod \"", "")+AV17TLiqCod+httpContext.getMessage( "\" &mensualTLiqCod \"", "")+AV18mensualTLiqCod+httpContext.getMessage( "\" &quincenaTLiqCod ", "")+AV21quincenaTLiqCod) ;
      if ( ( GXutil.strcmp(AV17TLiqCod, AV18mensualTLiqCod) == 0 ) || ( GXutil.strcmp(AV17TLiqCod, AV21quincenaTLiqCod) == 0 ) )
      {
         AV9i = (short)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( " &LegNumero.Count ", "")+GXutil.trim( GXutil.str( AV8LegNumero.size(), 9, 0))) ;
         AV16finDeMesFecha = GXutil.eomdate( AV15LiqPeriodo) ;
         while ( AV9i <= AV8LegNumero.size() )
         {
            AV25aplicaClase = true ;
            /* Using cursor P00AN2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV10EmpCod)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A6LegNumero = P00AN2_A6LegNumero[0] ;
               A1EmpCod = P00AN2_A1EmpCod[0] ;
               A3CliCod = P00AN2_A3CliCod[0] ;
               A235LegClase = P00AN2_A235LegClase[0] ;
               A2404LegModTra = P00AN2_A2404LegModTra[0] ;
               if ( A6LegNumero == ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue() )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( " LegClase ", "")+GXutil.trim( GXutil.str( A235LegClase, 1, 0))) ;
                  AV26LegClase = A235LegClase ;
                  AV38LegModTra = A2404LegModTra ;
                  if ( GXutil.strcmp(AV17TLiqCod, AV18mensualTLiqCod) != 0 )
                  {
                     if ( A235LegClase == 1 )
                     {
                        AV12LegNoAplicanPorClase.add((int)(A6LegNumero), 0);
                        AV25aplicaClase = false ;
                     }
                  }
                  if ( ( AV26LegClase == 1 ) && ( GXutil.strcmp(AV38LegModTra, "E") == 0 ) )
                  {
                     GXv_boolean5[0] = AV32tieneAlMenos1Liquidacion ;
                     new web.legajotieneliquidacion(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV24date, "", GXv_boolean5) ;
                     getlegajosnoaplican.this.AV32tieneAlMenos1Liquidacion = GXv_boolean5[0] ;
                     if ( ( AV25aplicaClase ) && ( AV32tieneAlMenos1Liquidacion ) )
                     {
                        if ( ( AV26LegClase == 1 ) || ( GXutil.strcmp(AV17TLiqCod, AV21quincenaTLiqCod) == 0 ) )
                        {
                           AV27buscaLiqPeriodo = GXutil.addmth( AV15LiqPeriodo, (short)(-1)) ;
                           AV29buscaTliqCod = AV18mensualTLiqCod ;
                        }
                        else
                        {
                           AV27buscaLiqPeriodo = AV15LiqPeriodo ;
                           AV29buscaTliqCod = AV21quincenaTLiqCod ;
                        }
                        GXv_boolean5[0] = AV30existe ;
                        new web.legajotieneliquidacion(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV27buscaLiqPeriodo, AV29buscaTliqCod, GXv_boolean5) ;
                        getlegajosnoaplican.this.AV30existe = GXv_boolean5[0] ;
                        if ( ! AV30existe )
                        {
                           GXt_char2 = AV35ParmValue ;
                           GXt_char1 = AV35ParmValue ;
                           GXv_char4[0] = GXt_char1 ;
                           new web.meses_liquidar_sac_param(remoteHandle, context).execute( GXv_char4) ;
                           getlegajosnoaplican.this.GXt_char1 = GXv_char4[0] ;
                           GXv_char3[0] = GXt_char2 ;
                           new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
                           getlegajosnoaplican.this.GXt_char2 = GXv_char3[0] ;
                           AV35ParmValue = GXt_char2 ;
                           AV34mesesSAC.fromJSonString(AV35ParmValue, null);
                           AV36m = (short)(1) ;
                           AV37mesSAC_ES = false ;
                           while ( AV36m <= AV34mesesSAC.size() )
                           {
                              if ( ((Number) AV34mesesSAC.elementAt(-1+AV36m)).byteValue() == GXutil.month( AV15LiqPeriodo) )
                              {
                                 AV37mesSAC_ES = true ;
                                 if (true) break;
                              }
                              AV36m = (short)(AV36m+1) ;
                           }
                           if ( AV37mesSAC_ES )
                           {
                              GXt_char2 = AV29buscaTliqCod ;
                              GXt_char1 = AV29buscaTliqCod ;
                              GXv_char4[0] = GXt_char1 ;
                              new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                              getlegajosnoaplican.this.GXt_char1 = GXv_char4[0] ;
                              GXv_char3[0] = GXt_char2 ;
                              new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
                              getlegajosnoaplican.this.GXt_char2 = GXv_char3[0] ;
                              AV29buscaTliqCod = GXt_char2 ;
                              GXv_boolean5[0] = AV30existe ;
                              new web.legajotieneliquidacion(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV27buscaLiqPeriodo, AV29buscaTliqCod, GXv_boolean5) ;
                              getlegajosnoaplican.this.AV30existe = GXv_boolean5[0] ;
                           }
                        }
                        if ( ! AV30existe )
                        {
                           AV31LegNoAplicanPorHueco.add((int)(A6LegNumero), 0);
                        }
                     }
                  }
               }
               pr_default.readNext(0);
            }
            pr_default.close(0);
            AV9i = (short)(AV9i+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getlegajosnoaplican.this.AV12LegNoAplicanPorClase;
      this.aP6[0] = getlegajosnoaplican.this.AV31LegNoAplicanPorHueco;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegNoAplicanPorClase = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV31LegNoAplicanPorHueco = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV21quincenaTLiqCod = "" ;
      AV18mensualTLiqCod = "" ;
      AV41Pgmname = "" ;
      AV16finDeMesFecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00AN2_A6LegNumero = new int[1] ;
      P00AN2_A1EmpCod = new short[1] ;
      P00AN2_A3CliCod = new int[1] ;
      P00AN2_A235LegClase = new byte[1] ;
      P00AN2_A2404LegModTra = new String[] {""} ;
      A2404LegModTra = "" ;
      AV38LegModTra = "" ;
      AV24date = GXutil.nullDate() ;
      AV27buscaLiqPeriodo = GXutil.nullDate() ;
      AV29buscaTliqCod = "" ;
      AV35ParmValue = "" ;
      AV34mesesSAC = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajosnoaplican__default(),
         new Object[] {
             new Object[] {
            P00AN2_A6LegNumero, P00AN2_A1EmpCod, P00AN2_A3CliCod, P00AN2_A235LegClase, P00AN2_A2404LegModTra
            }
         }
      );
      AV41Pgmname = "GetLegajosNoAplican" ;
      /* GeneXus formulas. */
      AV41Pgmname = "GetLegajosNoAplican" ;
      Gx_err = (short)(0) ;
   }

   private byte A235LegClase ;
   private byte AV26LegClase ;
   private short AV10EmpCod ;
   private short AV9i ;
   private short A1EmpCod ;
   private short AV36m ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV17TLiqCod ;
   private String AV21quincenaTLiqCod ;
   private String AV18mensualTLiqCod ;
   private String AV41Pgmname ;
   private String scmdbuf ;
   private String A2404LegModTra ;
   private String AV38LegModTra ;
   private String AV29buscaTliqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV15LiqPeriodo ;
   private java.util.Date AV16finDeMesFecha ;
   private java.util.Date AV24date ;
   private java.util.Date AV27buscaLiqPeriodo ;
   private boolean AV25aplicaClase ;
   private boolean AV32tieneAlMenos1Liquidacion ;
   private boolean AV30existe ;
   private boolean AV37mesSAC_ES ;
   private boolean GXv_boolean5[] ;
   private String AV35ParmValue ;
   private GXSimpleCollection<Byte> AV34mesesSAC ;
   private GXSimpleCollection<Integer> AV8LegNumero ;
   private GXSimpleCollection<Integer> AV12LegNoAplicanPorClase ;
   private GXSimpleCollection<Integer> AV31LegNoAplicanPorHueco ;
   private GXSimpleCollection<Integer>[] aP6 ;
   private GXSimpleCollection<Integer>[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P00AN2_A6LegNumero ;
   private short[] P00AN2_A1EmpCod ;
   private int[] P00AN2_A3CliCod ;
   private byte[] P00AN2_A235LegClase ;
   private String[] P00AN2_A2404LegModTra ;
}

final  class getlegajosnoaplican__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AN2", "SELECT LegNumero, EmpCod, CliCod, LegClase, LegModTra FROM Legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
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
               return;
      }
   }

}

