package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class novedades_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      gxfirstwebparm_bkp = gxfirstwebparm ;
      gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         dyncall( httpContext.GetNextPar( )) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action32") == 0 )
      {
         AV21CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21CliCod), "ZZZZZ9")));
         AV7EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A112AgeFecHas = localUtil.parseDateParm( httpContext.GetPar( "AgeFecHas")) ;
         n112AgeFecHas = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
         A111AgeFecDes = localUtil.parseDateParm( httpContext.GetPar( "AgeFecDes")) ;
         n111AgeFecDes = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
         A25AgeOrden = (short)(GXutil.lval( httpContext.GetPar( "AgeOrden"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_32_1U3( AV21CliCod, AV7EmpCod, A6LegNumero, A26ConCodigo, A112AgeFecHas, A111AgeFecDes, A25AgeOrden, Gx_mode) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"AGEPREVCALC") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A110AgeCanti = CommonUtil.decimalVal( httpContext.GetPar( "AgeCanti"), ".") ;
         n110AgeCanti = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
         A113AgeImporte = CommonUtil.decimalVal( httpContext.GetPar( "AgeImporte"), ".") ;
         n113AgeImporte = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
         A111AgeFecDes = localUtil.parseDateParm( httpContext.GetPar( "AgeFecDes")) ;
         n111AgeFecDes = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
         A112AgeFecHas = localUtil.parseDateParm( httpContext.GetPar( "AgeFecHas")) ;
         n112AgeFecHas = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asaageprevcalc1U3( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"AGEPREVIS") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         A110AgeCanti = CommonUtil.decimalVal( httpContext.GetPar( "AgeCanti"), ".") ;
         n110AgeCanti = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
         A113AgeImporte = CommonUtil.decimalVal( httpContext.GetPar( "AgeImporte"), ".") ;
         n113AgeImporte = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
         A111AgeFecDes = localUtil.parseDateParm( httpContext.GetPar( "AgeFecDes")) ;
         n111AgeFecDes = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
         A112AgeFecHas = localUtil.parseDateParm( httpContext.GetPar( "AgeFecHas")) ;
         n112AgeFecHas = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx4asaageprevis1U3( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"CLICOD") == 0 )
      {
         AV21CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx6asaclicod1U3( AV21CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"AGEORDEN") == 0 )
      {
         AV9AgeOrden = (short)(GXutil.lval( httpContext.GetPar( "AgeOrden"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9AgeOrden), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAGEORDEN", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9AgeOrden), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx12asaageorden1U3( AV9AgeOrden) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel13"+"_"+"AGEORDEN") == 0 )
      {
         AV7EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx13asaageorden1U3( AV7EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_37") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A26ConCodigo = httpContext.GetPar( "ConCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_37( A3CliCod, A26ConCodigo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_35") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_35( A3CliCod, A1EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_36") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_36( A3CliCod, A1EmpCod, A6LegNumero) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else
      {
         if ( ! httpContext.IsValidAjaxCall( false) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = gxfirstwebparm_bkp ;
      }
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV21CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21CliCod), "ZZZZZ9")));
            AV7EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
            AV8LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8LegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8LegNumero), "ZZZZZZZ9")));
            AV9AgeOrden = (short)(GXutil.lval( httpContext.GetPar( "AgeOrden"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9AgeOrden), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAGEORDEN", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9AgeOrden), "ZZZ9")));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Agenda de Novedades", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public novedades_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public novedades_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedades_impl.class ));
   }

   public novedades_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLegNumero_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLegNumero_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedconcodigo_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconcodigo_Internalname, httpContext.getMessage( "Código", ""), "", "", lblTextblockconcodigo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_concodigo.setProperty("Caption", Combo_concodigo_Caption);
      ucCombo_concodigo.setProperty("Cls", Combo_concodigo_Cls);
      ucCombo_concodigo.setProperty("EmptyItem", Combo_concodigo_Emptyitem);
      ucCombo_concodigo.setProperty("DropDownOptionsData", AV15ConCodigo_Data);
      ucCombo_concodigo.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_concodigo_Internalname, "COMBO_CONCODIGOContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConCodigo_Internalname, GXutil.rtrim( A26ConCodigo), GXutil.rtrim( localUtil.format( A26ConCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConCodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtConCodigo_Visible, edtConCodigo_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAgeCanti_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAgeCanti_Internalname, httpContext.getMessage( "Cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAgeCanti_Internalname, GXutil.ltrim( localUtil.ntoc( A110AgeCanti, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAgeCanti_Enabled!=0) ? localUtil.format( A110AgeCanti, "ZZZZZ9.99") : localUtil.format( A110AgeCanti, "ZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeCanti_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAgeCanti_Enabled, 0, "text", "", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedageimporte_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockageimporte_Internalname, httpContext.getMessage( "Importe", ""), "", "", lblTextblockageimporte_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedageimporte_Internalname, tblTablemergedageimporte_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAgeImporte_Internalname, httpContext.getMessage( "Importe", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAgeImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A113AgeImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAgeImporte_Enabled!=0) ? localUtil.format( A113AgeImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A113AgeImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeImporte_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAgeImporte_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblAgeimporte_righttext_Internalname, httpContext.getMessage( "Si ingresa valor en importe, se sobreescribirá la fórmula con este valor", ""), "", "", lblAgeimporte_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_Novedades.htm");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAgeFecDes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAgeFecDes_Internalname, httpContext.getMessage( "Desde", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtAgeFecDes_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAgeFecDes_Internalname, localUtil.format(A111AgeFecDes, "99/99/9999"), localUtil.format( A111AgeFecDes, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeFecDes_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtAgeFecDes_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Novedades.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtAgeFecDes_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtAgeFecDes_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Novedades.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAgeFecHas_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAgeFecHas_Internalname, httpContext.getMessage( "Hasta", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtAgeFecHas_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAgeFecHas_Internalname, localUtil.format(A112AgeFecHas, "99/99/9999"), localUtil.format( A112AgeFecHas, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeFecHas_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtAgeFecHas_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Novedades.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtAgeFecHas_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtAgeFecHas_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Novedades.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_concodigo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboconcodigo_Internalname, GXutil.rtrim( AV20ComboConCodigo), GXutil.rtrim( localUtil.format( AV20ComboConCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboconcodigo_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboconcodigo_Visible, edtavComboconcodigo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,80);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Novedades.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,81);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Novedades.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAgeVUnit_Internalname, GXutil.ltrim( localUtil.ntoc( A115AgeVUnit, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAgeVUnit_Enabled!=0) ? localUtil.format( A115AgeVUnit, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A115AgeVUnit, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAgeVUnit_Jsonclick, 0, "Attribute", "", "", "", "", edtAgeVUnit_Visible, edtAgeVUnit_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Novedades.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONCODIGO_DATA"), AV15ConCodigo_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z6LegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z25AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( "Z25AgeOrden"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1254AgeLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z1254AgeLiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1254AgeLiqNro = ((0==A1254AgeLiqNro) ? true : false) ;
            Z110AgeCanti = localUtil.ctond( httpContext.cgiGet( "Z110AgeCanti")) ;
            n110AgeCanti = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A110AgeCanti)==0) ? true : false) ;
            Z115AgeVUnit = localUtil.ctond( httpContext.cgiGet( "Z115AgeVUnit")) ;
            n115AgeVUnit = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A115AgeVUnit)==0) ? true : false) ;
            Z113AgeImporte = localUtil.ctond( httpContext.cgiGet( "Z113AgeImporte")) ;
            n113AgeImporte = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A113AgeImporte)==0) ? true : false) ;
            Z111AgeFecDes = localUtil.ctod( httpContext.cgiGet( "Z111AgeFecDes"), 0) ;
            n111AgeFecDes = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) ? true : false) ;
            Z112AgeFecHas = localUtil.ctod( httpContext.cgiGet( "Z112AgeFecHas"), 0) ;
            n112AgeFecHas = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A112AgeFecHas)) ? true : false) ;
            Z2159AgePerDescrip = httpContext.cgiGet( "Z2159AgePerDescrip") ;
            Z26ConCodigo = httpContext.cgiGet( "Z26ConCodigo") ;
            A1254AgeLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "Z1254AgeLiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1254AgeLiqNro = false ;
            n1254AgeLiqNro = ((0==A1254AgeLiqNro) ? true : false) ;
            A2159AgePerDescrip = httpContext.cgiGet( "Z2159AgePerDescrip") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N26ConCodigo = httpContext.cgiGet( "N26ConCodigo") ;
            N1254AgeLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "N1254AgeLiqNro"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1254AgeLiqNro = ((0==A1254AgeLiqNro) ? true : false) ;
            A1133AgePrevCalc = httpContext.cgiGet( "AGEPREVCALC") ;
            A1132AgePrevis = httpContext.cgiGet( "AGEPREVIS") ;
            A114AgeLegActivo = GXutil.strtobool( httpContext.cgiGet( "AGELEGACTIVO")) ;
            AV21CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( "vAGEORDEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A25AgeOrden = (short)(localUtil.ctol( httpContext.cgiGet( "AGEORDEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV13Insert_ConCodigo = httpContext.cgiGet( "vINSERT_CONCODIGO") ;
            AV30Insert_AgeLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_AGELIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1254AgeLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "AGELIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1254AgeLiqNro = ((0==A1254AgeLiqNro) ? true : false) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV29existe = GXutil.strtobool( httpContext.cgiGet( "vEXISTE")) ;
            Gx_mode = httpContext.cgiGet( "vMODE") ;
            A2159AgePerDescrip = httpContext.cgiGet( "AGEPERDESCRIP") ;
            A2EmpNom = httpContext.cgiGet( "EMPNOM") ;
            A250LegIdNomApe = httpContext.cgiGet( "LEGIDNOMAPE") ;
            A591LegNomApe = httpContext.cgiGet( "LEGNOMAPE") ;
            A230LegApellido = httpContext.cgiGet( "LEGAPELLIDO") ;
            A251LegNombre = httpContext.cgiGet( "LEGNOMBRE") ;
            A244LegFecEgreso = localUtil.ctod( httpContext.cgiGet( "LEGFECEGRESO"), 0) ;
            n244LegFecEgreso = false ;
            A93LegId = httpContext.cgiGet( "LEGID") ;
            n93LegId = false ;
            A239LegCUIL = localUtil.ctol( httpContext.cgiGet( "LEGCUIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A42ConCodYDesc = httpContext.cgiGet( "CONCODYDESC") ;
            n42ConCodYDesc = false ;
            A41ConDescrip = httpContext.cgiGet( "CONDESCRIP") ;
            AV32Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_concodigo_Objectcall = httpContext.cgiGet( "COMBO_CONCODIGO_Objectcall") ;
            Combo_concodigo_Class = httpContext.cgiGet( "COMBO_CONCODIGO_Class") ;
            Combo_concodigo_Icontype = httpContext.cgiGet( "COMBO_CONCODIGO_Icontype") ;
            Combo_concodigo_Icon = httpContext.cgiGet( "COMBO_CONCODIGO_Icon") ;
            Combo_concodigo_Caption = httpContext.cgiGet( "COMBO_CONCODIGO_Caption") ;
            Combo_concodigo_Tooltip = httpContext.cgiGet( "COMBO_CONCODIGO_Tooltip") ;
            Combo_concodigo_Cls = httpContext.cgiGet( "COMBO_CONCODIGO_Cls") ;
            Combo_concodigo_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONCODIGO_Selectedvalue_set") ;
            Combo_concodigo_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONCODIGO_Selectedvalue_get") ;
            Combo_concodigo_Selectedtext_set = httpContext.cgiGet( "COMBO_CONCODIGO_Selectedtext_set") ;
            Combo_concodigo_Selectedtext_get = httpContext.cgiGet( "COMBO_CONCODIGO_Selectedtext_get") ;
            Combo_concodigo_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONCODIGO_Gamoauthtoken") ;
            Combo_concodigo_Ddointernalname = httpContext.cgiGet( "COMBO_CONCODIGO_Ddointernalname") ;
            Combo_concodigo_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONCODIGO_Titlecontrolalign") ;
            Combo_concodigo_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONCODIGO_Dropdownoptionstype") ;
            Combo_concodigo_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Enabled")) ;
            Combo_concodigo_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Visible")) ;
            Combo_concodigo_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONCODIGO_Titlecontrolidtoreplace") ;
            Combo_concodigo_Datalisttype = httpContext.cgiGet( "COMBO_CONCODIGO_Datalisttype") ;
            Combo_concodigo_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Allowmultipleselection")) ;
            Combo_concodigo_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONCODIGO_Datalistfixedvalues") ;
            Combo_concodigo_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Isgriditem")) ;
            Combo_concodigo_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Hasdescription")) ;
            Combo_concodigo_Datalistproc = httpContext.cgiGet( "COMBO_CONCODIGO_Datalistproc") ;
            Combo_concodigo_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONCODIGO_Datalistprocparametersprefix") ;
            Combo_concodigo_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONCODIGO_Remoteservicesparameters") ;
            Combo_concodigo_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONCODIGO_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_concodigo_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Includeonlyselectedoption")) ;
            Combo_concodigo_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Includeselectalloption")) ;
            Combo_concodigo_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Emptyitem")) ;
            Combo_concodigo_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCODIGO_Includeaddnewoption")) ;
            Combo_concodigo_Htmltemplate = httpContext.cgiGet( "COMBO_CONCODIGO_Htmltemplate") ;
            Combo_concodigo_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONCODIGO_Multiplevaluestype") ;
            Combo_concodigo_Loadingdata = httpContext.cgiGet( "COMBO_CONCODIGO_Loadingdata") ;
            Combo_concodigo_Noresultsfound = httpContext.cgiGet( "COMBO_CONCODIGO_Noresultsfound") ;
            Combo_concodigo_Emptyitemtext = httpContext.cgiGet( "COMBO_CONCODIGO_Emptyitemtext") ;
            Combo_concodigo_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONCODIGO_Onlyselectedvalues") ;
            Combo_concodigo_Selectalltext = httpContext.cgiGet( "COMBO_CONCODIGO_Selectalltext") ;
            Combo_concodigo_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONCODIGO_Multiplevaluesseparator") ;
            Combo_concodigo_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONCODIGO_Addnewoptiontext") ;
            Combo_concodigo_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONCODIGO_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LEGNUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A6LegNumero = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
            else
            {
               A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            }
            A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtAgeCanti_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtAgeCanti_Internalname)), DecimalUtil.stringToDec("999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "AGECANTI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAgeCanti_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A110AgeCanti = DecimalUtil.ZERO ;
               n110AgeCanti = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
            }
            else
            {
               A110AgeCanti = localUtil.ctond( httpContext.cgiGet( edtAgeCanti_Internalname)) ;
               n110AgeCanti = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
            }
            n110AgeCanti = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A110AgeCanti)==0) ? true : false) ;
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtAgeImporte_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtAgeImporte_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "AGEIMPORTE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAgeImporte_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A113AgeImporte = DecimalUtil.ZERO ;
               n113AgeImporte = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
            }
            else
            {
               A113AgeImporte = localUtil.ctond( httpContext.cgiGet( edtAgeImporte_Internalname)) ;
               n113AgeImporte = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
            }
            n113AgeImporte = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A113AgeImporte)==0) ? true : false) ;
            if ( localUtil.vcdate( httpContext.cgiGet( edtAgeFecDes_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "AGEFECDES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAgeFecDes_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A111AgeFecDes = GXutil.nullDate() ;
               n111AgeFecDes = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
            }
            else
            {
               A111AgeFecDes = localUtil.ctod( httpContext.cgiGet( edtAgeFecDes_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               n111AgeFecDes = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
            }
            n111AgeFecDes = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) ? true : false) ;
            if ( localUtil.vcdate( httpContext.cgiGet( edtAgeFecHas_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "AGEFECHAS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAgeFecHas_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A112AgeFecHas = GXutil.nullDate() ;
               n112AgeFecHas = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
            }
            else
            {
               A112AgeFecHas = localUtil.ctod( httpContext.cgiGet( edtAgeFecHas_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               n112AgeFecHas = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
            }
            n112AgeFecHas = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A112AgeFecHas)) ? true : false) ;
            AV20ComboConCodigo = httpContext.cgiGet( edtavComboconcodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ComboConCodigo", AV20ComboConCodigo);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EmpCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            else
            {
               A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtAgeVUnit_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtAgeVUnit_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "AGEVUNIT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAgeVUnit_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A115AgeVUnit = DecimalUtil.ZERO ;
               n115AgeVUnit = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A115AgeVUnit", GXutil.ltrimstr( A115AgeVUnit, 14, 2));
            }
            else
            {
               A115AgeVUnit = localUtil.ctond( httpContext.cgiGet( edtAgeVUnit_Internalname)) ;
               n115AgeVUnit = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A115AgeVUnit", GXutil.ltrimstr( A115AgeVUnit, 14, 2));
            }
            n115AgeVUnit = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A115AgeVUnit)==0) ? true : false) ;
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Novedades");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("AgeLegActivo", GXutil.booltostr( A114AgeLegActivo));
            forbiddenHiddens.add("AgePerDescrip", GXutil.rtrim( localUtil.format( A2159AgePerDescrip, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("novedades:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A25AgeOrden = (short)(GXutil.lval( httpContext.GetPar( "AgeOrden"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode3 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode3 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound3 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1U0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e111U2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121U2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "'DOVOLVER'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoVolver' */
                        e131U2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e121U2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1U3( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes1U3( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Enabled), 5, 0), true);
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_1U0( )
   {
      beforeValidate1U3( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1U3( ) ;
         }
         else
         {
            checkExtendedTable1U3( ) ;
            closeExtendedTableCursors1U3( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1U0( )
   {
   }

   public void e111U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      edtConCodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Visible), 5, 0), true);
      AV20ComboConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboConCodigo", AV20ComboConCodigo);
      edtavComboconcodigo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCONCODIGO' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV22IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Insert", GXv_boolean3) ;
         novedades_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Update", GXv_boolean3) ;
         novedades_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Delete", GXv_boolean3) ;
         novedades_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( ! AV22IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV32Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV32Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV33GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33GXV1), 8, 0));
         while ( AV33GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV33GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConCodigo") == 0 )
            {
               AV13Insert_ConCodigo = AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_ConCodigo", AV13Insert_ConCodigo);
               if ( ! (GXutil.strcmp("", AV13Insert_ConCodigo)==0) )
               {
                  AV20ComboConCodigo = AV13Insert_ConCodigo ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboConCodigo", AV20ComboConCodigo);
                  Combo_concodigo_Selectedvalue_set = AV20ComboConCodigo ;
                  ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "SelectedValue_set", Combo_concodigo_Selectedvalue_set);
                  Combo_concodigo_Enabled = false ;
                  ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "Enabled", GXutil.booltostr( Combo_concodigo_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AgeLiqNro") == 0 )
            {
               AV30Insert_AgeLiqNro = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV30Insert_AgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30Insert_AgeLiqNro), 8, 0));
            }
            AV33GXV1 = (int)(AV33GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtAgeVUnit_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeVUnit_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeVUnit_Visible), 5, 0), true);
      GXv_char4[0] = AV26cantidadAgenda ;
      new web.codigoopeformula(remoteHandle, context).execute( AV21CliCod, "[novedad_cantidad]", false, true, GXv_char4) ;
      novedades_impl.this.AV26cantidadAgenda = GXv_char4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26cantidadAgenda", AV26cantidadAgenda);
      GXv_char4[0] = AV27importeAgenda ;
      new web.codigoopeformula(remoteHandle, context).execute( AV21CliCod, "[novedad_importe]", false, true, GXv_char4) ;
      novedades_impl.this.AV27importeAgenda = GXv_char4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27importeAgenda", AV27importeAgenda);
   }

   public void e121U2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV21CliCod, AV7EmpCod, AV8LegNumero, httpContext.getMessage( "NOVEDADES", "")) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOCONCODIGO' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTComboData_Item5 = AV15ConCodigo_Data ;
      GXv_char4[0] = AV17ComboSelectedValue ;
      GXv_objcol_SdtDVB_SDTComboData_Item6[0] = GXt_objcol_SdtDVB_SDTComboData_Item5 ;
      new web.novedadesloaddvcombo(remoteHandle, context).execute( "ConCodigo", Gx_mode, AV21CliCod, AV7EmpCod, AV8LegNumero, AV9AgeOrden, GXv_char4, GXv_objcol_SdtDVB_SDTComboData_Item6) ;
      novedades_impl.this.AV17ComboSelectedValue = GXv_char4[0] ;
      GXt_objcol_SdtDVB_SDTComboData_Item5 = GXv_objcol_SdtDVB_SDTComboData_Item6[0] ;
      AV15ConCodigo_Data = GXt_objcol_SdtDVB_SDTComboData_Item5 ;
      Combo_concodigo_Selectedvalue_set = AV17ComboSelectedValue ;
      ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "SelectedValue_set", Combo_concodigo_Selectedvalue_set);
      AV20ComboConCodigo = AV17ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboConCodigo", AV20ComboConCodigo);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_concodigo_Enabled = false ;
         ucCombo_concodigo.sendProperty(context, "", false, Combo_concodigo_Internalname, "Enabled", GXutil.booltostr( Combo_concodigo_Enabled));
      }
   }

   public void e131U2( )
   {
      /* 'DoVolver' Routine */
      returnInSub = false ;
      GXv_char4[0] = AV26cantidadAgenda ;
      new web.codigoopeformula(remoteHandle, context).execute( AV21CliCod, "[novedad_cantidad]", false, true, GXv_char4) ;
      novedades_impl.this.AV26cantidadAgenda = GXv_char4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26cantidadAgenda", AV26cantidadAgenda);
      GXv_char4[0] = AV27importeAgenda ;
      new web.codigoopeformula(remoteHandle, context).execute( AV21CliCod, "[novedad_importe]", false, true, GXv_char4) ;
      novedades_impl.this.AV27importeAgenda = GXv_char4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27importeAgenda", AV27importeAgenda);
      /*  Sending Event outputs  */
   }

   public void zm1U3( int GX_JID )
   {
      if ( ( GX_JID == 34 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1254AgeLiqNro = T001U3_A1254AgeLiqNro[0] ;
            Z110AgeCanti = T001U3_A110AgeCanti[0] ;
            Z115AgeVUnit = T001U3_A115AgeVUnit[0] ;
            Z113AgeImporte = T001U3_A113AgeImporte[0] ;
            Z111AgeFecDes = T001U3_A111AgeFecDes[0] ;
            Z112AgeFecHas = T001U3_A112AgeFecHas[0] ;
            Z2159AgePerDescrip = T001U3_A2159AgePerDescrip[0] ;
            Z26ConCodigo = T001U3_A26ConCodigo[0] ;
         }
         else
         {
            Z1254AgeLiqNro = A1254AgeLiqNro ;
            Z110AgeCanti = A110AgeCanti ;
            Z115AgeVUnit = A115AgeVUnit ;
            Z113AgeImporte = A113AgeImporte ;
            Z111AgeFecDes = A111AgeFecDes ;
            Z112AgeFecHas = A112AgeFecHas ;
            Z2159AgePerDescrip = A2159AgePerDescrip ;
            Z26ConCodigo = A26ConCodigo ;
         }
      }
      if ( GX_JID == -34 )
      {
         Z25AgeOrden = A25AgeOrden ;
         Z1254AgeLiqNro = A1254AgeLiqNro ;
         Z110AgeCanti = A110AgeCanti ;
         Z115AgeVUnit = A115AgeVUnit ;
         Z113AgeImporte = A113AgeImporte ;
         Z111AgeFecDes = A111AgeFecDes ;
         Z112AgeFecHas = A112AgeFecHas ;
         Z2159AgePerDescrip = A2159AgePerDescrip ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z26ConCodigo = A26ConCodigo ;
         Z2EmpNom = A2EmpNom ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z591LegNomApe = A591LegNomApe ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
         Z244LegFecEgreso = A244LegFecEgreso ;
         Z93LegId = A93LegId ;
         Z239LegCUIL = A239LegCUIL ;
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z41ConDescrip = A41ConDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV21CliCod) )
      {
         A3CliCod = AV21CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int7 = A3CliCod ;
            GXv_int8[0] = GXt_int7 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
            novedades_impl.this.GXt_int7 = GXv_int8[0] ;
            A3CliCod = GXt_int7 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV21CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV21CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7EmpCod) )
      {
         A1EmpCod = AV7EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV7EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8LegNumero) )
      {
         A6LegNumero = AV8LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      }
      if ( ! (0==AV8LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8LegNumero) )
      {
         edtLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9AgeOrden) )
      {
         A25AgeOrden = AV9AgeOrden ;
         httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
      }
   }

   public void standaloneModal( )
   {
      A114AgeLegActivo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A114AgeLegActivo", A114AgeLegActivo);
      if ( isUpd( )  )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV30Insert_AgeLiqNro) )
      {
         A1254AgeLiqNro = AV30Insert_AgeLiqNro ;
         n1254AgeLiqNro = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1254AgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1254AgeLiqNro), 8, 0));
      }
      else
      {
         if ( isIns( )  )
         {
            A1254AgeLiqNro = 0 ;
            n1254AgeLiqNro = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1254AgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1254AgeLiqNro), 8, 0));
            n1254AgeLiqNro = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1254AgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1254AgeLiqNro), 8, 0));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV13Insert_ConCodigo)==0) )
      {
         edtConCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      }
      else
      {
         if ( isUpd( )  )
         {
            edtConCodigo_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
         }
         else
         {
            edtConCodigo_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV13Insert_ConCodigo)==0) )
      {
         A26ConCodigo = AV13Insert_ConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      else
      {
         A26ConCodigo = AV20ComboConCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) && ( Gx_BScreen == 0 ) )
      {
         A111AgeFecDes = localUtil.ymdtod( GXutil.year( GXutil.serverDate( context, remoteHandle, pr_default)), GXutil.month( GXutil.serverDate( context, remoteHandle, pr_default)), 1) ;
         n111AgeFecDes = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
      }
      else
      {
         if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) && ( Gx_BScreen == 0 ) )
         {
            A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
            n111AgeFecDes = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
         }
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A110AgeCanti)==0) && ( Gx_BScreen == 0 ) )
      {
         A110AgeCanti = DecimalUtil.doubleToDec(1) ;
         n110AgeCanti = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A112AgeFecHas)) && ( Gx_BScreen == 0 ) )
      {
         A112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
         n112AgeFecHas = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV32Pgmname = "Novedades" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
         /* Using cursor T001U4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = T001U4_A2EmpNom[0] ;
         pr_default.close(2);
         /* Using cursor T001U5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T001U5_A250LegIdNomApe[0] ;
         A591LegNomApe = T001U5_A591LegNomApe[0] ;
         A230LegApellido = T001U5_A230LegApellido[0] ;
         A251LegNombre = T001U5_A251LegNombre[0] ;
         A244LegFecEgreso = T001U5_A244LegFecEgreso[0] ;
         n244LegFecEgreso = T001U5_n244LegFecEgreso[0] ;
         A93LegId = T001U5_A93LegId[0] ;
         n93LegId = T001U5_n93LegId[0] ;
         A239LegCUIL = T001U5_A239LegCUIL[0] ;
         pr_default.close(3);
         /* Using cursor T001U6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = T001U6_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T001U6_n42ConCodYDesc[0] ;
         A41ConDescrip = T001U6_A41ConDescrip[0] ;
         pr_default.close(4);
      }
   }

   public void load1U3( )
   {
      /* Using cursor T001U7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A25AgeOrden), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A42ConCodYDesc = T001U7_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T001U7_n42ConCodYDesc[0] ;
         A250LegIdNomApe = T001U7_A250LegIdNomApe[0] ;
         A591LegNomApe = T001U7_A591LegNomApe[0] ;
         A1254AgeLiqNro = T001U7_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = T001U7_n1254AgeLiqNro[0] ;
         A2EmpNom = T001U7_A2EmpNom[0] ;
         A230LegApellido = T001U7_A230LegApellido[0] ;
         A251LegNombre = T001U7_A251LegNombre[0] ;
         A244LegFecEgreso = T001U7_A244LegFecEgreso[0] ;
         n244LegFecEgreso = T001U7_n244LegFecEgreso[0] ;
         A41ConDescrip = T001U7_A41ConDescrip[0] ;
         A110AgeCanti = T001U7_A110AgeCanti[0] ;
         n110AgeCanti = T001U7_n110AgeCanti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
         A115AgeVUnit = T001U7_A115AgeVUnit[0] ;
         n115AgeVUnit = T001U7_n115AgeVUnit[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A115AgeVUnit", GXutil.ltrimstr( A115AgeVUnit, 14, 2));
         A113AgeImporte = T001U7_A113AgeImporte[0] ;
         n113AgeImporte = T001U7_n113AgeImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
         A111AgeFecDes = T001U7_A111AgeFecDes[0] ;
         n111AgeFecDes = T001U7_n111AgeFecDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
         A112AgeFecHas = T001U7_A112AgeFecHas[0] ;
         n112AgeFecHas = T001U7_n112AgeFecHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
         A93LegId = T001U7_A93LegId[0] ;
         n93LegId = T001U7_n93LegId[0] ;
         A239LegCUIL = T001U7_A239LegCUIL[0] ;
         A2159AgePerDescrip = T001U7_A2159AgePerDescrip[0] ;
         A26ConCodigo = T001U7_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         zm1U3( -34) ;
      }
      pr_default.close(5);
      onLoadActions1U3( ) ;
   }

   public void onLoadActions1U3( )
   {
      AV32Pgmname = "Novedades" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
      GXt_char9 = A1133AgePrevCalc ;
      GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = "" ;
      GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char12[0] = GXt_char9 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, true, GXv_decimal10, GXv_char4, GXv_decimal11, GXv_char12) ;
      novedades_impl.this.GXt_char9 = GXv_char12[0] ;
      A1133AgePrevCalc = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1133AgePrevCalc", A1133AgePrevCalc);
      GXt_char9 = A1132AgePrevis ;
      GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char12[0] = "" ;
      GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char9 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal11, GXv_char12, GXv_decimal10, GXv_char4) ;
      novedades_impl.this.GXt_char9 = GXv_char4[0] ;
      A1132AgePrevis = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1132AgePrevis", A1132AgePrevis);
   }

   public void checkExtendedTable1U3( )
   {
      nIsDirty_3 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV32Pgmname = "Novedades" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
      /* Using cursor T001U6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T001U6_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T001U6_n42ConCodYDesc[0] ;
      A41ConDescrip = T001U6_A41ConDescrip[0] ;
      pr_default.close(4);
      /* Using cursor T001U4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2EmpNom = T001U4_A2EmpNom[0] ;
      pr_default.close(2);
      /* Using cursor T001U5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T001U5_A250LegIdNomApe[0] ;
      A591LegNomApe = T001U5_A591LegNomApe[0] ;
      A230LegApellido = T001U5_A230LegApellido[0] ;
      A251LegNombre = T001U5_A251LegNombre[0] ;
      A244LegFecEgreso = T001U5_A244LegFecEgreso[0] ;
      n244LegFecEgreso = T001U5_n244LegFecEgreso[0] ;
      A93LegId = T001U5_A93LegId[0] ;
      n93LegId = T001U5_n93LegId[0] ;
      A239LegCUIL = T001U5_A239LegCUIL[0] ;
      pr_default.close(3);
      nIsDirty_3 = (short)(1) ;
      GXt_char9 = A1133AgePrevCalc ;
      GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char12[0] = "" ;
      GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char9 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, true, GXv_decimal11, GXv_char12, GXv_decimal10, GXv_char4) ;
      novedades_impl.this.GXt_char9 = GXv_char4[0] ;
      A1133AgePrevCalc = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1133AgePrevCalc", A1133AgePrevCalc);
      nIsDirty_3 = (short)(1) ;
      GXt_char9 = A1132AgePrevis ;
      GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char12[0] = "" ;
      GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char9 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal11, GXv_char12, GXv_decimal10, GXv_char4) ;
      novedades_impl.this.GXt_char9 = GXv_char4[0] ;
      A1132AgePrevis = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1132AgePrevis", A1132AgePrevis);
      if ( (0==A6LegNumero) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A26ConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Código", ""), "", "", "", "", "", "", "", ""), 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A110AgeCanti)==0) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La cantidad debe ser mayor a cero", ""), 1, "AGECANTI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAgeCanti_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Desde", ""), "", "", "", "", "", "", "", ""), 1, "AGEFECDES");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAgeFecDes_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A112AgeFecHas)) && GXutil.resetTime(A111AgeFecDes).after( GXutil.resetTime( A112AgeFecHas )) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha hasta debe ser posterior a la fecha desde", ""), 1, "AGEFECDES");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAgeFecDes_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean3[0] = AV29existe ;
         new web.getagendavalorenrango(remoteHandle, context).execute( AV21CliCod, AV7EmpCod, A6LegNumero, A26ConCodigo, A112AgeFecHas, A111AgeFecDes, A25AgeOrden, true, GXv_decimal11, GXv_decimal10, GXv_decimal13, GXv_boolean3) ;
         novedades_impl.this.AV29existe = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29existe", AV29existe);
      }
      if ( ( AV29existe ) && ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Novedad duplicadada ", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1U3( )
   {
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_37( int A3CliCod ,
                          String A26ConCodigo )
   {
      /* Using cursor T001U8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A42ConCodYDesc = T001U8_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T001U8_n42ConCodYDesc[0] ;
      A41ConDescrip = T001U8_A41ConDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A42ConCodYDesc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A41ConDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_35( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T001U9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2EmpNom = T001U9_A2EmpNom[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A2EmpNom)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_36( int A3CliCod ,
                          short A1EmpCod ,
                          int A6LegNumero )
   {
      /* Using cursor T001U10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A250LegIdNomApe = T001U10_A250LegIdNomApe[0] ;
      A591LegNomApe = T001U10_A591LegNomApe[0] ;
      A230LegApellido = T001U10_A230LegApellido[0] ;
      A251LegNombre = T001U10_A251LegNombre[0] ;
      A244LegFecEgreso = T001U10_A244LegFecEgreso[0] ;
      n244LegFecEgreso = T001U10_n244LegFecEgreso[0] ;
      A93LegId = T001U10_A93LegId[0] ;
      n93LegId = T001U10_n93LegId[0] ;
      A239LegCUIL = T001U10_A239LegCUIL[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A250LegIdNomApe)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A591LegNomApe)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230LegApellido)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A251LegNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( localUtil.format(A244LegFecEgreso, "99/99/9999"))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A93LegId))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(11), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey1U3( )
   {
      /* Using cursor T001U11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound3 = (short)(1) ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001U3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1U3( 34) ;
         RcdFound3 = (short)(1) ;
         A25AgeOrden = T001U3_A25AgeOrden[0] ;
         A1254AgeLiqNro = T001U3_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = T001U3_n1254AgeLiqNro[0] ;
         A110AgeCanti = T001U3_A110AgeCanti[0] ;
         n110AgeCanti = T001U3_n110AgeCanti[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
         A115AgeVUnit = T001U3_A115AgeVUnit[0] ;
         n115AgeVUnit = T001U3_n115AgeVUnit[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A115AgeVUnit", GXutil.ltrimstr( A115AgeVUnit, 14, 2));
         A113AgeImporte = T001U3_A113AgeImporte[0] ;
         n113AgeImporte = T001U3_n113AgeImporte[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
         A111AgeFecDes = T001U3_A111AgeFecDes[0] ;
         n111AgeFecDes = T001U3_n111AgeFecDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
         A112AgeFecHas = T001U3_A112AgeFecHas[0] ;
         n112AgeFecHas = T001U3_n112AgeFecHas[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
         A2159AgePerDescrip = T001U3_A2159AgePerDescrip[0] ;
         A3CliCod = T001U3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T001U3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T001U3_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A26ConCodigo = T001U3_A26ConCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z25AgeOrden = A25AgeOrden ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1U3( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey1U3( ) ;
         }
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey1U3( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1U3( ) ;
      if ( RcdFound3 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T001U12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A25AgeOrden), Short.valueOf(A25AgeOrden), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A25AgeOrden), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A25AgeOrden), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T001U12_A25AgeOrden[0] < A25AgeOrden ) || ( T001U12_A25AgeOrden[0] == A25AgeOrden ) && ( T001U12_A3CliCod[0] < A3CliCod ) || ( T001U12_A3CliCod[0] == A3CliCod ) && ( T001U12_A25AgeOrden[0] == A25AgeOrden ) && ( T001U12_A1EmpCod[0] < A1EmpCod ) || ( T001U12_A1EmpCod[0] == A1EmpCod ) && ( T001U12_A3CliCod[0] == A3CliCod ) && ( T001U12_A25AgeOrden[0] == A25AgeOrden ) && ( T001U12_A6LegNumero[0] < A6LegNumero ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T001U12_A25AgeOrden[0] > A25AgeOrden ) || ( T001U12_A25AgeOrden[0] == A25AgeOrden ) && ( T001U12_A3CliCod[0] > A3CliCod ) || ( T001U12_A3CliCod[0] == A3CliCod ) && ( T001U12_A25AgeOrden[0] == A25AgeOrden ) && ( T001U12_A1EmpCod[0] > A1EmpCod ) || ( T001U12_A1EmpCod[0] == A1EmpCod ) && ( T001U12_A3CliCod[0] == A3CliCod ) && ( T001U12_A25AgeOrden[0] == A25AgeOrden ) && ( T001U12_A6LegNumero[0] > A6LegNumero ) ) )
         {
            A25AgeOrden = T001U12_A25AgeOrden[0] ;
            A3CliCod = T001U12_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T001U12_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T001U12_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T001U13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A25AgeOrden), Short.valueOf(A25AgeOrden), Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A25AgeOrden), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A25AgeOrden), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T001U13_A25AgeOrden[0] > A25AgeOrden ) || ( T001U13_A25AgeOrden[0] == A25AgeOrden ) && ( T001U13_A3CliCod[0] > A3CliCod ) || ( T001U13_A3CliCod[0] == A3CliCod ) && ( T001U13_A25AgeOrden[0] == A25AgeOrden ) && ( T001U13_A1EmpCod[0] > A1EmpCod ) || ( T001U13_A1EmpCod[0] == A1EmpCod ) && ( T001U13_A3CliCod[0] == A3CliCod ) && ( T001U13_A25AgeOrden[0] == A25AgeOrden ) && ( T001U13_A6LegNumero[0] > A6LegNumero ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T001U13_A25AgeOrden[0] < A25AgeOrden ) || ( T001U13_A25AgeOrden[0] == A25AgeOrden ) && ( T001U13_A3CliCod[0] < A3CliCod ) || ( T001U13_A3CliCod[0] == A3CliCod ) && ( T001U13_A25AgeOrden[0] == A25AgeOrden ) && ( T001U13_A1EmpCod[0] < A1EmpCod ) || ( T001U13_A1EmpCod[0] == A1EmpCod ) && ( T001U13_A3CliCod[0] == A3CliCod ) && ( T001U13_A25AgeOrden[0] == A25AgeOrden ) && ( T001U13_A6LegNumero[0] < A6LegNumero ) ) )
         {
            A25AgeOrden = T001U13_A25AgeOrden[0] ;
            A3CliCod = T001U13_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T001U13_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A6LegNumero = T001U13_A6LegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1U3( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1U3( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A25AgeOrden != Z25AgeOrden ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A6LegNumero = Z6LegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A25AgeOrden = Z25AgeOrden ;
               httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1U3( ) ;
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A25AgeOrden != Z25AgeOrden ) )
            {
               /* Insert record */
               GX_FocusControl = edtLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1U3( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtLegNumero_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1U3( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A25AgeOrden != Z25AgeOrden ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = Z6LegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A25AgeOrden = Z25AgeOrden ;
         httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLegNumero_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1U3( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001U2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AgendaNovedades"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1254AgeLiqNro != T001U2_A1254AgeLiqNro[0] ) || ( DecimalUtil.compareTo(Z110AgeCanti, T001U2_A110AgeCanti[0]) != 0 ) || ( DecimalUtil.compareTo(Z115AgeVUnit, T001U2_A115AgeVUnit[0]) != 0 ) || ( DecimalUtil.compareTo(Z113AgeImporte, T001U2_A113AgeImporte[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z111AgeFecDes), GXutil.resetTime(T001U2_A111AgeFecDes[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z112AgeFecHas), GXutil.resetTime(T001U2_A112AgeFecHas[0])) ) || ( GXutil.strcmp(Z2159AgePerDescrip, T001U2_A2159AgePerDescrip[0]) != 0 ) || ( GXutil.strcmp(Z26ConCodigo, T001U2_A26ConCodigo[0]) != 0 ) )
         {
            if ( Z1254AgeLiqNro != T001U2_A1254AgeLiqNro[0] )
            {
               GXutil.writeLogln("novedades:[seudo value changed for attri]"+"AgeLiqNro");
               GXutil.writeLogRaw("Old: ",Z1254AgeLiqNro);
               GXutil.writeLogRaw("Current: ",T001U2_A1254AgeLiqNro[0]);
            }
            if ( DecimalUtil.compareTo(Z110AgeCanti, T001U2_A110AgeCanti[0]) != 0 )
            {
               GXutil.writeLogln("novedades:[seudo value changed for attri]"+"AgeCanti");
               GXutil.writeLogRaw("Old: ",Z110AgeCanti);
               GXutil.writeLogRaw("Current: ",T001U2_A110AgeCanti[0]);
            }
            if ( DecimalUtil.compareTo(Z115AgeVUnit, T001U2_A115AgeVUnit[0]) != 0 )
            {
               GXutil.writeLogln("novedades:[seudo value changed for attri]"+"AgeVUnit");
               GXutil.writeLogRaw("Old: ",Z115AgeVUnit);
               GXutil.writeLogRaw("Current: ",T001U2_A115AgeVUnit[0]);
            }
            if ( DecimalUtil.compareTo(Z113AgeImporte, T001U2_A113AgeImporte[0]) != 0 )
            {
               GXutil.writeLogln("novedades:[seudo value changed for attri]"+"AgeImporte");
               GXutil.writeLogRaw("Old: ",Z113AgeImporte);
               GXutil.writeLogRaw("Current: ",T001U2_A113AgeImporte[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z111AgeFecDes), GXutil.resetTime(T001U2_A111AgeFecDes[0])) ) )
            {
               GXutil.writeLogln("novedades:[seudo value changed for attri]"+"AgeFecDes");
               GXutil.writeLogRaw("Old: ",Z111AgeFecDes);
               GXutil.writeLogRaw("Current: ",T001U2_A111AgeFecDes[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z112AgeFecHas), GXutil.resetTime(T001U2_A112AgeFecHas[0])) ) )
            {
               GXutil.writeLogln("novedades:[seudo value changed for attri]"+"AgeFecHas");
               GXutil.writeLogRaw("Old: ",Z112AgeFecHas);
               GXutil.writeLogRaw("Current: ",T001U2_A112AgeFecHas[0]);
            }
            if ( GXutil.strcmp(Z2159AgePerDescrip, T001U2_A2159AgePerDescrip[0]) != 0 )
            {
               GXutil.writeLogln("novedades:[seudo value changed for attri]"+"AgePerDescrip");
               GXutil.writeLogRaw("Old: ",Z2159AgePerDescrip);
               GXutil.writeLogRaw("Current: ",T001U2_A2159AgePerDescrip[0]);
            }
            if ( GXutil.strcmp(Z26ConCodigo, T001U2_A26ConCodigo[0]) != 0 )
            {
               GXutil.writeLogln("novedades:[seudo value changed for attri]"+"ConCodigo");
               GXutil.writeLogRaw("Old: ",Z26ConCodigo);
               GXutil.writeLogRaw("Current: ",T001U2_A26ConCodigo[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"AgendaNovedades"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1U3( )
   {
      beforeValidate1U3( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1U3( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1U3( 0) ;
         checkOptimisticConcurrency1U3( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1U3( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1U3( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001U14 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A25AgeOrden), Boolean.valueOf(n1254AgeLiqNro), Integer.valueOf(A1254AgeLiqNro), Boolean.valueOf(n110AgeCanti), A110AgeCanti, Boolean.valueOf(n115AgeVUnit), A115AgeVUnit, Boolean.valueOf(n113AgeImporte), A113AgeImporte, Boolean.valueOf(n111AgeFecDes), A111AgeFecDes, Boolean.valueOf(n112AgeFecHas), A112AgeFecHas, A2159AgePerDescrip, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
                  if ( (pr_default.getStatus(12) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption1U0( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load1U3( ) ;
         }
         endLevel1U3( ) ;
      }
      closeExtendedTableCursors1U3( ) ;
   }

   public void update1U3( )
   {
      beforeValidate1U3( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1U3( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1U3( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1U3( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1U3( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001U15 */
                  pr_default.execute(13, new Object[] {Boolean.valueOf(n1254AgeLiqNro), Integer.valueOf(A1254AgeLiqNro), Boolean.valueOf(n110AgeCanti), A110AgeCanti, Boolean.valueOf(n115AgeVUnit), A115AgeVUnit, Boolean.valueOf(n113AgeImporte), A113AgeImporte, Boolean.valueOf(n111AgeFecDes), A111AgeFecDes, Boolean.valueOf(n112AgeFecHas), A112AgeFecHas, A2159AgePerDescrip, A26ConCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AgendaNovedades"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1U3( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel1U3( ) ;
      }
      closeExtendedTableCursors1U3( ) ;
   }

   public void deferredUpdate1U3( )
   {
   }

   public void delete( )
   {
      beforeValidate1U3( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1U3( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1U3( ) ;
         afterConfirm1U3( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1U3( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001U16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode3 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1U3( ) ;
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1U3( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV32Pgmname = "Novedades" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32Pgmname", AV32Pgmname);
         /* Using cursor T001U17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = T001U17_A2EmpNom[0] ;
         pr_default.close(15);
         /* Using cursor T001U18 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = T001U18_A250LegIdNomApe[0] ;
         A591LegNomApe = T001U18_A591LegNomApe[0] ;
         A230LegApellido = T001U18_A230LegApellido[0] ;
         A251LegNombre = T001U18_A251LegNombre[0] ;
         A244LegFecEgreso = T001U18_A244LegFecEgreso[0] ;
         n244LegFecEgreso = T001U18_n244LegFecEgreso[0] ;
         A93LegId = T001U18_A93LegId[0] ;
         n93LegId = T001U18_n93LegId[0] ;
         A239LegCUIL = T001U18_A239LegCUIL[0] ;
         pr_default.close(16);
         /* Using cursor T001U19 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = T001U19_A42ConCodYDesc[0] ;
         n42ConCodYDesc = T001U19_n42ConCodYDesc[0] ;
         A41ConDescrip = T001U19_A41ConDescrip[0] ;
         pr_default.close(17);
         GXt_char9 = A1133AgePrevCalc ;
         GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char12[0] = "" ;
         GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char4[0] = GXt_char9 ;
         new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, true, GXv_decimal13, GXv_char12, GXv_decimal11, GXv_char4) ;
         novedades_impl.this.GXt_char9 = GXv_char4[0] ;
         A1133AgePrevCalc = GXt_char9 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1133AgePrevCalc", A1133AgePrevCalc);
         GXt_char9 = A1132AgePrevis ;
         GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char12[0] = "" ;
         GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char4[0] = GXt_char9 ;
         new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal13, GXv_char12, GXv_decimal11, GXv_char4) ;
         novedades_impl.this.GXt_char9 = GXv_char4[0] ;
         A1132AgePrevis = GXt_char9 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1132AgePrevis", A1132AgePrevis);
      }
   }

   public void endLevel1U3( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1U3( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "novedades");
         if ( AnyError == 0 )
         {
            confirmValues1U0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "novedades");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1U3( )
   {
      /* Scan By routine */
      /* Using cursor T001U20 */
      pr_default.execute(18);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A3CliCod = T001U20_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T001U20_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T001U20_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A25AgeOrden = T001U20_A25AgeOrden[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1U3( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A3CliCod = T001U20_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T001U20_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A6LegNumero = T001U20_A6LegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
         A25AgeOrden = T001U20_A25AgeOrden[0] ;
      }
   }

   public void scanEnd1U3( )
   {
      pr_default.close(18);
   }

   public void afterConfirm1U3( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1U3( )
   {
      /* Before Insert Rules */
      GXt_int14 = A25AgeOrden ;
      GXv_int15[0] = GXt_int14 ;
      new web.getnextorden(remoteHandle, context).execute( AV7EmpCod, A6LegNumero, GXv_int15) ;
      novedades_impl.this.GXt_int14 = GXv_int15[0] ;
      A25AgeOrden = GXt_int14 ;
      httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
   }

   public void beforeUpdate1U3( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1U3( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1U3( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1U3( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1U3( )
   {
      edtLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLegNumero_Enabled), 5, 0), true);
      edtConCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConCodigo_Enabled), 5, 0), true);
      edtAgeCanti_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeCanti_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeCanti_Enabled), 5, 0), true);
      edtAgeImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeImporte_Enabled), 5, 0), true);
      edtAgeFecDes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeFecDes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeFecDes_Enabled), 5, 0), true);
      edtAgeFecHas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeFecHas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeFecHas_Enabled), 5, 0), true);
      edtavComboconcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconcodigo_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtAgeVUnit_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAgeVUnit_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAgeVUnit_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1U3( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1U0( )
   {
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.novedades", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV21CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9AgeOrden,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","AgeOrden"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Novedades");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("AgeLegActivo", GXutil.booltostr( A114AgeLegActivo));
      forbiddenHiddens.add("AgePerDescrip", GXutil.rtrim( localUtil.format( A2159AgePerDescrip, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("novedades:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z6LegNumero", GXutil.ltrim( localUtil.ntoc( Z6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z25AgeOrden", GXutil.ltrim( localUtil.ntoc( Z25AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1254AgeLiqNro", GXutil.ltrim( localUtil.ntoc( Z1254AgeLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z110AgeCanti", GXutil.ltrim( localUtil.ntoc( Z110AgeCanti, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z115AgeVUnit", GXutil.ltrim( localUtil.ntoc( Z115AgeVUnit, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z113AgeImporte", GXutil.ltrim( localUtil.ntoc( Z113AgeImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z111AgeFecDes", localUtil.dtoc( Z111AgeFecDes, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z112AgeFecHas", localUtil.dtoc( Z112AgeFecHas, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2159AgePerDescrip", Z2159AgePerDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z26ConCodigo", GXutil.rtrim( Z26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N26ConCodigo", GXutil.rtrim( A26ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "N1254AgeLiqNro", GXutil.ltrim( localUtil.ntoc( A1254AgeLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONCODIGO_DATA", AV15ConCodigo_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONCODIGO_DATA", AV15ConCodigo_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "AGEPREVCALC", GXutil.rtrim( A1133AgePrevCalc));
      web.GxWebStd.gx_hidden_field( httpContext, "AGEPREVIS", A1132AgePrevis);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "AGELEGACTIVO", A114AgeLegActivo);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV21CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV7EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV8LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vAGEORDEN", GXutil.ltrim( localUtil.ntoc( AV9AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAGEORDEN", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9AgeOrden), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "AGEORDEN", GXutil.ltrim( localUtil.ntoc( A25AgeOrden, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONCODIGO", GXutil.rtrim( AV13Insert_ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_AGELIQNRO", GXutil.ltrim( localUtil.ntoc( AV30Insert_AgeLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "AGELIQNRO", GXutil.ltrim( localUtil.ntoc( A1254AgeLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vEXISTE", AV29existe);
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "AGEPERDESCRIP", A2159AgePerDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "EMPNOM", A2EmpNom);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGIDNOMAPE", A250LegIdNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNOMAPE", A591LegNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGAPELLIDO", A230LegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNOMBRE", A251LegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "LEGFECEGRESO", localUtil.dtoc( A244LegFecEgreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGID", GXutil.rtrim( A93LegId));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGCUIL", GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONCODYDESC", A42ConCodYDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "CONDESCRIP", A41ConDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV32Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Objectcall", GXutil.rtrim( Combo_concodigo_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Cls", GXutil.rtrim( Combo_concodigo_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Selectedvalue_set", GXutil.rtrim( Combo_concodigo_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Enabled", GXutil.booltostr( Combo_concodigo_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCODIGO_Emptyitem", GXutil.booltostr( Combo_concodigo_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.novedades", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV21CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV7EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8LegNumero,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9AgeOrden,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LegNumero","AgeOrden"})  ;
   }

   public String getPgmname( )
   {
      return "Novedades" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Agenda de Novedades", "") ;
   }

   public void initializeNonKey1U3( )
   {
      A26ConCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A26ConCodigo", A26ConCodigo);
      A1254AgeLiqNro = 0 ;
      n1254AgeLiqNro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1254AgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1254AgeLiqNro), 8, 0));
      AV29existe = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29existe", AV29existe);
      A114AgeLegActivo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A114AgeLegActivo", A114AgeLegActivo);
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      A250LegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      A591LegNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A591LegNomApe", A591LegNomApe);
      A1132AgePrevis = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1132AgePrevis", A1132AgePrevis);
      A1133AgePrevCalc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1133AgePrevCalc", A1133AgePrevCalc);
      A2EmpNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      A230LegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      A251LegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      A244LegFecEgreso = GXutil.nullDate() ;
      n244LegFecEgreso = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A244LegFecEgreso", localUtil.format(A244LegFecEgreso, "99/99/9999"));
      A41ConDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
      A115AgeVUnit = DecimalUtil.ZERO ;
      n115AgeVUnit = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A115AgeVUnit", GXutil.ltrimstr( A115AgeVUnit, 14, 2));
      n115AgeVUnit = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A115AgeVUnit)==0) ? true : false) ;
      A113AgeImporte = DecimalUtil.ZERO ;
      n113AgeImporte = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A113AgeImporte", GXutil.ltrimstr( A113AgeImporte, 14, 2));
      n113AgeImporte = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A113AgeImporte)==0) ? true : false) ;
      A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
      A93LegId = "" ;
      n93LegId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", A93LegId);
      A239LegCUIL = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A239LegCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(A239LegCUIL), 11, 0));
      A2159AgePerDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2159AgePerDescrip", A2159AgePerDescrip);
      A110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
      A112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
      Z1254AgeLiqNro = 0 ;
      Z110AgeCanti = DecimalUtil.ZERO ;
      Z115AgeVUnit = DecimalUtil.ZERO ;
      Z113AgeImporte = DecimalUtil.ZERO ;
      Z111AgeFecDes = GXutil.nullDate() ;
      Z112AgeFecHas = GXutil.nullDate() ;
      Z2159AgePerDescrip = "" ;
      Z26ConCodigo = "" ;
   }

   public void initAll1U3( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A6LegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A25AgeOrden = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
      initializeNonKey1U3( ) ;
   }

   public void standaloneModalInsert( )
   {
      A114AgeLegActivo = i114AgeLegActivo ;
      httpContext.ajax_rsp_assign_attri("", false, "A114AgeLegActivo", A114AgeLegActivo);
      A1254AgeLiqNro = i1254AgeLiqNro ;
      n1254AgeLiqNro = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1254AgeLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1254AgeLiqNro), 8, 0));
      A111AgeFecDes = i111AgeFecDes ;
      n111AgeFecDes = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A111AgeFecDes", localUtil.format(A111AgeFecDes, "99/99/9999"));
      A110AgeCanti = i110AgeCanti ;
      n110AgeCanti = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A110AgeCanti", GXutil.ltrimstr( A110AgeCanti, 9, 2));
      A112AgeFecHas = i112AgeFecHas ;
      n112AgeFecHas = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A112AgeFecHas", localUtil.format(A112AgeFecHas, "99/99/9999"));
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171355517", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("novedades.js", "?2025171355517", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtLegNumero_Internalname = "LEGNUMERO" ;
      lblTextblockconcodigo_Internalname = "TEXTBLOCKCONCODIGO" ;
      Combo_concodigo_Internalname = "COMBO_CONCODIGO" ;
      edtConCodigo_Internalname = "CONCODIGO" ;
      divTablesplittedconcodigo_Internalname = "TABLESPLITTEDCONCODIGO" ;
      edtAgeCanti_Internalname = "AGECANTI" ;
      lblTextblockageimporte_Internalname = "TEXTBLOCKAGEIMPORTE" ;
      edtAgeImporte_Internalname = "AGEIMPORTE" ;
      lblAgeimporte_righttext_Internalname = "AGEIMPORTE_RIGHTTEXT" ;
      tblTablemergedageimporte_Internalname = "TABLEMERGEDAGEIMPORTE" ;
      divTablesplittedageimporte_Internalname = "TABLESPLITTEDAGEIMPORTE" ;
      edtAgeFecDes_Internalname = "AGEFECDES" ;
      edtAgeFecHas_Internalname = "AGEFECHAS" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboconcodigo_Internalname = "vCOMBOCONCODIGO" ;
      divSectionattribute_concodigo_Internalname = "SECTIONATTRIBUTE_CONCODIGO" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtAgeVUnit_Internalname = "AGEVUNIT" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Agenda de Novedades", "") );
      edtAgeVUnit_Jsonclick = "" ;
      edtAgeVUnit_Enabled = 1 ;
      edtAgeVUnit_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavComboconcodigo_Jsonclick = "" ;
      edtavComboconcodigo_Enabled = 0 ;
      edtavComboconcodigo_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtAgeFecHas_Jsonclick = "" ;
      edtAgeFecHas_Enabled = 1 ;
      edtAgeFecDes_Jsonclick = "" ;
      edtAgeFecDes_Enabled = 1 ;
      edtAgeImporte_Jsonclick = "" ;
      edtAgeImporte_Enabled = 1 ;
      edtAgeCanti_Jsonclick = "" ;
      edtAgeCanti_Enabled = 1 ;
      edtConCodigo_Jsonclick = "" ;
      edtConCodigo_Enabled = 1 ;
      edtConCodigo_Visible = 1 ;
      Combo_concodigo_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_concodigo_Cls = "ExtendedCombo Attribute" ;
      Combo_concodigo_Enabled = GXutil.toBoolean( -1) ;
      edtLegNumero_Jsonclick = "" ;
      edtLegNumero_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx3asaageprevcalc1U3( int A3CliCod ,
                                     short A1EmpCod ,
                                     int A6LegNumero ,
                                     String A26ConCodigo ,
                                     java.math.BigDecimal A110AgeCanti ,
                                     java.math.BigDecimal A113AgeImporte ,
                                     java.util.Date A111AgeFecDes ,
                                     java.util.Date A112AgeFecHas )
   {
      GXt_char9 = A1133AgePrevCalc ;
      GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char12[0] = "" ;
      GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char9 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, true, GXv_decimal13, GXv_char12, GXv_decimal11, GXv_char4) ;
      novedades_impl.this.GXt_char9 = GXv_char4[0] ;
      A1133AgePrevCalc = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1133AgePrevCalc", A1133AgePrevCalc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1133AgePrevCalc))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx4asaageprevis1U3( int A3CliCod ,
                                   short A1EmpCod ,
                                   int A6LegNumero ,
                                   String A26ConCodigo ,
                                   java.math.BigDecimal A110AgeCanti ,
                                   java.math.BigDecimal A113AgeImporte ,
                                   java.util.Date A111AgeFecDes ,
                                   java.util.Date A112AgeFecHas )
   {
      GXt_char9 = A1132AgePrevis ;
      GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char12[0] = "" ;
      GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char9 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal13, GXv_char12, GXv_decimal11, GXv_char4) ;
      novedades_impl.this.GXt_char9 = GXv_char4[0] ;
      A1132AgePrevis = GXt_char9 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1132AgePrevis", A1132AgePrevis);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1132AgePrevis)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx6asaclicod1U3( int AV21CliCod )
   {
      if ( ! (0==AV21CliCod) )
      {
         A3CliCod = AV21CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int7 = A3CliCod ;
            GXv_int8[0] = GXt_int7 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int8) ;
            novedades_impl.this.GXt_int7 = GXv_int8[0] ;
            A3CliCod = GXt_int7 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx12asaageorden1U3( short AV9AgeOrden )
   {
      if ( ! (0==AV9AgeOrden) )
      {
         A25AgeOrden = AV9AgeOrden ;
         httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A25AgeOrden, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx13asaageorden1U3( short AV7EmpCod ,
                                   int A6LegNumero )
   {
      GXt_int14 = A25AgeOrden ;
      GXv_int15[0] = GXt_int14 ;
      new web.getnextorden(remoteHandle, context).execute( AV7EmpCod, A6LegNumero, GXv_int15) ;
      novedades_impl.this.GXt_int14 = GXv_int15[0] ;
      A25AgeOrden = GXt_int14 ;
      httpContext.ajax_rsp_assign_attri("", false, "A25AgeOrden", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25AgeOrden), 4, 0));
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A25AgeOrden, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_32_1U3( int AV21CliCod ,
                          short AV7EmpCod ,
                          int A6LegNumero ,
                          String A26ConCodigo ,
                          java.util.Date A112AgeFecHas ,
                          java.util.Date A111AgeFecDes ,
                          short A25AgeOrden ,
                          String Gx_mode )
   {
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean3[0] = AV29existe ;
         new web.getagendavalorenrango(remoteHandle, context).execute( AV21CliCod, AV7EmpCod, A6LegNumero, A26ConCodigo, A112AgeFecHas, A111AgeFecDes, A25AgeOrden, true, GXv_decimal13, GXv_decimal11, GXv_decimal10, GXv_boolean3) ;
         AV29existe = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29existe", AV29existe);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV29existe))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Empcod( )
   {
      n244LegFecEgreso = false ;
      n93LegId = false ;
      /* Using cursor T001U17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A2EmpNom = T001U17_A2EmpNom[0] ;
      pr_default.close(15);
      /* Using cursor T001U18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A250LegIdNomApe = T001U18_A250LegIdNomApe[0] ;
      A591LegNomApe = T001U18_A591LegNomApe[0] ;
      A230LegApellido = T001U18_A230LegApellido[0] ;
      A251LegNombre = T001U18_A251LegNombre[0] ;
      A244LegFecEgreso = T001U18_A244LegFecEgreso[0] ;
      n244LegFecEgreso = T001U18_n244LegFecEgreso[0] ;
      A93LegId = T001U18_A93LegId[0] ;
      n93LegId = T001U18_n93LegId[0] ;
      A239LegCUIL = T001U18_A239LegCUIL[0] ;
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A2EmpNom", A2EmpNom);
      httpContext.ajax_rsp_assign_attri("", false, "A250LegIdNomApe", A250LegIdNomApe);
      httpContext.ajax_rsp_assign_attri("", false, "A591LegNomApe", A591LegNomApe);
      httpContext.ajax_rsp_assign_attri("", false, "A230LegApellido", A230LegApellido);
      httpContext.ajax_rsp_assign_attri("", false, "A251LegNombre", A251LegNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A244LegFecEgreso", localUtil.format(A244LegFecEgreso, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A93LegId", GXutil.rtrim( A93LegId));
      httpContext.ajax_rsp_assign_attri("", false, "A239LegCUIL", GXutil.ltrim( localUtil.ntoc( A239LegCUIL, (byte)(11), (byte)(0), ".", "")));
   }

   public void valid_Concodigo( )
   {
      n42ConCodYDesc = false ;
      /* Using cursor T001U19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      A42ConCodYDesc = T001U19_A42ConCodYDesc[0] ;
      n42ConCodYDesc = T001U19_n42ConCodYDesc[0] ;
      A41ConDescrip = T001U19_A41ConDescrip[0] ;
      pr_default.close(17);
      if ( (GXutil.strcmp("", A26ConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Código", ""), "", "", "", "", "", "", "", ""), 1, "CONCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConCodigo_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A42ConCodYDesc", A42ConCodYDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A41ConDescrip", A41ConDescrip);
   }

   public void valid_Agefechas( )
   {
      n110AgeCanti = false ;
      n113AgeImporte = false ;
      n111AgeFecDes = false ;
      n112AgeFecHas = false ;
      GXt_char9 = A1133AgePrevCalc ;
      GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char12[0] = "" ;
      GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char9 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, true, GXv_decimal13, GXv_char12, GXv_decimal11, GXv_char4) ;
      novedades_impl.this.GXt_char9 = GXv_char4[0] ;
      A1133AgePrevCalc = GXt_char9 ;
      GXt_char9 = A1132AgePrevis ;
      GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char12[0] = "" ;
      GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char9 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal13, GXv_char12, GXv_decimal11, GXv_char4) ;
      novedades_impl.this.GXt_char9 = GXv_char4[0] ;
      A1132AgePrevis = GXt_char9 ;
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A112AgeFecHas)) && GXutil.resetTime(A111AgeFecDes).after( GXutil.resetTime( A112AgeFecHas )) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha hasta debe ser posterior a la fecha desde", ""), 1, "AGEFECHAS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAgeFecHas_Internalname ;
      }
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) )
      {
         GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean3[0] = AV29existe ;
         new web.getagendavalorenrango(remoteHandle, context).execute( AV21CliCod, AV7EmpCod, A6LegNumero, A26ConCodigo, A112AgeFecHas, A111AgeFecDes, A25AgeOrden, true, GXv_decimal13, GXv_decimal11, GXv_decimal10, GXv_boolean3) ;
         novedades_impl.this.AV29existe = GXv_boolean3[0] ;
         AV29existe = this.AV29existe ;
      }
      if ( ( AV29existe ) && ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Novedad duplicadada ", ""), 1, "AGEFECHAS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAgeFecHas_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1133AgePrevCalc", GXutil.rtrim( A1133AgePrevCalc));
      httpContext.ajax_rsp_assign_attri("", false, "A1132AgePrevis", A1132AgePrevis);
      httpContext.ajax_rsp_assign_attri("", false, "AV29existe", AV29existe);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV21CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV9AgeOrden',fld:'vAGEORDEN',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV21CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV9AgeOrden',fld:'vAGEORDEN',pic:'ZZZ9',hsh:true},{av:'A114AgeLegActivo',fld:'AGELEGACTIVO',pic:''},{av:'A2159AgePerDescrip',fld:'AGEPERDESCRIP',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e121U2',iparms:[{av:'AV21CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV8LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("'DOVOLVER'","{handler:'e131U2',iparms:[{av:'AV21CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOVOLVER'",",oparms:[{av:'AV26cantidadAgenda',fld:'vCANTIDADAGENDA',pic:''},{av:'AV27importeAgenda',fld:'vIMPORTEAGENDA',pic:''}]}");
      setEventMetadata("VALID_LEGNUMERO","{handler:'valid_Legnumero',iparms:[]");
      setEventMetadata("VALID_LEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''}]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[{av:'A42ConCodYDesc',fld:'CONCODYDESC',pic:''},{av:'A41ConDescrip',fld:'CONDESCRIP',pic:''}]}");
      setEventMetadata("VALID_AGECANTI","{handler:'valid_Agecanti',iparms:[]");
      setEventMetadata("VALID_AGECANTI",",oparms:[]}");
      setEventMetadata("VALID_AGEIMPORTE","{handler:'valid_Ageimporte',iparms:[]");
      setEventMetadata("VALID_AGEIMPORTE",",oparms:[]}");
      setEventMetadata("VALID_AGEFECDES","{handler:'valid_Agefecdes',iparms:[]");
      setEventMetadata("VALID_AGEFECDES",",oparms:[]}");
      setEventMetadata("VALID_AGEFECHAS","{handler:'valid_Agefechas',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A26ConCodigo',fld:'CONCODIGO',pic:''},{av:'A110AgeCanti',fld:'AGECANTI',pic:'ZZZZZ9.99'},{av:'A113AgeImporte',fld:'AGEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A111AgeFecDes',fld:'AGEFECDES',pic:''},{av:'A112AgeFecHas',fld:'AGEFECHAS',pic:''},{av:'AV21CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A25AgeOrden',fld:'AGEORDEN',pic:'ZZZ9'},{av:'AV29existe',fld:'vEXISTE',pic:''},{av:'A1133AgePrevCalc',fld:'AGEPREVCALC',pic:''},{av:'A1132AgePrevis',fld:'AGEPREVIS',pic:''}]");
      setEventMetadata("VALID_AGEFECHAS",",oparms:[{av:'A1133AgePrevCalc',fld:'AGEPREVCALC',pic:''},{av:'A1132AgePrevis',fld:'AGEPREVIS',pic:''},{av:'AV29existe',fld:'vEXISTE',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCONCODIGO","{handler:'validv_Comboconcodigo',iparms:[]");
      setEventMetadata("VALIDV_COMBOCONCODIGO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A591LegNomApe',fld:'LEGNOMAPE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''},{av:'A239LegCUIL',fld:'LEGCUIL',pic:'ZZ-ZZZZZZZZ-9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'A2EmpNom',fld:'EMPNOM',pic:'@!'},{av:'A250LegIdNomApe',fld:'LEGIDNOMAPE',pic:''},{av:'A591LegNomApe',fld:'LEGNOMAPE',pic:''},{av:'A230LegApellido',fld:'LEGAPELLIDO',pic:''},{av:'A251LegNombre',fld:'LEGNOMBRE',pic:''},{av:'A244LegFecEgreso',fld:'LEGFECEGRESO',pic:''},{av:'A93LegId',fld:'LEGID',pic:''},{av:'A239LegCUIL',fld:'LEGCUIL',pic:'ZZ-ZZZZZZZZ-9'}]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "agendanovedades_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(15);
      pr_default.close(16);
      pr_default.close(17);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z110AgeCanti = DecimalUtil.ZERO ;
      Z115AgeVUnit = DecimalUtil.ZERO ;
      Z113AgeImporte = DecimalUtil.ZERO ;
      Z111AgeFecDes = GXutil.nullDate() ;
      Z112AgeFecHas = GXutil.nullDate() ;
      Z2159AgePerDescrip = "" ;
      Z26ConCodigo = "" ;
      N26ConCodigo = "" ;
      Combo_concodigo_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A26ConCodigo = "" ;
      A112AgeFecHas = GXutil.nullDate() ;
      A111AgeFecDes = GXutil.nullDate() ;
      Gx_mode = "" ;
      A110AgeCanti = DecimalUtil.ZERO ;
      A113AgeImporte = DecimalUtil.ZERO ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      lblTextblockconcodigo_Jsonclick = "" ;
      ucCombo_concodigo = new com.genexus.webpanels.GXUserControl();
      Combo_concodigo_Caption = "" ;
      AV15ConCodigo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockageimporte_Jsonclick = "" ;
      lblAgeimporte_righttext_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV20ComboConCodigo = "" ;
      A115AgeVUnit = DecimalUtil.ZERO ;
      A2159AgePerDescrip = "" ;
      A1133AgePrevCalc = "" ;
      A1132AgePrevis = "" ;
      AV13Insert_ConCodigo = "" ;
      A2EmpNom = "" ;
      A250LegIdNomApe = "" ;
      A591LegNomApe = "" ;
      A230LegApellido = "" ;
      A251LegNombre = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A93LegId = "" ;
      A42ConCodYDesc = "" ;
      A41ConDescrip = "" ;
      AV32Pgmname = "" ;
      Combo_concodigo_Objectcall = "" ;
      Combo_concodigo_Class = "" ;
      Combo_concodigo_Icontype = "" ;
      Combo_concodigo_Icon = "" ;
      Combo_concodigo_Tooltip = "" ;
      Combo_concodigo_Selectedvalue_set = "" ;
      Combo_concodigo_Selectedtext_set = "" ;
      Combo_concodigo_Selectedtext_get = "" ;
      Combo_concodigo_Gamoauthtoken = "" ;
      Combo_concodigo_Ddointernalname = "" ;
      Combo_concodigo_Titlecontrolalign = "" ;
      Combo_concodigo_Dropdownoptionstype = "" ;
      Combo_concodigo_Titlecontrolidtoreplace = "" ;
      Combo_concodigo_Datalisttype = "" ;
      Combo_concodigo_Datalistfixedvalues = "" ;
      Combo_concodigo_Datalistproc = "" ;
      Combo_concodigo_Datalistprocparametersprefix = "" ;
      Combo_concodigo_Remoteservicesparameters = "" ;
      Combo_concodigo_Htmltemplate = "" ;
      Combo_concodigo_Multiplevaluestype = "" ;
      Combo_concodigo_Loadingdata = "" ;
      Combo_concodigo_Noresultsfound = "" ;
      Combo_concodigo_Emptyitemtext = "" ;
      Combo_concodigo_Onlyselectedvalues = "" ;
      Combo_concodigo_Selectalltext = "" ;
      Combo_concodigo_Multiplevaluesseparator = "" ;
      Combo_concodigo_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode3 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV26cantidadAgenda = "" ;
      AV27importeAgenda = "" ;
      GXt_objcol_SdtDVB_SDTComboData_Item5 = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV17ComboSelectedValue = "" ;
      GXv_objcol_SdtDVB_SDTComboData_Item6 = new GXBaseCollection[1] ;
      Z2EmpNom = "" ;
      Z250LegIdNomApe = "" ;
      Z591LegNomApe = "" ;
      Z230LegApellido = "" ;
      Z251LegNombre = "" ;
      Z244LegFecEgreso = GXutil.nullDate() ;
      Z93LegId = "" ;
      Z42ConCodYDesc = "" ;
      Z41ConDescrip = "" ;
      T001U4_A2EmpNom = new String[] {""} ;
      T001U5_A250LegIdNomApe = new String[] {""} ;
      T001U5_A591LegNomApe = new String[] {""} ;
      T001U5_A230LegApellido = new String[] {""} ;
      T001U5_A251LegNombre = new String[] {""} ;
      T001U5_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T001U5_n244LegFecEgreso = new boolean[] {false} ;
      T001U5_A93LegId = new String[] {""} ;
      T001U5_n93LegId = new boolean[] {false} ;
      T001U5_A239LegCUIL = new long[1] ;
      T001U6_A42ConCodYDesc = new String[] {""} ;
      T001U6_n42ConCodYDesc = new boolean[] {false} ;
      T001U6_A41ConDescrip = new String[] {""} ;
      T001U7_A42ConCodYDesc = new String[] {""} ;
      T001U7_n42ConCodYDesc = new boolean[] {false} ;
      T001U7_A250LegIdNomApe = new String[] {""} ;
      T001U7_A591LegNomApe = new String[] {""} ;
      T001U7_A25AgeOrden = new short[1] ;
      T001U7_A1254AgeLiqNro = new int[1] ;
      T001U7_n1254AgeLiqNro = new boolean[] {false} ;
      T001U7_A2EmpNom = new String[] {""} ;
      T001U7_A230LegApellido = new String[] {""} ;
      T001U7_A251LegNombre = new String[] {""} ;
      T001U7_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T001U7_n244LegFecEgreso = new boolean[] {false} ;
      T001U7_A41ConDescrip = new String[] {""} ;
      T001U7_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U7_n110AgeCanti = new boolean[] {false} ;
      T001U7_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U7_n115AgeVUnit = new boolean[] {false} ;
      T001U7_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U7_n113AgeImporte = new boolean[] {false} ;
      T001U7_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      T001U7_n111AgeFecDes = new boolean[] {false} ;
      T001U7_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      T001U7_n112AgeFecHas = new boolean[] {false} ;
      T001U7_A93LegId = new String[] {""} ;
      T001U7_n93LegId = new boolean[] {false} ;
      T001U7_A239LegCUIL = new long[1] ;
      T001U7_A2159AgePerDescrip = new String[] {""} ;
      T001U7_A3CliCod = new int[1] ;
      T001U7_A1EmpCod = new short[1] ;
      T001U7_A6LegNumero = new int[1] ;
      T001U7_A26ConCodigo = new String[] {""} ;
      T001U8_A42ConCodYDesc = new String[] {""} ;
      T001U8_n42ConCodYDesc = new boolean[] {false} ;
      T001U8_A41ConDescrip = new String[] {""} ;
      T001U9_A2EmpNom = new String[] {""} ;
      T001U10_A250LegIdNomApe = new String[] {""} ;
      T001U10_A591LegNomApe = new String[] {""} ;
      T001U10_A230LegApellido = new String[] {""} ;
      T001U10_A251LegNombre = new String[] {""} ;
      T001U10_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T001U10_n244LegFecEgreso = new boolean[] {false} ;
      T001U10_A93LegId = new String[] {""} ;
      T001U10_n93LegId = new boolean[] {false} ;
      T001U10_A239LegCUIL = new long[1] ;
      T001U11_A3CliCod = new int[1] ;
      T001U11_A1EmpCod = new short[1] ;
      T001U11_A6LegNumero = new int[1] ;
      T001U11_A25AgeOrden = new short[1] ;
      T001U3_A25AgeOrden = new short[1] ;
      T001U3_A1254AgeLiqNro = new int[1] ;
      T001U3_n1254AgeLiqNro = new boolean[] {false} ;
      T001U3_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U3_n110AgeCanti = new boolean[] {false} ;
      T001U3_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U3_n115AgeVUnit = new boolean[] {false} ;
      T001U3_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U3_n113AgeImporte = new boolean[] {false} ;
      T001U3_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      T001U3_n111AgeFecDes = new boolean[] {false} ;
      T001U3_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      T001U3_n112AgeFecHas = new boolean[] {false} ;
      T001U3_A2159AgePerDescrip = new String[] {""} ;
      T001U3_A3CliCod = new int[1] ;
      T001U3_A1EmpCod = new short[1] ;
      T001U3_A6LegNumero = new int[1] ;
      T001U3_A26ConCodigo = new String[] {""} ;
      T001U12_A25AgeOrden = new short[1] ;
      T001U12_A3CliCod = new int[1] ;
      T001U12_A1EmpCod = new short[1] ;
      T001U12_A6LegNumero = new int[1] ;
      T001U13_A25AgeOrden = new short[1] ;
      T001U13_A3CliCod = new int[1] ;
      T001U13_A1EmpCod = new short[1] ;
      T001U13_A6LegNumero = new int[1] ;
      T001U2_A25AgeOrden = new short[1] ;
      T001U2_A1254AgeLiqNro = new int[1] ;
      T001U2_n1254AgeLiqNro = new boolean[] {false} ;
      T001U2_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U2_n110AgeCanti = new boolean[] {false} ;
      T001U2_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U2_n115AgeVUnit = new boolean[] {false} ;
      T001U2_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001U2_n113AgeImporte = new boolean[] {false} ;
      T001U2_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      T001U2_n111AgeFecDes = new boolean[] {false} ;
      T001U2_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      T001U2_n112AgeFecHas = new boolean[] {false} ;
      T001U2_A2159AgePerDescrip = new String[] {""} ;
      T001U2_A3CliCod = new int[1] ;
      T001U2_A1EmpCod = new short[1] ;
      T001U2_A6LegNumero = new int[1] ;
      T001U2_A26ConCodigo = new String[] {""} ;
      T001U17_A2EmpNom = new String[] {""} ;
      T001U18_A250LegIdNomApe = new String[] {""} ;
      T001U18_A591LegNomApe = new String[] {""} ;
      T001U18_A230LegApellido = new String[] {""} ;
      T001U18_A251LegNombre = new String[] {""} ;
      T001U18_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T001U18_n244LegFecEgreso = new boolean[] {false} ;
      T001U18_A93LegId = new String[] {""} ;
      T001U18_n93LegId = new boolean[] {false} ;
      T001U18_A239LegCUIL = new long[1] ;
      T001U19_A42ConCodYDesc = new String[] {""} ;
      T001U19_n42ConCodYDesc = new boolean[] {false} ;
      T001U19_A41ConDescrip = new String[] {""} ;
      T001U20_A3CliCod = new int[1] ;
      T001U20_A1EmpCod = new short[1] ;
      T001U20_A6LegNumero = new int[1] ;
      T001U20_A25AgeOrden = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i111AgeFecDes = GXutil.nullDate() ;
      i110AgeCanti = DecimalUtil.ZERO ;
      i112AgeFecHas = GXutil.nullDate() ;
      GXv_int8 = new int[1] ;
      GXv_int15 = new short[1] ;
      GXt_char9 = "" ;
      GXv_char12 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      GXv_boolean3 = new boolean[1] ;
      Z1133AgePrevCalc = "" ;
      Z1132AgePrevis = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedades__default(),
         new Object[] {
             new Object[] {
            T001U2_A25AgeOrden, T001U2_A1254AgeLiqNro, T001U2_n1254AgeLiqNro, T001U2_A110AgeCanti, T001U2_n110AgeCanti, T001U2_A115AgeVUnit, T001U2_n115AgeVUnit, T001U2_A113AgeImporte, T001U2_n113AgeImporte, T001U2_A111AgeFecDes,
            T001U2_n111AgeFecDes, T001U2_A112AgeFecHas, T001U2_n112AgeFecHas, T001U2_A2159AgePerDescrip, T001U2_A3CliCod, T001U2_A1EmpCod, T001U2_A6LegNumero, T001U2_A26ConCodigo
            }
            , new Object[] {
            T001U3_A25AgeOrden, T001U3_A1254AgeLiqNro, T001U3_n1254AgeLiqNro, T001U3_A110AgeCanti, T001U3_n110AgeCanti, T001U3_A115AgeVUnit, T001U3_n115AgeVUnit, T001U3_A113AgeImporte, T001U3_n113AgeImporte, T001U3_A111AgeFecDes,
            T001U3_n111AgeFecDes, T001U3_A112AgeFecHas, T001U3_n112AgeFecHas, T001U3_A2159AgePerDescrip, T001U3_A3CliCod, T001U3_A1EmpCod, T001U3_A6LegNumero, T001U3_A26ConCodigo
            }
            , new Object[] {
            T001U4_A2EmpNom
            }
            , new Object[] {
            T001U5_A250LegIdNomApe, T001U5_A591LegNomApe, T001U5_A230LegApellido, T001U5_A251LegNombre, T001U5_A244LegFecEgreso, T001U5_n244LegFecEgreso, T001U5_A93LegId, T001U5_n93LegId, T001U5_A239LegCUIL
            }
            , new Object[] {
            T001U6_A42ConCodYDesc, T001U6_n42ConCodYDesc, T001U6_A41ConDescrip
            }
            , new Object[] {
            T001U7_A42ConCodYDesc, T001U7_n42ConCodYDesc, T001U7_A250LegIdNomApe, T001U7_A591LegNomApe, T001U7_A25AgeOrden, T001U7_A1254AgeLiqNro, T001U7_n1254AgeLiqNro, T001U7_A2EmpNom, T001U7_A230LegApellido, T001U7_A251LegNombre,
            T001U7_A244LegFecEgreso, T001U7_n244LegFecEgreso, T001U7_A41ConDescrip, T001U7_A110AgeCanti, T001U7_n110AgeCanti, T001U7_A115AgeVUnit, T001U7_n115AgeVUnit, T001U7_A113AgeImporte, T001U7_n113AgeImporte, T001U7_A111AgeFecDes,
            T001U7_n111AgeFecDes, T001U7_A112AgeFecHas, T001U7_n112AgeFecHas, T001U7_A93LegId, T001U7_n93LegId, T001U7_A239LegCUIL, T001U7_A2159AgePerDescrip, T001U7_A3CliCod, T001U7_A1EmpCod, T001U7_A6LegNumero,
            T001U7_A26ConCodigo
            }
            , new Object[] {
            T001U8_A42ConCodYDesc, T001U8_n42ConCodYDesc, T001U8_A41ConDescrip
            }
            , new Object[] {
            T001U9_A2EmpNom
            }
            , new Object[] {
            T001U10_A250LegIdNomApe, T001U10_A591LegNomApe, T001U10_A230LegApellido, T001U10_A251LegNombre, T001U10_A244LegFecEgreso, T001U10_n244LegFecEgreso, T001U10_A93LegId, T001U10_n93LegId, T001U10_A239LegCUIL
            }
            , new Object[] {
            T001U11_A3CliCod, T001U11_A1EmpCod, T001U11_A6LegNumero, T001U11_A25AgeOrden
            }
            , new Object[] {
            T001U12_A25AgeOrden, T001U12_A3CliCod, T001U12_A1EmpCod, T001U12_A6LegNumero
            }
            , new Object[] {
            T001U13_A25AgeOrden, T001U13_A3CliCod, T001U13_A1EmpCod, T001U13_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001U17_A2EmpNom
            }
            , new Object[] {
            T001U18_A250LegIdNomApe, T001U18_A591LegNomApe, T001U18_A230LegApellido, T001U18_A251LegNombre, T001U18_A244LegFecEgreso, T001U18_n244LegFecEgreso, T001U18_A93LegId, T001U18_n93LegId, T001U18_A239LegCUIL
            }
            , new Object[] {
            T001U19_A42ConCodYDesc, T001U19_n42ConCodYDesc, T001U19_A41ConDescrip
            }
            , new Object[] {
            T001U20_A3CliCod, T001U20_A1EmpCod, T001U20_A6LegNumero, T001U20_A25AgeOrden
            }
         }
      );
      AV32Pgmname = "Novedades" ;
      Z112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      i112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      A112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      Z111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      i111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      Z110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      i110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      A110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      Z111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      i111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7EmpCod ;
   private short wcpOAV9AgeOrden ;
   private short Z1EmpCod ;
   private short Z25AgeOrden ;
   private short AV7EmpCod ;
   private short A25AgeOrden ;
   private short A1EmpCod ;
   private short AV9AgeOrden ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound3 ;
   private short nIsDirty_3 ;
   private short GXt_int14 ;
   private short GXv_int15[] ;
   private int wcpOAV21CliCod ;
   private int wcpOAV8LegNumero ;
   private int Z3CliCod ;
   private int Z6LegNumero ;
   private int Z1254AgeLiqNro ;
   private int N1254AgeLiqNro ;
   private int AV21CliCod ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV8LegNumero ;
   private int trnEnded ;
   private int edtLegNumero_Enabled ;
   private int edtConCodigo_Visible ;
   private int edtConCodigo_Enabled ;
   private int edtAgeCanti_Enabled ;
   private int edtAgeImporte_Enabled ;
   private int edtAgeFecDes_Enabled ;
   private int edtAgeFecHas_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboconcodigo_Visible ;
   private int edtavComboconcodigo_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtAgeVUnit_Enabled ;
   private int edtAgeVUnit_Visible ;
   private int A1254AgeLiqNro ;
   private int AV30Insert_AgeLiqNro ;
   private int Combo_concodigo_Datalistupdateminimumcharacters ;
   private int Combo_concodigo_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV33GXV1 ;
   private int GX_JID ;
   private int i1254AgeLiqNro ;
   private int idxLst ;
   private int GXt_int7 ;
   private int GXv_int8[] ;
   private long A239LegCUIL ;
   private long Z239LegCUIL ;
   private java.math.BigDecimal Z110AgeCanti ;
   private java.math.BigDecimal Z115AgeVUnit ;
   private java.math.BigDecimal Z113AgeImporte ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal A113AgeImporte ;
   private java.math.BigDecimal A115AgeVUnit ;
   private java.math.BigDecimal i110AgeCanti ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z26ConCodigo ;
   private String N26ConCodigo ;
   private String Combo_concodigo_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A26ConCodigo ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLegNumero_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtLegNumero_Jsonclick ;
   private String divTablesplittedconcodigo_Internalname ;
   private String lblTextblockconcodigo_Internalname ;
   private String lblTextblockconcodigo_Jsonclick ;
   private String Combo_concodigo_Caption ;
   private String Combo_concodigo_Cls ;
   private String Combo_concodigo_Internalname ;
   private String edtConCodigo_Internalname ;
   private String edtConCodigo_Jsonclick ;
   private String edtAgeCanti_Internalname ;
   private String edtAgeCanti_Jsonclick ;
   private String divTablesplittedageimporte_Internalname ;
   private String lblTextblockageimporte_Internalname ;
   private String lblTextblockageimporte_Jsonclick ;
   private String tblTablemergedageimporte_Internalname ;
   private String edtAgeImporte_Internalname ;
   private String edtAgeImporte_Jsonclick ;
   private String lblAgeimporte_righttext_Internalname ;
   private String lblAgeimporte_righttext_Jsonclick ;
   private String edtAgeFecDes_Internalname ;
   private String edtAgeFecDes_Jsonclick ;
   private String edtAgeFecHas_Internalname ;
   private String edtAgeFecHas_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_concodigo_Internalname ;
   private String edtavComboconcodigo_Internalname ;
   private String AV20ComboConCodigo ;
   private String edtavComboconcodigo_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtAgeVUnit_Internalname ;
   private String edtAgeVUnit_Jsonclick ;
   private String A1133AgePrevCalc ;
   private String AV13Insert_ConCodigo ;
   private String A93LegId ;
   private String AV32Pgmname ;
   private String Combo_concodigo_Objectcall ;
   private String Combo_concodigo_Class ;
   private String Combo_concodigo_Icontype ;
   private String Combo_concodigo_Icon ;
   private String Combo_concodigo_Tooltip ;
   private String Combo_concodigo_Selectedvalue_set ;
   private String Combo_concodigo_Selectedtext_set ;
   private String Combo_concodigo_Selectedtext_get ;
   private String Combo_concodigo_Gamoauthtoken ;
   private String Combo_concodigo_Ddointernalname ;
   private String Combo_concodigo_Titlecontrolalign ;
   private String Combo_concodigo_Dropdownoptionstype ;
   private String Combo_concodigo_Titlecontrolidtoreplace ;
   private String Combo_concodigo_Datalisttype ;
   private String Combo_concodigo_Datalistfixedvalues ;
   private String Combo_concodigo_Datalistproc ;
   private String Combo_concodigo_Datalistprocparametersprefix ;
   private String Combo_concodigo_Remoteservicesparameters ;
   private String Combo_concodigo_Htmltemplate ;
   private String Combo_concodigo_Multiplevaluestype ;
   private String Combo_concodigo_Loadingdata ;
   private String Combo_concodigo_Noresultsfound ;
   private String Combo_concodigo_Emptyitemtext ;
   private String Combo_concodigo_Onlyselectedvalues ;
   private String Combo_concodigo_Selectalltext ;
   private String Combo_concodigo_Multiplevaluesseparator ;
   private String Combo_concodigo_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode3 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV26cantidadAgenda ;
   private String AV27importeAgenda ;
   private String Z93LegId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXt_char9 ;
   private String GXv_char12[] ;
   private String GXv_char4[] ;
   private String Z1133AgePrevCalc ;
   private java.util.Date Z111AgeFecDes ;
   private java.util.Date Z112AgeFecHas ;
   private java.util.Date A112AgeFecHas ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date Z244LegFecEgreso ;
   private java.util.Date i111AgeFecDes ;
   private java.util.Date i112AgeFecHas ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n112AgeFecHas ;
   private boolean n111AgeFecDes ;
   private boolean n110AgeCanti ;
   private boolean n113AgeImporte ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_concodigo_Emptyitem ;
   private boolean n1254AgeLiqNro ;
   private boolean n115AgeVUnit ;
   private boolean A114AgeLegActivo ;
   private boolean AV29existe ;
   private boolean n244LegFecEgreso ;
   private boolean n93LegId ;
   private boolean n42ConCodYDesc ;
   private boolean Combo_concodigo_Enabled ;
   private boolean Combo_concodigo_Visible ;
   private boolean Combo_concodigo_Allowmultipleselection ;
   private boolean Combo_concodigo_Isgriditem ;
   private boolean Combo_concodigo_Hasdescription ;
   private boolean Combo_concodigo_Includeonlyselectedoption ;
   private boolean Combo_concodigo_Includeselectalloption ;
   private boolean Combo_concodigo_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV22IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean Gx_longc ;
   private boolean i114AgeLegActivo ;
   private boolean GXv_boolean3[] ;
   private boolean ZV29existe ;
   private String A1132AgePrevis ;
   private String Z1132AgePrevis ;
   private String Z2159AgePerDescrip ;
   private String A2159AgePerDescrip ;
   private String A2EmpNom ;
   private String A250LegIdNomApe ;
   private String A591LegNomApe ;
   private String A230LegApellido ;
   private String A251LegNombre ;
   private String A42ConCodYDesc ;
   private String A41ConDescrip ;
   private String AV17ComboSelectedValue ;
   private String Z2EmpNom ;
   private String Z250LegIdNomApe ;
   private String Z591LegNomApe ;
   private String Z230LegApellido ;
   private String Z251LegNombre ;
   private String Z42ConCodYDesc ;
   private String Z41ConDescrip ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_concodigo ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T001U4_A2EmpNom ;
   private String[] T001U5_A250LegIdNomApe ;
   private String[] T001U5_A591LegNomApe ;
   private String[] T001U5_A230LegApellido ;
   private String[] T001U5_A251LegNombre ;
   private java.util.Date[] T001U5_A244LegFecEgreso ;
   private boolean[] T001U5_n244LegFecEgreso ;
   private String[] T001U5_A93LegId ;
   private boolean[] T001U5_n93LegId ;
   private long[] T001U5_A239LegCUIL ;
   private String[] T001U6_A42ConCodYDesc ;
   private boolean[] T001U6_n42ConCodYDesc ;
   private String[] T001U6_A41ConDescrip ;
   private String[] T001U7_A42ConCodYDesc ;
   private boolean[] T001U7_n42ConCodYDesc ;
   private String[] T001U7_A250LegIdNomApe ;
   private String[] T001U7_A591LegNomApe ;
   private short[] T001U7_A25AgeOrden ;
   private int[] T001U7_A1254AgeLiqNro ;
   private boolean[] T001U7_n1254AgeLiqNro ;
   private String[] T001U7_A2EmpNom ;
   private String[] T001U7_A230LegApellido ;
   private String[] T001U7_A251LegNombre ;
   private java.util.Date[] T001U7_A244LegFecEgreso ;
   private boolean[] T001U7_n244LegFecEgreso ;
   private String[] T001U7_A41ConDescrip ;
   private java.math.BigDecimal[] T001U7_A110AgeCanti ;
   private boolean[] T001U7_n110AgeCanti ;
   private java.math.BigDecimal[] T001U7_A115AgeVUnit ;
   private boolean[] T001U7_n115AgeVUnit ;
   private java.math.BigDecimal[] T001U7_A113AgeImporte ;
   private boolean[] T001U7_n113AgeImporte ;
   private java.util.Date[] T001U7_A111AgeFecDes ;
   private boolean[] T001U7_n111AgeFecDes ;
   private java.util.Date[] T001U7_A112AgeFecHas ;
   private boolean[] T001U7_n112AgeFecHas ;
   private String[] T001U7_A93LegId ;
   private boolean[] T001U7_n93LegId ;
   private long[] T001U7_A239LegCUIL ;
   private String[] T001U7_A2159AgePerDescrip ;
   private int[] T001U7_A3CliCod ;
   private short[] T001U7_A1EmpCod ;
   private int[] T001U7_A6LegNumero ;
   private String[] T001U7_A26ConCodigo ;
   private String[] T001U8_A42ConCodYDesc ;
   private boolean[] T001U8_n42ConCodYDesc ;
   private String[] T001U8_A41ConDescrip ;
   private String[] T001U9_A2EmpNom ;
   private String[] T001U10_A250LegIdNomApe ;
   private String[] T001U10_A591LegNomApe ;
   private String[] T001U10_A230LegApellido ;
   private String[] T001U10_A251LegNombre ;
   private java.util.Date[] T001U10_A244LegFecEgreso ;
   private boolean[] T001U10_n244LegFecEgreso ;
   private String[] T001U10_A93LegId ;
   private boolean[] T001U10_n93LegId ;
   private long[] T001U10_A239LegCUIL ;
   private int[] T001U11_A3CliCod ;
   private short[] T001U11_A1EmpCod ;
   private int[] T001U11_A6LegNumero ;
   private short[] T001U11_A25AgeOrden ;
   private short[] T001U3_A25AgeOrden ;
   private int[] T001U3_A1254AgeLiqNro ;
   private boolean[] T001U3_n1254AgeLiqNro ;
   private java.math.BigDecimal[] T001U3_A110AgeCanti ;
   private boolean[] T001U3_n110AgeCanti ;
   private java.math.BigDecimal[] T001U3_A115AgeVUnit ;
   private boolean[] T001U3_n115AgeVUnit ;
   private java.math.BigDecimal[] T001U3_A113AgeImporte ;
   private boolean[] T001U3_n113AgeImporte ;
   private java.util.Date[] T001U3_A111AgeFecDes ;
   private boolean[] T001U3_n111AgeFecDes ;
   private java.util.Date[] T001U3_A112AgeFecHas ;
   private boolean[] T001U3_n112AgeFecHas ;
   private String[] T001U3_A2159AgePerDescrip ;
   private int[] T001U3_A3CliCod ;
   private short[] T001U3_A1EmpCod ;
   private int[] T001U3_A6LegNumero ;
   private String[] T001U3_A26ConCodigo ;
   private short[] T001U12_A25AgeOrden ;
   private int[] T001U12_A3CliCod ;
   private short[] T001U12_A1EmpCod ;
   private int[] T001U12_A6LegNumero ;
   private short[] T001U13_A25AgeOrden ;
   private int[] T001U13_A3CliCod ;
   private short[] T001U13_A1EmpCod ;
   private int[] T001U13_A6LegNumero ;
   private short[] T001U2_A25AgeOrden ;
   private int[] T001U2_A1254AgeLiqNro ;
   private boolean[] T001U2_n1254AgeLiqNro ;
   private java.math.BigDecimal[] T001U2_A110AgeCanti ;
   private boolean[] T001U2_n110AgeCanti ;
   private java.math.BigDecimal[] T001U2_A115AgeVUnit ;
   private boolean[] T001U2_n115AgeVUnit ;
   private java.math.BigDecimal[] T001U2_A113AgeImporte ;
   private boolean[] T001U2_n113AgeImporte ;
   private java.util.Date[] T001U2_A111AgeFecDes ;
   private boolean[] T001U2_n111AgeFecDes ;
   private java.util.Date[] T001U2_A112AgeFecHas ;
   private boolean[] T001U2_n112AgeFecHas ;
   private String[] T001U2_A2159AgePerDescrip ;
   private int[] T001U2_A3CliCod ;
   private short[] T001U2_A1EmpCod ;
   private int[] T001U2_A6LegNumero ;
   private String[] T001U2_A26ConCodigo ;
   private String[] T001U17_A2EmpNom ;
   private String[] T001U18_A250LegIdNomApe ;
   private String[] T001U18_A591LegNomApe ;
   private String[] T001U18_A230LegApellido ;
   private String[] T001U18_A251LegNombre ;
   private java.util.Date[] T001U18_A244LegFecEgreso ;
   private boolean[] T001U18_n244LegFecEgreso ;
   private String[] T001U18_A93LegId ;
   private boolean[] T001U18_n93LegId ;
   private long[] T001U18_A239LegCUIL ;
   private String[] T001U19_A42ConCodYDesc ;
   private boolean[] T001U19_n42ConCodYDesc ;
   private String[] T001U19_A41ConDescrip ;
   private int[] T001U20_A3CliCod ;
   private short[] T001U20_A1EmpCod ;
   private int[] T001U20_A6LegNumero ;
   private short[] T001U20_A25AgeOrden ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15ConCodigo_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXt_objcol_SdtDVB_SDTComboData_Item5 ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> GXv_objcol_SdtDVB_SDTComboData_Item6[] ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class novedades__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001U2", "SELECT AgeOrden, AgeLiqNro, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgePerDescrip, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?  FOR UPDATE OF AgendaNovedades NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U3", "SELECT AgeOrden, AgeLiqNro, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgePerDescrip, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U4", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U5", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId, LegCUIL FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U6", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U7", "SELECT T4.ConCodYDesc, T3.LegIdNomApe, T3.LegNomApe, TM1.AgeOrden, TM1.AgeLiqNro, T2.EmpNom, T3.LegApellido, T3.LegNombre, T3.LegFecEgreso, T4.ConDescrip, TM1.AgeCanti, TM1.AgeVUnit, TM1.AgeImporte, TM1.AgeFecDes, TM1.AgeFecHas, T3.LegId, T3.LegCUIL, TM1.AgePerDescrip, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.ConCodigo FROM (((AgendaNovedades TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod AND T3.LegNumero = TM1.LegNumero) INNER JOIN Concepto T4 ON T4.CliCod = TM1.CliCod AND T4.ConCodigo = TM1.ConCodigo) WHERE TM1.AgeOrden = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.AgeOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U8", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U9", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U10", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId, LegCUIL FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U11", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U12", "SELECT AgeOrden, CliCod, EmpCod, LegNumero FROM AgendaNovedades WHERE ( AgeOrden > ? or AgeOrden = ? and CliCod > ? or CliCod = ? and AgeOrden = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and AgeOrden = ? and LegNumero > ?) ORDER BY CliCod, EmpCod, LegNumero, AgeOrden  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001U13", "SELECT AgeOrden, CliCod, EmpCod, LegNumero FROM AgendaNovedades WHERE ( AgeOrden < ? or AgeOrden = ? and CliCod < ? or CliCod = ? and AgeOrden = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and AgeOrden = ? and LegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, LegNumero DESC, AgeOrden DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001U14", "SAVEPOINT gxupdate;INSERT INTO AgendaNovedades(AgeOrden, AgeLiqNro, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgePerDescrip, CliCod, EmpCod, LegNumero, ConCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001U15", "SAVEPOINT gxupdate;UPDATE AgendaNovedades SET AgeLiqNro=?, AgeCanti=?, AgeVUnit=?, AgeImporte=?, AgeFecDes=?, AgeFecHas=?, AgePerDescrip=?, ConCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001U16", "SAVEPOINT gxupdate;DELETE FROM AgendaNovedades  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001U17", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U18", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId, LegCUIL FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U19", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001U20", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades ORDER BY CliCod, EmpCod, LegNumero, AgeOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(8);
               ((int[]) buf[14])[0] = rslt.getInt(9);
               ((short[]) buf[15])[0] = rslt.getShort(10);
               ((int[]) buf[16])[0] = rslt.getInt(11);
               ((String[]) buf[17])[0] = rslt.getString(12, 10);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(8);
               ((int[]) buf[14])[0] = rslt.getInt(9);
               ((short[]) buf[15])[0] = rslt.getShort(10);
               ((int[]) buf[16])[0] = rslt.getInt(11);
               ((String[]) buf[17])[0] = rslt.getString(12, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((long[]) buf[8])[0] = rslt.getLong(7);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(9);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(13,2);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[21])[0] = rslt.getGXDate(15);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((long[]) buf[25])[0] = rslt.getLong(17);
               ((String[]) buf[26])[0] = rslt.getVarchar(18);
               ((int[]) buf[27])[0] = rslt.getInt(19);
               ((short[]) buf[28])[0] = rslt.getShort(20);
               ((int[]) buf[29])[0] = rslt.getInt(21);
               ((String[]) buf[30])[0] = rslt.getString(22, 10);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((long[]) buf[8])[0] = rslt.getLong(7);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((long[]) buf[8])[0] = rslt.getLong(7);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[2]).intValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(3, (java.math.BigDecimal)parms[4], 2);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(4, (java.math.BigDecimal)parms[6], 2);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(5, (java.math.BigDecimal)parms[8], 2);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DATE );
               }
               else
               {
                  stmt.setDate(6, (java.util.Date)parms[10]);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.DATE );
               }
               else
               {
                  stmt.setDate(7, (java.util.Date)parms[12]);
               }
               stmt.setVarchar(8, (String)parms[13], 400, false);
               stmt.setInt(9, ((Number) parms[14]).intValue());
               stmt.setShort(10, ((Number) parms[15]).shortValue());
               stmt.setInt(11, ((Number) parms[16]).intValue());
               stmt.setString(12, (String)parms[17], 10);
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(2, (java.math.BigDecimal)parms[3], 2);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(3, (java.math.BigDecimal)parms[5], 2);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(4, (java.math.BigDecimal)parms[7], 2);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DATE );
               }
               else
               {
                  stmt.setDate(5, (java.util.Date)parms[9]);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DATE );
               }
               else
               {
                  stmt.setDate(6, (java.util.Date)parms[11]);
               }
               stmt.setVarchar(7, (String)parms[12], 400, false);
               stmt.setString(8, (String)parms[13], 10);
               stmt.setInt(9, ((Number) parms[14]).intValue());
               stmt.setShort(10, ((Number) parms[15]).shortValue());
               stmt.setInt(11, ((Number) parms[16]).intValue());
               stmt.setShort(12, ((Number) parms[17]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

