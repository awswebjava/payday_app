package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dvcombodefaults extends GXProcedure
{
   public dvcombodefaults( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dvcombodefaults.class ), "" );
   }

   public dvcombodefaults( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String[] aP1 )
   {
      dvcombodefaults.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      dvcombodefaults.this.AV8ComboName = aP0;
      dvcombodefaults.this.aP1 = aP1;
      dvcombodefaults.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      dvcombodefaults.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&ComboName \"", "")+AV8ComboName+"\"") ;
      if ( GXutil.strcmp(GXutil.trim( AV8ComboName), "ConCodigo") == 0 )
      {
         GXt_char3 = AV11SelectedValue ;
         GXt_char4 = AV11SelectedValue ;
         GXv_char5[0] = GXt_char4 ;
         new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char5) ;
         dvcombodefaults.this.GXt_char4 = GXv_char5[0] ;
         GXv_char6[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char4, GXv_char6) ;
         dvcombodefaults.this.GXt_char3 = GXv_char6[0] ;
         AV11SelectedValue = GXt_char3 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "concepto parametro &SelectedValue ", "")+GXutil.trim( AV11SelectedValue)) ;
         GXv_char6[0] = AV10SelectedText ;
         new web.conceptogetdescri(remoteHandle, context).execute( AV14CliCod, AV11SelectedValue, GXv_char6) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "LegLicSitCodigo") == 0 )
      {
         GXv_char6[0] = AV11SelectedValue ;
         new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV14CliCod, GXv_char6) ;
         dvcombodefaults.this.AV11SelectedValue = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "ActCodigo") == 0 )
      {
         GXv_char6[0] = AV11SelectedValue ;
         GXv_char5[0] = AV10SelectedText ;
         new web.getultempresaactcodigo(remoteHandle, context).execute( AV14CliCod, GXv_char6, GXv_char5) ;
         dvcombodefaults.this.AV11SelectedValue = GXv_char6[0] ;
         dvcombodefaults.this.AV10SelectedText = GXv_char5[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "ZonCod") == 0 )
      {
         GXt_char4 = AV11SelectedValue ;
         GXt_char3 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char3 ;
         new web.zona_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         dvcombodefaults.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char5) ;
         dvcombodefaults.this.GXt_char4 = GXv_char5[0] ;
         AV11SelectedValue = GXt_char4 ;
         AV11SelectedValue = GXutil.trim( AV11SelectedValue) ;
         GXv_char6[0] = AV10SelectedText ;
         GXv_boolean7[0] = true ;
         new web.getzona(remoteHandle, context).execute( GXutil.trim( AV11SelectedValue), GXv_char6, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "zona ", "")+GXutil.trim( AV11SelectedValue)+httpContext.getMessage( " text ", "")+AV10SelectedText) ;
         GXv_char6[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getlugpag(remoteHandle, context).execute( AV14CliCod, GXutil.trim( AV11SelectedValue), GXv_char6, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "CarCodigo") == 0 )
      {
         GXt_char4 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "CARG_DEF", ""), GXv_char6) ;
         dvcombodefaults.this.GXt_char4 = GXv_char6[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char6[0] = AV10SelectedText ;
         new web.getcargo(remoteHandle, context).execute( AV11SelectedValue, GXv_char6) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "SecCodigo") == 0 )
      {
         GXt_char4 = AV11SelectedValue ;
         GXt_char3 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char3 ;
         new web.seccion_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         dvcombodefaults.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char5) ;
         dvcombodefaults.this.GXt_char4 = GXv_char5[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char6[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getseccion(remoteHandle, context).execute( AV14CliCod, GXutil.trim( AV11SelectedValue), GXv_char6, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( ( GXutil.strcmp(AV8ComboName, "LegNacionCod") == 0 ) || ( GXutil.strcmp(AV8ComboName, httpContext.getMessage( "FamNacionCod", "")) == 0 ) )
      {
         GXt_char4 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "PAI_DEF", ""), GXv_char6) ;
         dvcombodefaults.this.GXt_char4 = GXv_char6[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char6[0] = AV10SelectedText ;
         new web.getpais(remoteHandle, context).execute( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV11SelectedValue, "."))), GXv_char6) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "SitCodigo") == 0 )
      {
         GXt_char4 = AV11SelectedValue ;
         GXt_char3 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char3 ;
         new web.situacion_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         dvcombodefaults.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char5) ;
         dvcombodefaults.this.GXt_char4 = GXv_char5[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char6[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getsituacion(remoteHandle, context).execute( AV11SelectedValue, GXv_char6, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "CondiCodigo") == 0 )
      {
         GXt_char4 = AV11SelectedValue ;
         GXt_char3 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char3 ;
         new web.condicion_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         dvcombodefaults.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char5) ;
         dvcombodefaults.this.GXt_char4 = GXv_char5[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char6[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getcondicion(remoteHandle, context).execute( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV11SelectedValue, "."))), GXv_char6, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "SinieCodigo") == 0 )
      {
         GXt_char4 = AV11SelectedValue ;
         GXt_char3 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char3 ;
         new web.siniestrado_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         dvcombodefaults.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char5) ;
         dvcombodefaults.this.GXt_char4 = GXv_char5[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char6[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getsiniestrado(remoteHandle, context).execute( AV11SelectedValue, GXv_char6, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "ConveCodigo") == 0 )
      {
      }
      else if ( GXutil.strcmp(AV8ComboName, "SinCod") == 0 )
      {
         GXt_char4 = AV11SelectedValue ;
         GXt_char3 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char3 ;
         new web.sindicato_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         dvcombodefaults.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char5) ;
         dvcombodefaults.this.GXt_char4 = GXv_char5[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char6[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getsindicato(remoteHandle, context).execute( AV14CliCod, GXutil.trim( AV11SelectedValue), GXv_char6, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "OsoCod") == 0 )
      {
         GXt_char4 = AV11SelectedValue ;
         GXt_char3 = AV11SelectedValue ;
         GXv_char6[0] = GXt_char3 ;
         new web.obrasocial_codigoparam(remoteHandle, context).execute( GXv_char6) ;
         dvcombodefaults.this.GXt_char3 = GXv_char6[0] ;
         GXv_char5[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char5) ;
         dvcombodefaults.this.GXt_char4 = GXv_char5[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char6[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getobrasocial(remoteHandle, context).execute( AV14CliCod, GXutil.trim( AV11SelectedValue), GXv_char6, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char6[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "LegActCodigo") == 0 )
      {
         GXt_int8 = AV15EmpCod ;
         GXv_int9[0] = GXt_int8 ;
         new web.getempcod(remoteHandle, context).execute( GXv_int9) ;
         dvcombodefaults.this.GXt_int8 = GXv_int9[0] ;
         AV15EmpCod = GXt_int8 ;
         GXv_char6[0] = "" ;
         GXv_int10[0] = 0 ;
         GXv_char5[0] = "" ;
         GXv_char11[0] = "" ;
         GXv_char12[0] = "" ;
         GXv_char13[0] = AV16ActCodigo ;
         GXv_char14[0] = "" ;
         GXv_char15[0] = "" ;
         new web.getdatosempresa(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, GXv_char6, GXv_int10, GXv_char5, GXv_char11, GXv_char12, GXv_char13, GXv_char14, GXv_char15) ;
         dvcombodefaults.this.AV16ActCodigo = GXv_char13[0] ;
         AV11SelectedValue = GXutil.trim( AV16ActCodigo) ;
         if ( (GXutil.strcmp("", AV11SelectedValue)==0) )
         {
            GXt_char4 = AV11SelectedValue ;
            GXt_char3 = AV11SelectedValue ;
            GXv_char15[0] = GXt_char3 ;
            new web.actividad_codigoparam(remoteHandle, context).execute( GXv_char15) ;
            dvcombodefaults.this.GXt_char3 = GXv_char15[0] ;
            GXv_char14[0] = GXt_char4 ;
            new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char14) ;
            dvcombodefaults.this.GXt_char4 = GXv_char14[0] ;
            AV11SelectedValue = GXt_char4 ;
            AV16ActCodigo = GXutil.trim( AV11SelectedValue) ;
         }
         GXv_char15[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getactividad(remoteHandle, context).execute( AV16ActCodigo, GXv_char15, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char15[0] ;
      }
      else if ( GXutil.strcmp(AV8ComboName, "MprCod") == 0 )
      {
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "modalidad &CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
         GXt_char4 = AV11SelectedValue ;
         GXt_char3 = AV11SelectedValue ;
         GXv_char15[0] = GXt_char3 ;
         new web.modalidad_codigoparam(remoteHandle, context).execute( GXv_char15) ;
         dvcombodefaults.this.GXt_char3 = GXv_char15[0] ;
         GXv_char14[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char3, GXv_char14) ;
         dvcombodefaults.this.GXt_char4 = GXv_char14[0] ;
         AV11SelectedValue = GXt_char4 ;
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "modalidad &SelectedValue ", "")+AV11SelectedValue) ;
         GXv_char15[0] = AV10SelectedText ;
         GXv_boolean7[0] = false ;
         new web.getmodalidad(remoteHandle, context).execute( GXutil.trim( AV11SelectedValue), GXv_char15, GXv_boolean7) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char15[0] ;
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "modalidad &&SelectedText ", "")+AV10SelectedText) ;
      }
      else if ( ( GXutil.strcmp(AV8ComboName, "LegPaiCod") == 0 ) || ( GXutil.strcmp(AV8ComboName, "FamPaiCod") == 0 ) )
      {
         GXt_char4 = AV11SelectedValue ;
         GXv_char15[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "PAI_DEF", ""), GXv_char15) ;
         dvcombodefaults.this.GXt_char4 = GXv_char15[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char15[0] = AV10SelectedText ;
         new web.getpais(remoteHandle, context).execute( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV11SelectedValue, "."))), GXv_char15) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char15[0] ;
      }
      else if ( ( GXutil.strcmp(AV8ComboName, "LegProvCod") == 0 ) || ( GXutil.strcmp(AV8ComboName, "FamProvCod") == 0 ) )
      {
         GXt_char4 = "" ;
         GXv_char15[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "PAI_DEF", ""), GXv_char15) ;
         dvcombodefaults.this.GXt_char4 = GXv_char15[0] ;
         AV12DefPaiCod = (short)(GXutil.lval( GXt_char4)) ;
         GXt_char4 = AV11SelectedValue ;
         GXv_char15[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "PRO_DEF", ""), GXv_char15) ;
         dvcombodefaults.this.GXt_char4 = GXv_char15[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char15[0] = AV10SelectedText ;
         new web.getprovincia(remoteHandle, context).execute( AV12DefPaiCod, (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV11SelectedValue, "."))), GXv_char15) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char15[0] ;
      }
      else if ( ( GXutil.strcmp(AV8ComboName, "LegLocCod") == 0 ) || ( GXutil.strcmp(AV8ComboName, "FamLocCod") == 0 ) )
      {
         GXt_char4 = "" ;
         GXv_char15[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "PAI_DEF", ""), GXv_char15) ;
         dvcombodefaults.this.GXt_char4 = GXv_char15[0] ;
         AV12DefPaiCod = (short)(GXutil.lval( GXt_char4)) ;
         GXt_char4 = "" ;
         GXv_char15[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "PRO_DEF", ""), GXv_char15) ;
         dvcombodefaults.this.GXt_char4 = GXv_char15[0] ;
         AV13DefProvCod = (short)(GXutil.lval( GXt_char4)) ;
         GXt_char4 = AV11SelectedValue ;
         GXv_char15[0] = GXt_char4 ;
         new web.getparametro(remoteHandle, context).execute( AV14CliCod, httpContext.getMessage( "LOC_DEF", ""), GXv_char15) ;
         dvcombodefaults.this.GXt_char4 = GXv_char15[0] ;
         AV11SelectedValue = GXt_char4 ;
         GXv_char15[0] = AV10SelectedText ;
         new web.getlocalidad(remoteHandle, context).execute( AV12DefPaiCod, AV13DefProvCod, (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV11SelectedValue, "."))), GXv_char15) ;
         dvcombodefaults.this.AV10SelectedText = GXv_char15[0] ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = dvcombodefaults.this.AV11SelectedValue;
      this.aP2[0] = dvcombodefaults.this.AV10SelectedText;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11SelectedValue = "" ;
      AV10SelectedText = "" ;
      GXv_int2 = new int[1] ;
      AV19Pgmname = "" ;
      GXv_int9 = new short[1] ;
      GXv_char6 = new String[1] ;
      GXv_int10 = new long[1] ;
      GXv_char5 = new String[1] ;
      GXv_char11 = new String[1] ;
      GXv_char12 = new String[1] ;
      AV16ActCodigo = "" ;
      GXv_char13 = new String[1] ;
      GXt_char3 = "" ;
      GXv_char14 = new String[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXt_char4 = "" ;
      GXv_char15 = new String[1] ;
      AV19Pgmname = "DVComboDefaults" ;
      /* GeneXus formulas. */
      AV19Pgmname = "DVComboDefaults" ;
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short GXt_int8 ;
   private short GXv_int9[] ;
   private short AV12DefPaiCod ;
   private short AV13DefProvCod ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private long GXv_int10[] ;
   private String AV19Pgmname ;
   private String GXv_char6[] ;
   private String GXv_char5[] ;
   private String GXv_char11[] ;
   private String GXv_char12[] ;
   private String AV16ActCodigo ;
   private String GXv_char13[] ;
   private String GXt_char3 ;
   private String GXv_char14[] ;
   private String GXt_char4 ;
   private String GXv_char15[] ;
   private boolean GXv_boolean7[] ;
   private String AV8ComboName ;
   private String AV11SelectedValue ;
   private String AV10SelectedText ;
   private String[] aP2 ;
   private String[] aP1 ;
}

