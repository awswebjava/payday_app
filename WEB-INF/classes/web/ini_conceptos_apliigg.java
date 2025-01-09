package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_conceptos_apliigg extends GXProcedure
{
   public ini_conceptos_apliigg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_conceptos_apliigg.class ), "" );
   }

   public ini_conceptos_apliigg( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      ini_conceptos_apliigg.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV10totalmenteExentoAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg_totalmenteexenta(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
      AV10totalmenteExentoAplIIGG = GXt_int1 ;
      GXt_int1 = AV19totalmenteGravadoAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg_totalmentegravado(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
      AV19totalmenteGravadoAplIIGG = GXt_int1 ;
      AV14mniPalabra = "[mni]" ;
      GXt_int1 = AV12mni40GralAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, (byte)(1), DecimalUtil.stringToDec("0.4"), AV14mniPalabra, "", "", GXv_int2) ;
      ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
      AV12mni40GralAplIIGG = GXt_int1 ;
      GXt_int1 = AV29pozoAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg2(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, AV30TipoTope, DecimalUtil.doubleToDec(1), "", "", "", httpContext.getMessage( "PERSONALPOZO", ""), GXv_int2) ;
      ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
      AV29pozoAplIIGG = GXt_int1 ;
      GXt_int1 = AV17horasExtrasAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg_horasextras(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
      AV17horasExtrasAplIIGG = GXt_int1 ;
      GXt_int1 = AV18sacAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg_sac(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
      AV18sacAplIIGG = GXt_int1 ;
      GXv_char3[0] = AV26sobreGiroConCodigo ;
      GXv_char4[0] = "" ;
      new web.conceptosobregiro(remoteHandle, context).execute( AV8CliCod, GXv_char3, GXv_char4) ;
      ini_conceptos_apliigg.this.AV26sobreGiroConCodigo = GXv_char3[0] ;
      GXv_char4[0] = AV27redondeoConCodigo ;
      GXv_char3[0] = "" ;
      new web.conceptoredondeo(remoteHandle, context).execute( AV8CliCod, GXv_char4, GXv_char3) ;
      ini_conceptos_apliigg.this.AV27redondeoConCodigo = GXv_char4[0] ;
      GXv_int2[0] = AV13bonoProdAplIIGG ;
      new web.getapliigg_bonos(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      ini_conceptos_apliigg.this.AV13bonoProdAplIIGG = GXv_int2[0] ;
      GXv_int2[0] = AV23fallosAplIIGG ;
      new web.getapliigg_fallos(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      ini_conceptos_apliigg.this.AV23fallosAplIIGG = GXv_int2[0] ;
      GXv_int2[0] = AV24simNatAplIIGG ;
      new web.getapliigg_simnat(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      ini_conceptos_apliigg.this.AV24simNatAplIIGG = GXv_int2[0] ;
      GXv_int2[0] = AV28pagos_A_Cuenta_AplIIGG ;
      new web.getapliigg_pagosacuenta(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      ini_conceptos_apliigg.this.AV28pagos_A_Cuenta_AplIIGG = GXv_int2[0] ;
      new web.msgdebug(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "&&mni40GralAplIIGG ", "")+GXutil.trim( GXutil.str( AV12mni40GralAplIIGG, 4, 0))+httpContext.getMessage( " &clicod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      /* Using cursor P017A2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P017A2_A3CliCod[0] ;
         A41ConDescrip = P017A2_A41ConDescrip[0] ;
         A1112AplIIGG = P017A2_A1112AplIIGG[0] ;
         n1112AplIIGG = P017A2_n1112AplIIGG[0] ;
         A37TipoConCod = P017A2_A37TipoConCod[0] ;
         A26ConCodigo = P017A2_A26ConCodigo[0] ;
         new web.msgdebug(remoteHandle, context).execute( AV33Pgmname, httpContext.getMessage( "Concodigo ", "")+GXutil.trim( A26ConCodigo)) ;
         if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "SOBREGIRO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "REDONDEO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "COMPENSACION GASTOS TELETRABAJO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "INDEMNIZACION ANTIGUEDAD", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "INDEMNIZACION SUSTITUTIVA DEL PREAVISO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "INCAPACIDAD LABORAL TEMPORARIA (PRIMEROS 10 DIAS)", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "INCAPACIDAD LABORAL TEMPORARIA (POR ART)", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "FONDO DE CESE LABORAL", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "GRATIFICACION POR CESE LABORAL", "")) == 0 ) )
         {
            A1112AplIIGG = AV10totalmenteExentoAplIIGG ;
            n1112AplIIGG = false ;
         }
         else
         {
            if ( GXutil.strSearch( A26ConCodigo, httpContext.getMessage( "DED0", ""), 1) != 0 )
            {
               if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED000", "")) == 0 )
               {
                  A1112AplIIGG = AV28pagos_A_Cuenta_AplIIGG ;
                  n1112AplIIGG = false ;
               }
               else if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED001", "")) == 0 )
               {
                  GXt_char5 = AV21ConCodigo ;
                  GXt_char6 = AV21ConCodigo ;
                  GXv_char4[0] = GXt_char6 ;
                  new web.concepto_topeprepaga_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  ini_conceptos_apliigg.this.GXt_char6 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char5 ;
                  new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char6, GXv_char3) ;
                  ini_conceptos_apliigg.this.GXt_char5 = GXv_char3[0] ;
                  AV21ConCodigo = GXt_char5 ;
                  GXt_int1 = A1112AplIIGG ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, (byte)(2), DecimalUtil.doubleToDec(1), "", AV21ConCodigo, "", GXv_int2) ;
                  ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
                  A1112AplIIGG = GXt_int1 ;
                  n1112AplIIGG = false ;
               }
               else if ( ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED002", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED023", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED024", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED025", "")) == 0 ) )
               {
                  AV22palabra = "[tope_seguros]" ;
                  GXt_int1 = A1112AplIIGG ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, (byte)(1), DecimalUtil.doubleToDec(1), AV22palabra, "", "", GXv_int2) ;
                  ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
                  A1112AplIIGG = GXt_int1 ;
                  n1112AplIIGG = false ;
               }
               else if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED003", "")) == 0 )
               {
                  GXt_char6 = AV21ConCodigo ;
                  GXt_char5 = AV21ConCodigo ;
                  GXv_char4[0] = GXt_char5 ;
                  new web.concepto_topedonaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  ini_conceptos_apliigg.this.GXt_char5 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char6 ;
                  new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char5, GXv_char3) ;
                  ini_conceptos_apliigg.this.GXt_char6 = GXv_char3[0] ;
                  AV21ConCodigo = GXt_char6 ;
                  GXt_int1 = A1112AplIIGG ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, (byte)(2), DecimalUtil.doubleToDec(1), "", AV21ConCodigo, "", GXv_int2) ;
                  ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
                  A1112AplIIGG = GXt_int1 ;
                  n1112AplIIGG = false ;
               }
               else if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED004", "")) == 0 )
               {
                  AV22palabra = "[tope_hipoteca]" ;
                  GXt_int1 = A1112AplIIGG ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, (byte)(1), DecimalUtil.doubleToDec(1), AV22palabra, "", "", GXv_int2) ;
                  ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
                  A1112AplIIGG = GXt_int1 ;
                  n1112AplIIGG = false ;
               }
               else if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED005", "")) == 0 )
               {
                  AV22palabra = "[tope_sepelio]" ;
                  GXt_int1 = A1112AplIIGG ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, (byte)(1), DecimalUtil.doubleToDec(1), AV22palabra, "", "", GXv_int2) ;
                  ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
                  A1112AplIIGG = GXt_int1 ;
                  n1112AplIIGG = false ;
               }
               else if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED007", "")) == 0 )
               {
                  GXt_char6 = AV21ConCodigo ;
                  GXt_char5 = AV21ConCodigo ;
                  GXv_char4[0] = GXt_char5 ;
                  new web.concepto_topemedicos_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  ini_conceptos_apliigg.this.GXt_char5 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char6 ;
                  new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char5, GXv_char3) ;
                  ini_conceptos_apliigg.this.GXt_char6 = GXv_char3[0] ;
                  AV21ConCodigo = GXt_char6 ;
                  GXt_int1 = A1112AplIIGG ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, (byte)(2), DecimalUtil.doubleToDec(1), "", AV21ConCodigo, "", GXv_int2) ;
                  ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
                  A1112AplIIGG = GXt_int1 ;
                  n1112AplIIGG = false ;
               }
               else if ( ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED008", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED022", "")) == 0 ) )
               {
                  AV22palabra = "[mni]" ;
                  GXt_int1 = A1112AplIIGG ;
                  GXv_int2[0] = GXt_int1 ;
                  new web.getapliigg(remoteHandle, context).execute( AV8CliCod, AV16AplIIGGTrat, (byte)(1), DecimalUtil.doubleToDec(1), AV22palabra, "", "", GXv_int2) ;
                  ini_conceptos_apliigg.this.GXt_int1 = GXv_int2[0] ;
                  A1112AplIIGG = GXt_int1 ;
                  n1112AplIIGG = false ;
               }
               else if ( ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED009", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED010", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED011", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED021", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED099", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED033", "")) == 0 ) || ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED034", "")) == 0 ) )
               {
                  A1112AplIIGG = AV10totalmenteExentoAplIIGG ;
                  n1112AplIIGG = false ;
               }
               else if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "DED032", "")) == 0 )
               {
                  A1112AplIIGG = AV12mni40GralAplIIGG ;
                  n1112AplIIGG = false ;
               }
            }
            else
            {
               if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "HORAS DE VIAJE", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A41ConDescrip)), httpContext.getMessage( "VIANDA", "")) == 0 ) )
               {
                  A1112AplIIGG = AV29pozoAplIIGG ;
                  n1112AplIIGG = false ;
               }
               else
               {
                  if ( ( ( GXutil.strcmp(A37TipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A37TipoConCod, "NRE_ARG") == 0 ) ) && ( GXutil.strcmp(A26ConCodigo, new web.conceptodevolucionganancias(remoteHandle, context).executeUdp( AV8CliCod)) != 0 ) && ( GXutil.strcmp(A26ConCodigo, new web.conceptodevoluciongananciasanioanterior(remoteHandle, context).executeUdp( AV8CliCod)) != 0 ) && ( GXutil.strcmp(A26ConCodigo, AV26sobreGiroConCodigo) != 0 ) && ( GXutil.strcmp(A26ConCodigo, AV27redondeoConCodigo) != 0 ) )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     A1112AplIIGG = AV19totalmenteGravadoAplIIGG ;
                     n1112AplIIGG = false ;
                  }
                  else
                  {
                     A1112AplIIGG = (short)(0) ;
                     n1112AplIIGG = false ;
                     n1112AplIIGG = true ;
                  }
               }
            }
         }
         /* Using cursor P017A3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_conceptos_apliigg");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14mniPalabra = "" ;
      AV26sobreGiroConCodigo = "" ;
      AV27redondeoConCodigo = "" ;
      AV33Pgmname = "" ;
      scmdbuf = "" ;
      P017A2_A3CliCod = new int[1] ;
      P017A2_A41ConDescrip = new String[] {""} ;
      P017A2_A1112AplIIGG = new short[1] ;
      P017A2_n1112AplIIGG = new boolean[] {false} ;
      P017A2_A37TipoConCod = new String[] {""} ;
      P017A2_A26ConCodigo = new String[] {""} ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      AV21ConCodigo = "" ;
      AV22palabra = "" ;
      GXt_char6 = "" ;
      GXt_char5 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_int2 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_conceptos_apliigg__default(),
         new Object[] {
             new Object[] {
            P017A2_A3CliCod, P017A2_A41ConDescrip, P017A2_A1112AplIIGG, P017A2_n1112AplIIGG, P017A2_A37TipoConCod, P017A2_A26ConCodigo
            }
            , new Object[] {
            }
         }
      );
      AV33Pgmname = "ini_conceptos_AplIIGG" ;
      /* GeneXus formulas. */
      AV33Pgmname = "ini_conceptos_AplIIGG" ;
      Gx_err = (short)(0) ;
   }

   private byte AV16AplIIGGTrat ;
   private byte AV30TipoTope ;
   private short AV10totalmenteExentoAplIIGG ;
   private short AV19totalmenteGravadoAplIIGG ;
   private short AV12mni40GralAplIIGG ;
   private short AV29pozoAplIIGG ;
   private short AV17horasExtrasAplIIGG ;
   private short AV18sacAplIIGG ;
   private short AV13bonoProdAplIIGG ;
   private short AV23fallosAplIIGG ;
   private short AV24simNatAplIIGG ;
   private short AV28pagos_A_Cuenta_AplIIGG ;
   private short A1112AplIIGG ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV14mniPalabra ;
   private String AV26sobreGiroConCodigo ;
   private String AV27redondeoConCodigo ;
   private String AV33Pgmname ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String AV21ConCodigo ;
   private String AV22palabra ;
   private String GXt_char6 ;
   private String GXt_char5 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private boolean n1112AplIIGG ;
   private boolean Cond_result ;
   private String A41ConDescrip ;
   private IDataStoreProvider pr_default ;
   private int[] P017A2_A3CliCod ;
   private String[] P017A2_A41ConDescrip ;
   private short[] P017A2_A1112AplIIGG ;
   private boolean[] P017A2_n1112AplIIGG ;
   private String[] P017A2_A37TipoConCod ;
   private String[] P017A2_A26ConCodigo ;
}

final  class ini_conceptos_apliigg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017A2", "SELECT CliCod, ConDescrip, AplIIGG, TipoConCod, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod, ConCodigo  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P017A3", "SAVEPOINT gxupdate;UPDATE Concepto SET AplIIGG=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
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
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setString(3, (String)parms[3], 10);
               return;
      }
   }

}

