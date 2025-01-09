package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class categoriaalta2_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action16") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
         A1894CatRelSec = (short)(GXutil.lval( httpContext.GetPar( "CatRelSec"))) ;
         n1894CatRelSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1894CatRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1894CatRelSec), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_16_2T205( Gx_mode, AV9CliCod, A1894CatRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action21") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
         A1891CatSalRelSec = (int)(GXutil.lval( httpContext.GetPar( "CatSalRelSec"))) ;
         n1891CatSalRelSec = false ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_21_2T206( Gx_mode, AV9CliCod, A1891CatSalRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CATRELSEC") == 0 )
      {
         AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlacatrelsec2T205( AV9CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CATSALRELSEC") == 0 )
      {
         AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlacatsalrelsec2T206( AV9CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CATPROVRELSEC") == 0 )
      {
         AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlacatprovrelsec2T274( AV9CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLIPAICONVE") == 0 )
      {
         AV30CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliPaiConve), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliPaiConve), "ZZZ9")));
         AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asaclipaiconve2T205( AV30CliPaiConve, AV9CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"CLICONVENIO") == 0 )
      {
         AV31CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31CliConvenio", AV31CliConvenio);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31CliConvenio, ""))));
         AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
         AV11EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asacliconvenio2T205( AV31CliConvenio, AV9CliCod, AV11EmpCod, Gx_BScreen) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_29") == 0 )
      {
         A2200CatPaiCod = (short)(GXutil.lval( httpContext.GetPar( "CatPaiCod"))) ;
         A2201CatProvCod = (short)(GXutil.lval( httpContext.GetPar( "CatProvCod"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_29( A2200CatPaiCod, A2201CatProvCod) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_valores") == 0 )
      {
         gxnrgridlevel_valores_newrow_invoke( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_provincias") == 0 )
      {
         gxnrgridlevel_provincias_newrow_invoke( ) ;
         return  ;
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
            AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
            AV30CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliPaiConve), "ZZZ9")));
            AV31CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31CliConvenio", AV31CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31CliConvenio, ""))));
            AV7CatCodigo = httpContext.GetPar( "CatCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CatCodigo", AV7CatCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7CatCodigo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Categoria Alta", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_valores_newrow_invoke( )
   {
      nRC_GXsfl_41 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_41"))) ;
      nGXsfl_41_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_41_idx"))) ;
      sGXsfl_41_idx = httpContext.GetPar( "sGXsfl_41_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_valores_newrow( ) ;
      /* End function gxnrGridlevel_valores_newrow_invoke */
   }

   public void gxnrgridlevel_provincias_newrow_invoke( )
   {
      nRC_GXsfl_51 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_51"))) ;
      nGXsfl_51_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_51_idx"))) ;
      sGXsfl_51_idx = httpContext.GetPar( "sGXsfl_51_idx") ;
      edtCatProvCod_Horizontalalignment = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Horizontalalignment", edtCatProvCod_Horizontalalignment, !bGXsfl_51_Refreshing);
      edtCatPaiCod_Horizontalalignment = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Horizontalalignment", edtCatPaiCod_Horizontalalignment, !bGXsfl_51_Refreshing);
      Gx_mode = httpContext.GetPar( "Mode") ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV9CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_provincias_newrow( ) ;
      /* End function gxnrGridlevel_provincias_newrow_invoke */
   }

   public categoriaalta2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public categoriaalta2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categoriaalta2_impl.class ));
   }

   public categoriaalta2_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynCatRelSec = new HTMLChoice();
      dynCatSalRelSec = new HTMLChoice();
      dynCatProvRelSec = new HTMLChoice();
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
      if ( dynCatRelSec.getItemCount() > 0 )
      {
         A1894CatRelSec = (short)(GXutil.lval( dynCatRelSec.getValidValue(GXutil.trim( GXutil.str( A1894CatRelSec, 4, 0))))) ;
         n1894CatRelSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1894CatRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1894CatRelSec), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCatRelSec.setValue( GXutil.trim( GXutil.str( A1894CatRelSec, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynCatRelSec.getInternalname(), "Values", dynCatRelSec.ToJavascriptSource(), true);
      }
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatCodigo_Internalname, httpContext.getMessage( "Categoria", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCatCodigo_Internalname, GXutil.rtrim( A8CatCodigo), GXutil.rtrim( localUtil.format( A8CatCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCatCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCatCodigo_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CategoriaAlta2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatDescrip_Internalname, httpContext.getMessage( "Categoría", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCatDescrip_Internalname, A123CatDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtCatDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_CategoriaAlta2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divCatrelsec_cell_Internalname, 1, 0, "px", 0, "px", divCatrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynCatRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCatRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCatRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCatRelSec, dynCatRelSec.getInternalname(), GXutil.trim( GXutil.str( A1894CatRelSec, 4, 0)), 1, dynCatRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynCatRelSec.getVisible(), dynCatRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_CategoriaAlta2.htm");
      dynCatRelSec.setValue( GXutil.trim( GXutil.str( A1894CatRelSec, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatRelSec.getInternalname(), "Values", dynCatRelSec.ToJavascriptSource(), true);
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
      httpContext.writeText( "<td class='CellMarginTop'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_valores_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol41( ) ;
      nGXsfl_41_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount206 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_206 = (short)(1) ;
            scanStart2T206( ) ;
            while ( RcdFound206 != 0 )
            {
               init_level_properties206( ) ;
               getByPrimaryKey2T206( ) ;
               addRow2T206( ) ;
               scanNext2T206( ) ;
            }
            scanEnd2T206( ) ;
            nBlankRcdCount206 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B123CatDescrip = A123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         standaloneNotModal2T206( ) ;
         standaloneModal2T206( ) ;
         sMode206 = Gx_mode ;
         while ( nGXsfl_41_idx < nRC_GXsfl_41 )
         {
            bGXsfl_41_Refreshing = true ;
            readRow2T206( ) ;
            edtCatVigencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATVIGENCIA_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtEscBasico_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCBASICO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEscBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscBasico_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            edtEscAdicional_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCADICIONAL_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEscAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscAdicional_Enabled), 5, 0), !bGXsfl_41_Refreshing);
            dynCatSalRelSec.setVisible( (int)(localUtil.ctol( httpContext.cgiGet( "CATSALRELSEC_"+sGXsfl_41_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatSalRelSec.getVisible(), 5, 0), !bGXsfl_41_Refreshing);
            dynCatSalRelSec.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CATSALRELSEC_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatSalRelSec.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
            if ( ( nRcdExists_206 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal2T206( ) ;
            }
            sendRow2T206( ) ;
            bGXsfl_41_Refreshing = false ;
         }
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A123CatDescrip = B123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount206 = (short)(5) ;
         nRcdExists_206 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart2T206( ) ;
            while ( RcdFound206 != 0 )
            {
               sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_41206( ) ;
               init_level_properties206( ) ;
               standaloneNotModal2T206( ) ;
               getByPrimaryKey2T206( ) ;
               standaloneModal2T206( ) ;
               addRow2T206( ) ;
               scanNext2T206( ) ;
            }
            scanEnd2T206( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode206 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_41206( ) ;
         initAll2T206( ) ;
         init_level_properties206( ) ;
         B123CatDescrip = A123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         nRcdExists_206 = (short)(0) ;
         nIsMod_206 = (short)(0) ;
         nRcdDeleted_206 = (short)(0) ;
         nBlankRcdCount206 = (short)(nBlankRcdUsr206+nBlankRcdCount206) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount206 > 0 )
         {
            standaloneNotModal2T206( ) ;
            standaloneModal2T206( ) ;
            addRow2T206( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtCatVigencia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount206 = (short)(nBlankRcdCount206-1) ;
         }
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A123CatDescrip = B123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_valoresContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_valores", Gridlevel_valoresContainer, subGridlevel_valores_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData", Gridlevel_valoresContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData"+"V", Gridlevel_valoresContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_valoresContainerData"+"V"+"\" value='"+Gridlevel_valoresContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='CellMarginTop'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_provincias_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol51( ) ;
      nGXsfl_51_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount274 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_274 = (short)(1) ;
            scanStart2T274( ) ;
            while ( RcdFound274 != 0 )
            {
               init_level_properties274( ) ;
               getByPrimaryKey2T274( ) ;
               addRow2T274( ) ;
               scanNext2T274( ) ;
            }
            scanEnd2T274( ) ;
            nBlankRcdCount274 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B123CatDescrip = A123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         standaloneNotModal2T274( ) ;
         standaloneModal2T274( ) ;
         sMode274 = Gx_mode ;
         while ( nGXsfl_51_idx < nRC_GXsfl_51 )
         {
            bGXsfl_51_Refreshing = true ;
            readRow2T274( ) ;
            edtCatPaiCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATPAICOD_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
            edtCatPaiCod_Horizontalalignment = httpContext.cgiGet( "CATPAICOD_"+sGXsfl_51_idx+"Horizontalalignment") ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Horizontalalignment", edtCatPaiCod_Horizontalalignment, !bGXsfl_51_Refreshing);
            edtCatProvCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVCOD_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
            edtCatProvCod_Horizontalalignment = httpContext.cgiGet( "CATPROVCOD_"+sGXsfl_51_idx+"Horizontalalignment") ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Horizontalalignment", edtCatProvCod_Horizontalalignment, !bGXsfl_51_Refreshing);
            dynCatProvRelSec.setVisible( (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVRELSEC_"+sGXsfl_51_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynCatProvRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatProvRelSec.getVisible(), 5, 0), !bGXsfl_51_Refreshing);
            dynCatProvRelSec.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVRELSEC_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynCatProvRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatProvRelSec.getEnabled(), 5, 0), !bGXsfl_51_Refreshing);
            if ( ( nRcdExists_274 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal2T274( ) ;
            }
            sendRow2T274( ) ;
            bGXsfl_51_Refreshing = false ;
         }
         Gx_mode = sMode274 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A123CatDescrip = B123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount274 = (short)(5) ;
         nRcdExists_274 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart2T274( ) ;
            while ( RcdFound274 != 0 )
            {
               sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_51274( ) ;
               init_level_properties274( ) ;
               standaloneNotModal2T274( ) ;
               getByPrimaryKey2T274( ) ;
               standaloneModal2T274( ) ;
               addRow2T274( ) ;
               scanNext2T274( ) ;
            }
            scanEnd2T274( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode274 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_51274( ) ;
         initAll2T274( ) ;
         init_level_properties274( ) ;
         B123CatDescrip = A123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         nRcdExists_274 = (short)(0) ;
         nIsMod_274 = (short)(0) ;
         nRcdDeleted_274 = (short)(0) ;
         nBlankRcdCount274 = (short)(nBlankRcdUsr274+nBlankRcdCount274) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount274 > 0 )
         {
            standaloneNotModal2T274( ) ;
            standaloneModal2T274( ) ;
            addRow2T274( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtCatPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount274 = (short)(nBlankRcdCount274-1) ;
         }
         Gx_mode = sMode274 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A123CatDescrip = B123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_provinciasContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_provincias", Gridlevel_provinciasContainer, subGridlevel_provincias_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_provinciasContainerData", Gridlevel_provinciasContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_provinciasContainerData"+"V", Gridlevel_provinciasContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_provinciasContainerData"+"V"+"\" value='"+Gridlevel_provinciasContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CategoriaAlta2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CategoriaAlta2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CategoriaAlta2.htm");
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
      /* User Defined Control */
      ucCombo_catpaicod.setProperty("Caption", Combo_catpaicod_Caption);
      ucCombo_catpaicod.setProperty("Cls", Combo_catpaicod_Cls);
      ucCombo_catpaicod.setProperty("IsGridItem", Combo_catpaicod_Isgriditem);
      ucCombo_catpaicod.setProperty("HasDescription", Combo_catpaicod_Hasdescription);
      ucCombo_catpaicod.setProperty("DataListProc", Combo_catpaicod_Datalistproc);
      ucCombo_catpaicod.setProperty("DataListProcParametersPrefix", Combo_catpaicod_Datalistprocparametersprefix);
      ucCombo_catpaicod.setProperty("EmptyItem", Combo_catpaicod_Emptyitem);
      ucCombo_catpaicod.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
      ucCombo_catpaicod.setProperty("DropDownOptionsData", AV34CatPaiCod_Data);
      ucCombo_catpaicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_catpaicod_Internalname, "COMBO_CATPAICODContainer");
      /* User Defined Control */
      ucCombo_catprovcod.setProperty("Caption", Combo_catprovcod_Caption);
      ucCombo_catprovcod.setProperty("Cls", Combo_catprovcod_Cls);
      ucCombo_catprovcod.setProperty("IsGridItem", Combo_catprovcod_Isgriditem);
      ucCombo_catprovcod.setProperty("HasDescription", Combo_catprovcod_Hasdescription);
      ucCombo_catprovcod.setProperty("DataListProc", Combo_catprovcod_Datalistproc);
      ucCombo_catprovcod.setProperty("EmptyItem", Combo_catprovcod_Emptyitem);
      ucCombo_catprovcod.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
      ucCombo_catprovcod.setProperty("DropDownOptionsData", AV35CatProvCod_Data);
      ucCombo_catprovcod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_catprovcod_Internalname, "COMBO_CATPROVCODContainer");
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
      e112T2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV21DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCATPAICOD_DATA"), AV34CatPaiCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCATPROVCOD_DATA"), AV35CatProvCod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z8CatCodigo = httpContext.cgiGet( "Z8CatCodigo") ;
            Z123CatDescrip = httpContext.cgiGet( "Z123CatDescrip") ;
            Z676CatDescripSinAc = httpContext.cgiGet( "Z676CatDescripSinAc") ;
            Z1894CatRelSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1894CatRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1894CatRelSec = ((0==A1894CatRelSec) ? true : false) ;
            A676CatDescripSinAc = httpContext.cgiGet( "Z676CatDescripSinAc") ;
            O123CatDescrip = httpContext.cgiGet( "O123CatDescrip") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_41 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_41"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            nRC_GXsfl_51 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_51"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV30CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "CLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV31CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV11EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1565CliConvenio = httpContext.cgiGet( "CLICONVENIO") ;
            AV7CatCodigo = httpContext.cgiGet( "vCATCODIGO") ;
            AV37Essistemaconceptosdefault = GXutil.strtobool( httpContext.cgiGet( "vESSISTEMACONCEPTOSDEFAULT")) ;
            AV33ClienteConveniador = GXutil.strtobool( httpContext.cgiGet( "vCLIENTECONVENIADOR")) ;
            AV32aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A676CatDescripSinAc = httpContext.cgiGet( "CATDESCRIPSINAC") ;
            AV39Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A122CatBasico = localUtil.ctond( httpContext.cgiGet( "CATBASICO")) ;
            n122CatBasico = false ;
            n122CatBasico = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A122CatBasico)==0) ? true : false) ;
            A731CatValorHora = localUtil.ctond( httpContext.cgiGet( "CATVALORHORA")) ;
            n731CatValorHora = false ;
            n731CatValorHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A731CatValorHora)==0) ? true : false) ;
            A908CatAdicional = localUtil.ctond( httpContext.cgiGet( "CATADICIONAL")) ;
            n908CatAdicional = false ;
            n908CatAdicional = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A908CatAdicional)==0) ? true : false) ;
            A909CatAdiHora = localUtil.ctond( httpContext.cgiGet( "CATADIHORA")) ;
            n909CatAdiHora = false ;
            n909CatAdiHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A909CatAdiHora)==0) ? true : false) ;
            A2203CatProvRelRef = httpContext.cgiGet( "CATPROVRELREF") ;
            n2203CatProvRelRef = false ;
            n2203CatProvRelRef = ((GXutil.strcmp("", A2203CatProvRelRef)==0) ? true : false) ;
            A2204CatProvOld = httpContext.cgiGet( "CATPROVOLD") ;
            n2204CatProvOld = false ;
            n2204CatProvOld = ((GXutil.strcmp("", A2204CatProvOld)==0) ? true : false) ;
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
            Combo_catpaicod_Objectcall = httpContext.cgiGet( "COMBO_CATPAICOD_Objectcall") ;
            Combo_catpaicod_Class = httpContext.cgiGet( "COMBO_CATPAICOD_Class") ;
            Combo_catpaicod_Icontype = httpContext.cgiGet( "COMBO_CATPAICOD_Icontype") ;
            Combo_catpaicod_Icon = httpContext.cgiGet( "COMBO_CATPAICOD_Icon") ;
            Combo_catpaicod_Caption = httpContext.cgiGet( "COMBO_CATPAICOD_Caption") ;
            Combo_catpaicod_Tooltip = httpContext.cgiGet( "COMBO_CATPAICOD_Tooltip") ;
            Combo_catpaicod_Cls = httpContext.cgiGet( "COMBO_CATPAICOD_Cls") ;
            Combo_catpaicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CATPAICOD_Selectedvalue_set") ;
            Combo_catpaicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CATPAICOD_Selectedvalue_get") ;
            Combo_catpaicod_Selectedtext_set = httpContext.cgiGet( "COMBO_CATPAICOD_Selectedtext_set") ;
            Combo_catpaicod_Selectedtext_get = httpContext.cgiGet( "COMBO_CATPAICOD_Selectedtext_get") ;
            Combo_catpaicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CATPAICOD_Gamoauthtoken") ;
            Combo_catpaicod_Ddointernalname = httpContext.cgiGet( "COMBO_CATPAICOD_Ddointernalname") ;
            Combo_catpaicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CATPAICOD_Titlecontrolalign") ;
            Combo_catpaicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CATPAICOD_Dropdownoptionstype") ;
            Combo_catpaicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Enabled")) ;
            Combo_catpaicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Visible")) ;
            Combo_catpaicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CATPAICOD_Titlecontrolidtoreplace") ;
            Combo_catpaicod_Datalisttype = httpContext.cgiGet( "COMBO_CATPAICOD_Datalisttype") ;
            Combo_catpaicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Allowmultipleselection")) ;
            Combo_catpaicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CATPAICOD_Datalistfixedvalues") ;
            Combo_catpaicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Isgriditem")) ;
            Combo_catpaicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Hasdescription")) ;
            Combo_catpaicod_Datalistproc = httpContext.cgiGet( "COMBO_CATPAICOD_Datalistproc") ;
            Combo_catpaicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CATPAICOD_Datalistprocparametersprefix") ;
            Combo_catpaicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CATPAICOD_Remoteservicesparameters") ;
            Combo_catpaicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CATPAICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_catpaicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Includeonlyselectedoption")) ;
            Combo_catpaicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Includeselectalloption")) ;
            Combo_catpaicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Emptyitem")) ;
            Combo_catpaicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Includeaddnewoption")) ;
            Combo_catpaicod_Htmltemplate = httpContext.cgiGet( "COMBO_CATPAICOD_Htmltemplate") ;
            Combo_catpaicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CATPAICOD_Multiplevaluestype") ;
            Combo_catpaicod_Loadingdata = httpContext.cgiGet( "COMBO_CATPAICOD_Loadingdata") ;
            Combo_catpaicod_Noresultsfound = httpContext.cgiGet( "COMBO_CATPAICOD_Noresultsfound") ;
            Combo_catpaicod_Emptyitemtext = httpContext.cgiGet( "COMBO_CATPAICOD_Emptyitemtext") ;
            Combo_catpaicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CATPAICOD_Onlyselectedvalues") ;
            Combo_catpaicod_Selectalltext = httpContext.cgiGet( "COMBO_CATPAICOD_Selectalltext") ;
            Combo_catpaicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CATPAICOD_Multiplevaluesseparator") ;
            Combo_catpaicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CATPAICOD_Addnewoptiontext") ;
            Combo_catpaicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CATPAICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_catprovcod_Objectcall = httpContext.cgiGet( "COMBO_CATPROVCOD_Objectcall") ;
            Combo_catprovcod_Class = httpContext.cgiGet( "COMBO_CATPROVCOD_Class") ;
            Combo_catprovcod_Icontype = httpContext.cgiGet( "COMBO_CATPROVCOD_Icontype") ;
            Combo_catprovcod_Icon = httpContext.cgiGet( "COMBO_CATPROVCOD_Icon") ;
            Combo_catprovcod_Caption = httpContext.cgiGet( "COMBO_CATPROVCOD_Caption") ;
            Combo_catprovcod_Tooltip = httpContext.cgiGet( "COMBO_CATPROVCOD_Tooltip") ;
            Combo_catprovcod_Cls = httpContext.cgiGet( "COMBO_CATPROVCOD_Cls") ;
            Combo_catprovcod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectedvalue_set") ;
            Combo_catprovcod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectedvalue_get") ;
            Combo_catprovcod_Selectedtext_set = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectedtext_set") ;
            Combo_catprovcod_Selectedtext_get = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectedtext_get") ;
            Combo_catprovcod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CATPROVCOD_Gamoauthtoken") ;
            Combo_catprovcod_Ddointernalname = httpContext.cgiGet( "COMBO_CATPROVCOD_Ddointernalname") ;
            Combo_catprovcod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CATPROVCOD_Titlecontrolalign") ;
            Combo_catprovcod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CATPROVCOD_Dropdownoptionstype") ;
            Combo_catprovcod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Enabled")) ;
            Combo_catprovcod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Visible")) ;
            Combo_catprovcod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CATPROVCOD_Titlecontrolidtoreplace") ;
            Combo_catprovcod_Datalisttype = httpContext.cgiGet( "COMBO_CATPROVCOD_Datalisttype") ;
            Combo_catprovcod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Allowmultipleselection")) ;
            Combo_catprovcod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CATPROVCOD_Datalistfixedvalues") ;
            Combo_catprovcod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Isgriditem")) ;
            Combo_catprovcod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Hasdescription")) ;
            Combo_catprovcod_Datalistproc = httpContext.cgiGet( "COMBO_CATPROVCOD_Datalistproc") ;
            Combo_catprovcod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CATPROVCOD_Datalistprocparametersprefix") ;
            Combo_catprovcod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CATPROVCOD_Remoteservicesparameters") ;
            Combo_catprovcod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CATPROVCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_catprovcod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Includeonlyselectedoption")) ;
            Combo_catprovcod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Includeselectalloption")) ;
            Combo_catprovcod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Emptyitem")) ;
            Combo_catprovcod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Includeaddnewoption")) ;
            Combo_catprovcod_Htmltemplate = httpContext.cgiGet( "COMBO_CATPROVCOD_Htmltemplate") ;
            Combo_catprovcod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CATPROVCOD_Multiplevaluestype") ;
            Combo_catprovcod_Loadingdata = httpContext.cgiGet( "COMBO_CATPROVCOD_Loadingdata") ;
            Combo_catprovcod_Noresultsfound = httpContext.cgiGet( "COMBO_CATPROVCOD_Noresultsfound") ;
            Combo_catprovcod_Emptyitemtext = httpContext.cgiGet( "COMBO_CATPROVCOD_Emptyitemtext") ;
            Combo_catprovcod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CATPROVCOD_Onlyselectedvalues") ;
            Combo_catprovcod_Selectalltext = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectalltext") ;
            Combo_catprovcod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CATPROVCOD_Multiplevaluesseparator") ;
            Combo_catprovcod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CATPROVCOD_Addnewoptiontext") ;
            Combo_catprovcod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CATPROVCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A8CatCodigo = httpContext.cgiGet( edtCatCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            A123CatDescrip = httpContext.cgiGet( edtCatDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
            dynCatRelSec.setName( dynCatRelSec.getInternalname() );
            dynCatRelSec.setValue( httpContext.cgiGet( dynCatRelSec.getInternalname()) );
            A1894CatRelSec = (short)(GXutil.lval( httpContext.cgiGet( dynCatRelSec.getInternalname()))) ;
            n1894CatRelSec = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1894CatRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1894CatRelSec), 4, 0));
            n1894CatRelSec = ((0==A1894CatRelSec) ? true : false) ;
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"CategoriaAlta2");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CatDescripSinAc", GXutil.rtrim( localUtil.format( A676CatDescripSinAc, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("categoriaalta2:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            /* Check if conditions changed and reset current page numbers */
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
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A8CatCodigo = httpContext.GetPar( "CatCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
               getEqualNoModal( ) ;
               if ( ! (GXutil.strcmp("", AV31CliConvenio)==0) )
               {
                  A1565CliConvenio = AV31CliConvenio ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               }
               else
               {
                  if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
                  {
                     GXt_char1 = A1565CliConvenio ;
                     GXv_char2[0] = GXt_char1 ;
                     new web.getconveniodefault(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, "", GXv_char2) ;
                     categoriaalta2_impl.this.GXt_char1 = GXv_char2[0] ;
                     A1565CliConvenio = GXt_char1 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
                  }
               }
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode205 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  if ( ! (GXutil.strcmp("", AV31CliConvenio)==0) )
                  {
                     A1565CliConvenio = AV31CliConvenio ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
                  }
                  else
                  {
                     if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
                     {
                        GXt_char1 = A1565CliConvenio ;
                        GXv_char2[0] = GXt_char1 ;
                        new web.getconveniodefault(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, "", GXv_char2) ;
                        categoriaalta2_impl.this.GXt_char1 = GXv_char2[0] ;
                        A1565CliConvenio = GXt_char1 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
                     }
                  }
                  Gx_mode = sMode205 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound205 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_2T0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CATCODIGO");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatCodigo_Internalname ;
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
                        e112T2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e122T2 ();
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e122T2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2T205( ) ;
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
         disableAttributes2T205( ) ;
      }
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

   public void confirm_2T0( )
   {
      beforeValidate2T205( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2T205( ) ;
         }
         else
         {
            checkExtendedTable2T205( ) ;
            closeExtendedTableCursors2T205( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode205 = Gx_mode ;
         confirm_2T206( ) ;
         if ( AnyError == 0 )
         {
            confirm_2T274( ) ;
            if ( AnyError == 0 )
            {
               /* Restore parent mode. */
               Gx_mode = sMode205 ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               IsConfirmed = (short)(1) ;
               httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_2T274( )
   {
      nGXsfl_51_idx = 0 ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         readRow2T274( ) ;
         if ( ( nRcdExists_274 != 0 ) || ( nIsMod_274 != 0 ) )
         {
            getKey2T274( ) ;
            if ( ( nRcdExists_274 == 0 ) && ( nRcdDeleted_274 == 0 ) )
            {
               if ( RcdFound274 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate2T274( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2T274( ) ;
                     closeExtendedTableCursors2T274( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CATPAICOD_" + sGXsfl_51_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCatPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound274 != 0 )
               {
                  if ( nRcdDeleted_274 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey2T274( ) ;
                     load2T274( ) ;
                     beforeValidate2T274( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2T274( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_274 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate2T274( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2T274( ) ;
                           closeExtendedTableCursors2T274( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_274 == 0 )
                  {
                     GXCCtl = "CATPAICOD_" + sGXsfl_51_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatPaiCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatProvCod_Internalname, GXutil.ltrim( localUtil.ntoc( A2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynCatProvRelSec.getInternalname(), GXutil.ltrim( localUtil.ntoc( A2202CatProvRelSec, (byte)(6), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2200CatPaiCod_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2201CatProvCod_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2202CatProvRelSec_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z2202CatProvRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2203CatProvRelRef_"+sGXsfl_51_idx, Z2203CatProvRelRef) ;
         httpContext.changePostValue( "T2200CatPaiCod_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( O2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T2201CatProvCod_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( O2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_274_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_274_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_274_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_274 != 0 )
         {
            httpContext.changePostValue( "CATPAICOD_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatPaiCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPAICOD_"+sGXsfl_51_idx+"Horizontalalignment", GXutil.rtrim( edtCatPaiCod_Horizontalalignment)) ;
            httpContext.changePostValue( "CATPROVCOD_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatProvCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPROVCOD_"+sGXsfl_51_idx+"Horizontalalignment", GXutil.rtrim( edtCatProvCod_Horizontalalignment)) ;
            httpContext.changePostValue( "CATPROVRELSEC_"+sGXsfl_51_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynCatProvRelSec.getVisible(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPROVRELSEC_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynCatProvRelSec.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_2T206( )
   {
      nGXsfl_41_idx = 0 ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         readRow2T206( ) ;
         if ( ( nRcdExists_206 != 0 ) || ( nIsMod_206 != 0 ) )
         {
            getKey2T206( ) ;
            if ( ( nRcdExists_206 == 0 ) && ( nRcdDeleted_206 == 0 ) )
            {
               if ( RcdFound206 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate2T206( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2T206( ) ;
                     closeExtendedTableCursors2T206( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CATVIGENCIA_" + sGXsfl_41_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCatVigencia_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound206 != 0 )
               {
                  if ( nRcdDeleted_206 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey2T206( ) ;
                     load2T206( ) ;
                     beforeValidate2T206( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2T206( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_206 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate2T206( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2T206( ) ;
                           closeExtendedTableCursors2T206( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_206 == 0 )
                  {
                     GXCCtl = "CATVIGENCIA_" + sGXsfl_41_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatVigencia_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatVigencia_Internalname, localUtil.format(A907CatVigencia, "99/99/9999")) ;
         httpContext.changePostValue( edtEscBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtEscAdicional_Internalname, GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynCatSalRelSec.getInternalname(), GXutil.ltrim( localUtil.ntoc( A1891CatSalRelSec, (byte)(6), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_41_idx, localUtil.dtoc( Z907CatVigencia, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z122CatBasico_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z731CatValorHora_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z908CatAdicional_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z909CatAdiHora_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1893EscAdicional_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1891CatSalRelSec_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1891CatSalRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T907CatVigencia_"+sGXsfl_41_idx, localUtil.dtoc( O907CatVigencia, 0, "/")) ;
         httpContext.changePostValue( "T1892EscBasico_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( O1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T1893EscAdicional_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( O1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_206_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_206_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_206_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_206 != 0 )
         {
            httpContext.changePostValue( "CATVIGENCIA_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCBASICO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCADICIONAL_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscAdicional_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATSALRELSEC_"+sGXsfl_41_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynCatSalRelSec.getVisible(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATSALRELSEC_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynCatSalRelSec.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption2T0( )
   {
   }

   public void e112T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext3[0] = AV16WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV16WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = AV21DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] ;
      AV21DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      Combo_catprovcod_Titlecontrolidtoreplace = edtCatProvCod_Internalname ;
      ucCombo_catprovcod.sendProperty(context, "", false, Combo_catprovcod_Internalname, "TitleControlIdToReplace", Combo_catprovcod_Titlecontrolidtoreplace);
      edtCatProvCod_Horizontalalignment = "Left" ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Horizontalalignment", edtCatProvCod_Horizontalalignment, !bGXsfl_51_Refreshing);
      Combo_catpaicod_Titlecontrolidtoreplace = edtCatPaiCod_Internalname ;
      ucCombo_catpaicod.sendProperty(context, "", false, Combo_catpaicod_Internalname, "TitleControlIdToReplace", Combo_catpaicod_Titlecontrolidtoreplace);
      edtCatPaiCod_Horizontalalignment = "Left" ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Horizontalalignment", edtCatPaiCod_Horizontalalignment, !bGXsfl_51_Refreshing);
      /* Execute user subroutine: 'LOADCOMBOCATPROVCOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean6 = AV12IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoriaAlta2_Insert", GXv_boolean7) ;
         categoriaalta2_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV12IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV12IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoriaAlta2_Update", GXv_boolean7) ;
         categoriaalta2_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV12IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV12IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoriaAlta2_Delete", GXv_boolean7) ;
         categoriaalta2_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV12IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV39Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      GXt_int8 = AV9CliCod ;
      GXv_int9[0] = GXt_int8 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int9) ;
      categoriaalta2_impl.this.GXt_int8 = GXv_int9[0] ;
      AV9CliCod = GXt_int8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
      GXt_int10 = AV11EmpCod ;
      GXv_int11[0] = GXt_int10 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int11) ;
      categoriaalta2_impl.this.GXt_int10 = GXv_int11[0] ;
      AV11EmpCod = GXt_int10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11EmpCod), 4, 0));
      GXt_objcol_char12 = AV17SinCod ;
      GXv_objcol_char13[0] = GXt_objcol_char12 ;
      new web.getsindicatosactividadempresa(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, GXv_objcol_char13) ;
      GXt_objcol_char12 = GXv_objcol_char13[0] ;
      AV17SinCod = GXt_objcol_char12 ;
      GXt_boolean6 = AV37Essistemaconceptosdefault ;
      GXv_boolean7[0] = GXt_boolean6 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean7) ;
      categoriaalta2_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
      AV37Essistemaconceptosdefault = GXt_boolean6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37Essistemaconceptosdefault", AV37Essistemaconceptosdefault);
      GXv_boolean7[0] = AV33ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV9CliCod, GXv_boolean7) ;
      categoriaalta2_impl.this.AV33ClienteConveniador = GXv_boolean7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33ClienteConveniador", AV33ClienteConveniador);
   }

   public void e122T2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      dynCatRelSec.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCatRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatRelSec.getVisible(), 5, 0), true);
      divCatrelsec_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOCATPROVCOD' Routine */
      returnInSub = false ;
      Combo_catprovcod_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CatProvCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"CatCodigo\": \"\", \"Cond_CatPaiCod\": \"#%1#\"", edtCatPaiCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_catprovcod.sendProperty(context, "", false, Combo_catprovcod_Internalname, "DataListProcParametersPrefix", Combo_catprovcod_Datalistprocparametersprefix);
   }

   public void zm2T205( int GX_JID )
   {
      if ( ( GX_JID == 25 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z123CatDescrip = T002T8_A123CatDescrip[0] ;
            Z676CatDescripSinAc = T002T8_A676CatDescripSinAc[0] ;
            Z1894CatRelSec = T002T8_A1894CatRelSec[0] ;
         }
         else
         {
            Z123CatDescrip = A123CatDescrip ;
            Z676CatDescripSinAc = A676CatDescripSinAc ;
            Z1894CatRelSec = A1894CatRelSec ;
         }
      }
      if ( GX_JID == -25 )
      {
         Z8CatCodigo = A8CatCodigo ;
         Z123CatDescrip = A123CatDescrip ;
         Z676CatDescripSinAc = A676CatDescripSinAc ;
         Z1894CatRelSec = A1894CatRelSec ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxacatrelsec_html2T205( AV9CliCod) ;
      if ( ! (0==AV9CliCod) )
      {
         A3CliCod = AV9CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      if ( ! (0==AV30CliPaiConve) )
      {
         A1564CliPaiConve = AV30CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      else
      {
         GXt_int10 = A1564CliPaiConve ;
         GXv_int11[0] = GXt_int10 ;
         new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int11) ;
         categoriaalta2_impl.this.GXt_int10 = GXv_int11[0] ;
         A1564CliPaiConve = GXt_int10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      if ( ! (GXutil.strcmp("", AV7CatCodigo)==0) )
      {
         A8CatCodigo = AV7CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
      if ( ! (GXutil.strcmp("", AV7CatCodigo)==0) )
      {
         edtCatCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtCatCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7CatCodigo)==0) )
      {
         edtCatCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      }
      dynCatProvRelSec.setVisible( ((AV37Essistemaconceptosdefault)||(AV33ClienteConveniador) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatProvRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatProvRelSec.getVisible(), 5, 0), !bGXsfl_51_Refreshing);
      dynCatSalRelSec.setVisible( ((AV37Essistemaconceptosdefault)||(AV33ClienteConveniador) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatSalRelSec.getVisible(), 5, 0), !bGXsfl_41_Refreshing);
      dynCatRelSec.setVisible( ((AV37Essistemaconceptosdefault)||(AV33ClienteConveniador) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatRelSec.getVisible(), 5, 0), true);
   }

   public void standaloneModal( )
   {
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
      if ( ! (GXutil.strcmp("", AV31CliConvenio)==0) )
      {
         A1565CliConvenio = AV31CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
         {
            GXt_char1 = A1565CliConvenio ;
            GXv_char2[0] = GXt_char1 ;
            new web.getconveniodefault(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, "", GXv_char2) ;
            categoriaalta2_impl.this.GXt_char1 = GXv_char2[0] ;
            A1565CliConvenio = GXt_char1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         }
      }
      /* Using cursor T002T9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
      }
      pr_default.close(7);
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV39Pgmname = "CategoriaAlta2" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39Pgmname", AV39Pgmname);
      }
   }

   public void load2T205( )
   {
      /* Using cursor T002T10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A123CatDescrip = T002T10_A123CatDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         A676CatDescripSinAc = T002T10_A676CatDescripSinAc[0] ;
         A1894CatRelSec = T002T10_A1894CatRelSec[0] ;
         n1894CatRelSec = T002T10_n1894CatRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1894CatRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1894CatRelSec), 4, 0));
         zm2T205( -25) ;
      }
      pr_default.close(8);
      onLoadActions2T205( ) ;
   }

   public void onLoadActions2T205( )
   {
      AV39Pgmname = "CategoriaAlta2" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39Pgmname", AV39Pgmname);
      if ( ! ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) ) )
      {
         divCatrelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
      }
      else
      {
         if ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) && ! ( ( GXutil.strcmp(A123CatDescrip, O123CatDescrip) != 0 ) ) )
         {
            divCatrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) && ( ( GXutil.strcmp(A123CatDescrip, O123CatDescrip) != 0 ) ) )
            {
               divCatrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
            }
         }
      }
   }

   public void checkExtendedTable2T205( )
   {
      nIsDirty_205 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV39Pgmname = "CategoriaAlta2" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39Pgmname", AV39Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV32aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV9CliCod, A1894CatRelSec, GXv_boolean7) ;
         categoriaalta2_impl.this.AV32aplicadoHay = GXv_boolean7[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
      }
      if ( ! ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) ) )
      {
         divCatrelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
      }
      else
      {
         if ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) && ! ( ( GXutil.strcmp(A123CatDescrip, O123CatDescrip) != 0 ) ) )
         {
            divCatrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) && ( ( GXutil.strcmp(A123CatDescrip, O123CatDescrip) != 0 ) ) )
            {
               divCatrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
            }
         }
      }
      if ( ( ( GXutil.strcmp(A123CatDescrip, O123CatDescrip) != 0 ) ) && (0==A1894CatRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CATDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatDescrip_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2T205( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey2T205( )
   {
      /* Using cursor T002T11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound205 = (short)(1) ;
      }
      else
      {
         RcdFound205 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002T8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm2T205( 25) ;
         RcdFound205 = (short)(1) ;
         A8CatCodigo = T002T8_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         A123CatDescrip = T002T8_A123CatDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         A676CatDescripSinAc = T002T8_A676CatDescripSinAc[0] ;
         A1894CatRelSec = T002T8_A1894CatRelSec[0] ;
         n1894CatRelSec = T002T8_n1894CatRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1894CatRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1894CatRelSec), 4, 0));
         A3CliCod = T002T8_A3CliCod[0] ;
         A1564CliPaiConve = T002T8_A1564CliPaiConve[0] ;
         A1565CliConvenio = T002T8_A1565CliConvenio[0] ;
         O123CatDescrip = A123CatDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         sMode205 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2T205( ) ;
         if ( AnyError == 1 )
         {
            RcdFound205 = (short)(0) ;
            initializeNonKey2T205( ) ;
         }
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound205 = (short)(0) ;
         initializeNonKey2T205( ) ;
         sMode205 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey2T205( ) ;
      if ( RcdFound205 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound205 = (short)(0) ;
      /* Using cursor T002T12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A8CatCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T002T12_A3CliCod[0] < A3CliCod ) || ( T002T12_A3CliCod[0] == A3CliCod ) && ( T002T12_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T002T12_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002T12_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002T12_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T002T12_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T002T12_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002T12_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002T12_A8CatCodigo[0], A8CatCodigo) < 0 ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T002T12_A3CliCod[0] > A3CliCod ) || ( T002T12_A3CliCod[0] == A3CliCod ) && ( T002T12_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T002T12_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002T12_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002T12_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T002T12_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T002T12_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002T12_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002T12_A8CatCodigo[0], A8CatCodigo) > 0 ) ) )
         {
            A3CliCod = T002T12_A3CliCod[0] ;
            A1564CliPaiConve = T002T12_A1564CliPaiConve[0] ;
            A1565CliConvenio = T002T12_A1565CliConvenio[0] ;
            A8CatCodigo = T002T12_A8CatCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            RcdFound205 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound205 = (short)(0) ;
      /* Using cursor T002T13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A8CatCodigo});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T002T13_A3CliCod[0] > A3CliCod ) || ( T002T13_A3CliCod[0] == A3CliCod ) && ( T002T13_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T002T13_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002T13_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002T13_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T002T13_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T002T13_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002T13_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002T13_A8CatCodigo[0], A8CatCodigo) > 0 ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T002T13_A3CliCod[0] < A3CliCod ) || ( T002T13_A3CliCod[0] == A3CliCod ) && ( T002T13_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T002T13_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002T13_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002T13_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T002T13_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T002T13_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002T13_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002T13_A8CatCodigo[0], A8CatCodigo) < 0 ) ) )
         {
            A3CliCod = T002T13_A3CliCod[0] ;
            A1564CliPaiConve = T002T13_A1564CliPaiConve[0] ;
            A1565CliConvenio = T002T13_A1565CliConvenio[0] ;
            A8CatCodigo = T002T13_A8CatCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            RcdFound205 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2T205( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2T205( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound205 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A8CatCodigo = Z8CatCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CATCODIGO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2T205( ) ;
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2T205( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CATCODIGO");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCatCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCatCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2T205( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = Z8CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CATCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2T205( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002T7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoria1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z123CatDescrip, T002T7_A123CatDescrip[0]) != 0 ) || ( GXutil.strcmp(Z676CatDescripSinAc, T002T7_A676CatDescripSinAc[0]) != 0 ) || ( Z1894CatRelSec != T002T7_A1894CatRelSec[0] ) )
         {
            if ( GXutil.strcmp(Z123CatDescrip, T002T7_A123CatDescrip[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatDescrip");
               GXutil.writeLogRaw("Old: ",Z123CatDescrip);
               GXutil.writeLogRaw("Current: ",T002T7_A123CatDescrip[0]);
            }
            if ( GXutil.strcmp(Z676CatDescripSinAc, T002T7_A676CatDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z676CatDescripSinAc);
               GXutil.writeLogRaw("Current: ",T002T7_A676CatDescripSinAc[0]);
            }
            if ( Z1894CatRelSec != T002T7_A1894CatRelSec[0] )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatRelSec");
               GXutil.writeLogRaw("Old: ",Z1894CatRelSec);
               GXutil.writeLogRaw("Current: ",T002T7_A1894CatRelSec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoria1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2T205( )
   {
      beforeValidate2T205( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2T205( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2T205( 0) ;
         checkOptimisticConcurrency2T205( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2T205( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2T205( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002T14 */
                  pr_default.execute(12, new Object[] {A8CatCodigo, A123CatDescrip, A676CatDescripSinAc, Boolean.valueOf(n1894CatRelSec), Short.valueOf(A1894CatRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
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
                        processLevel2T205( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption2T0( ) ;
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
         else
         {
            load2T205( ) ;
         }
         endLevel2T205( ) ;
      }
      closeExtendedTableCursors2T205( ) ;
   }

   public void update2T205( )
   {
      beforeValidate2T205( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2T205( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2T205( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2T205( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2T205( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002T15 */
                  pr_default.execute(13, new Object[] {A123CatDescrip, A676CatDescripSinAc, Boolean.valueOf(n1894CatRelSec), Short.valueOf(A1894CatRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoria1"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2T205( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel2T205( ) ;
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
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel2T205( ) ;
      }
      closeExtendedTableCursors2T205( ) ;
   }

   public void deferredUpdate2T205( )
   {
   }

   public void delete( )
   {
      beforeValidate2T205( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2T205( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2T205( ) ;
         afterConfirm2T205( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2T205( ) ;
            if ( AnyError == 0 )
            {
               scanStart2T274( ) ;
               while ( RcdFound274 != 0 )
               {
                  getByPrimaryKey2T274( ) ;
                  delete2T274( ) ;
                  scanNext2T274( ) ;
               }
               scanEnd2T274( ) ;
               scanStart2T206( ) ;
               while ( RcdFound206 != 0 )
               {
                  getByPrimaryKey2T206( ) ;
                  delete2T206( ) ;
                  scanNext2T206( ) ;
               }
               scanEnd2T206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002T16 */
                  pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
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
      }
      sMode205 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2T205( ) ;
      Gx_mode = sMode205 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2T205( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean7[0] = AV32aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV9CliCod, A1894CatRelSec, GXv_boolean7) ;
            categoriaalta2_impl.this.AV32aplicadoHay = GXv_boolean7[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
         }
         AV39Pgmname = "CategoriaAlta2" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39Pgmname", AV39Pgmname);
         if ( ! ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) ) )
         {
            divCatrelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) && ! ( ( GXutil.strcmp(A123CatDescrip, O123CatDescrip) != 0 ) ) )
            {
               divCatrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
            }
            else
            {
               if ( ( AV37Essistemaconceptosdefault ) || ( AV33ClienteConveniador ) && ( ( GXutil.strcmp(A123CatDescrip, O123CatDescrip) != 0 ) ) )
               {
                  divCatrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, divCatrelsec_cell_Internalname, "Class", divCatrelsec_cell_Class, true);
               }
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T002T17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionCategoria", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void processNestedLevel2T206( )
   {
      nGXsfl_41_idx = 0 ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         readRow2T206( ) ;
         if ( ( nRcdExists_206 != 0 ) || ( nIsMod_206 != 0 ) )
         {
            standaloneNotModal2T206( ) ;
            getKey2T206( ) ;
            if ( ( nRcdExists_206 == 0 ) && ( nRcdDeleted_206 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert2T206( ) ;
            }
            else
            {
               if ( RcdFound206 != 0 )
               {
                  if ( ( nRcdDeleted_206 != 0 ) && ( nRcdExists_206 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete2T206( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_206 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update2T206( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_206 == 0 )
                  {
                     GXCCtl = "CATVIGENCIA_" + sGXsfl_41_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatVigencia_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatVigencia_Internalname, localUtil.format(A907CatVigencia, "99/99/9999")) ;
         httpContext.changePostValue( edtEscBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtEscAdicional_Internalname, GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynCatSalRelSec.getInternalname(), GXutil.ltrim( localUtil.ntoc( A1891CatSalRelSec, (byte)(6), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_41_idx, localUtil.dtoc( Z907CatVigencia, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z122CatBasico_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z731CatValorHora_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z908CatAdicional_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z909CatAdiHora_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1893EscAdicional_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1891CatSalRelSec_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( Z1891CatSalRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T907CatVigencia_"+sGXsfl_41_idx, localUtil.dtoc( O907CatVigencia, 0, "/")) ;
         httpContext.changePostValue( "T1892EscBasico_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( O1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T1893EscAdicional_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( O1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_206_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_206_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_206_"+sGXsfl_41_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_206 != 0 )
         {
            httpContext.changePostValue( "CATVIGENCIA_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCBASICO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCADICIONAL_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscAdicional_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATSALRELSEC_"+sGXsfl_41_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynCatSalRelSec.getVisible(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATSALRELSEC_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynCatSalRelSec.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2T206( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_206 = (short)(0) ;
      nIsMod_206 = (short)(0) ;
      nRcdDeleted_206 = (short)(0) ;
   }

   public void processNestedLevel2T274( )
   {
      nGXsfl_51_idx = 0 ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         readRow2T274( ) ;
         if ( ( nRcdExists_274 != 0 ) || ( nIsMod_274 != 0 ) )
         {
            standaloneNotModal2T274( ) ;
            getKey2T274( ) ;
            if ( ( nRcdExists_274 == 0 ) && ( nRcdDeleted_274 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert2T274( ) ;
            }
            else
            {
               if ( RcdFound274 != 0 )
               {
                  if ( ( nRcdDeleted_274 != 0 ) && ( nRcdExists_274 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete2T274( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_274 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update2T274( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_274 == 0 )
                  {
                     GXCCtl = "CATPAICOD_" + sGXsfl_51_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatPaiCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatProvCod_Internalname, GXutil.ltrim( localUtil.ntoc( A2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynCatProvRelSec.getInternalname(), GXutil.ltrim( localUtil.ntoc( A2202CatProvRelSec, (byte)(6), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2200CatPaiCod_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2201CatProvCod_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2202CatProvRelSec_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z2202CatProvRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2203CatProvRelRef_"+sGXsfl_51_idx, Z2203CatProvRelRef) ;
         httpContext.changePostValue( "T2200CatPaiCod_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( O2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T2201CatProvCod_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( O2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_274_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_274_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_274_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_274 != 0 )
         {
            httpContext.changePostValue( "CATPAICOD_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatPaiCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPAICOD_"+sGXsfl_51_idx+"Horizontalalignment", GXutil.rtrim( edtCatPaiCod_Horizontalalignment)) ;
            httpContext.changePostValue( "CATPROVCOD_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatProvCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPROVCOD_"+sGXsfl_51_idx+"Horizontalalignment", GXutil.rtrim( edtCatProvCod_Horizontalalignment)) ;
            httpContext.changePostValue( "CATPROVRELSEC_"+sGXsfl_51_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynCatProvRelSec.getVisible(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPROVRELSEC_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynCatProvRelSec.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2T274( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_274 = (short)(0) ;
      nIsMod_274 = (short)(0) ;
      nRcdDeleted_274 = (short)(0) ;
   }

   public void processLevel2T205( )
   {
      /* Save parent mode. */
      sMode205 = Gx_mode ;
      processNestedLevel2T206( ) ;
      processNestedLevel2T274( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode205 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel2T205( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2T205( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "categoriaalta2");
         if ( AnyError == 0 )
         {
            confirmValues2T0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "categoriaalta2");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2T205( )
   {
      /* Scan By routine */
      /* Using cursor T002T18 */
      pr_default.execute(16);
      RcdFound205 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A3CliCod = T002T18_A3CliCod[0] ;
         A1564CliPaiConve = T002T18_A1564CliPaiConve[0] ;
         A1565CliConvenio = T002T18_A1565CliConvenio[0] ;
         A8CatCodigo = T002T18_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2T205( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound205 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A3CliCod = T002T18_A3CliCod[0] ;
         A1564CliPaiConve = T002T18_A1564CliPaiConve[0] ;
         A1565CliConvenio = T002T18_A1565CliConvenio[0] ;
         A8CatCodigo = T002T18_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
   }

   public void scanEnd2T205( )
   {
      pr_default.close(16);
   }

   public void afterConfirm2T205( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV32aplicadoHay ) && ! (0==A1894CatRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV9CliCod), "CatRelSec", 1, "CATRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert2T205( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2T205( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2T205( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2T205( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2T205( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2T205( )
   {
      edtCatCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      edtCatDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatDescrip_Enabled), 5, 0), true);
      dynCatRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCatRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatRelSec.getEnabled(), 5, 0), true);
   }

   public void zm2T206( int GX_JID )
   {
      if ( ( GX_JID == 27 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z122CatBasico = T002T6_A122CatBasico[0] ;
            Z731CatValorHora = T002T6_A731CatValorHora[0] ;
            Z908CatAdicional = T002T6_A908CatAdicional[0] ;
            Z909CatAdiHora = T002T6_A909CatAdiHora[0] ;
            Z1892EscBasico = T002T6_A1892EscBasico[0] ;
            Z1893EscAdicional = T002T6_A1893EscAdicional[0] ;
            Z1891CatSalRelSec = T002T6_A1891CatSalRelSec[0] ;
         }
         else
         {
            Z122CatBasico = A122CatBasico ;
            Z731CatValorHora = A731CatValorHora ;
            Z908CatAdicional = A908CatAdicional ;
            Z909CatAdiHora = A909CatAdiHora ;
            Z1892EscBasico = A1892EscBasico ;
            Z1893EscAdicional = A1893EscAdicional ;
            Z1891CatSalRelSec = A1891CatSalRelSec ;
         }
      }
      if ( GX_JID == -27 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         Z122CatBasico = A122CatBasico ;
         Z731CatValorHora = A731CatValorHora ;
         Z908CatAdicional = A908CatAdicional ;
         Z909CatAdiHora = A909CatAdiHora ;
         Z1892EscBasico = A1892EscBasico ;
         Z1893EscAdicional = A1893EscAdicional ;
         Z1891CatSalRelSec = A1891CatSalRelSec ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal2T206( )
   {
      gxacatsalrelsec_html2T206( AV9CliCod) ;
   }

   public void standaloneModal2T206( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCatVigencia_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      }
      else
      {
         edtCatVigencia_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      }
   }

   public void load2T206( )
   {
      /* Using cursor T002T19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A122CatBasico = T002T19_A122CatBasico[0] ;
         n122CatBasico = T002T19_n122CatBasico[0] ;
         A731CatValorHora = T002T19_A731CatValorHora[0] ;
         n731CatValorHora = T002T19_n731CatValorHora[0] ;
         A908CatAdicional = T002T19_A908CatAdicional[0] ;
         n908CatAdicional = T002T19_n908CatAdicional[0] ;
         A909CatAdiHora = T002T19_A909CatAdiHora[0] ;
         n909CatAdiHora = T002T19_n909CatAdiHora[0] ;
         A1892EscBasico = T002T19_A1892EscBasico[0] ;
         A1893EscAdicional = T002T19_A1893EscAdicional[0] ;
         A1891CatSalRelSec = T002T19_A1891CatSalRelSec[0] ;
         n1891CatSalRelSec = T002T19_n1891CatSalRelSec[0] ;
         zm2T206( -27) ;
      }
      pr_default.close(17);
      onLoadActions2T206( ) ;
   }

   public void onLoadActions2T206( )
   {
   }

   public void checkExtendedTable2T206( )
   {
      nIsDirty_206 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal2T206( ) ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV32aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV9CliCod, A1891CatSalRelSec, GXv_boolean7) ;
         categoriaalta2_impl.this.AV32aplicadoHay = GXv_boolean7[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
      }
      if ( ( !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) && (0==A1891CatSalRelSec) )
      {
         GXCCtl = "CATVIGENCIA_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatVigencia_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2T206( )
   {
   }

   public void enableDisable2T206( )
   {
   }

   public void getKey2T206( )
   {
      /* Using cursor T002T20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound206 = (short)(1) ;
      }
      else
      {
         RcdFound206 = (short)(0) ;
      }
      pr_default.close(18);
   }

   public void getByPrimaryKey2T206( )
   {
      /* Using cursor T002T6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm2T206( 27) ;
         RcdFound206 = (short)(1) ;
         initializeNonKey2T206( ) ;
         A907CatVigencia = T002T6_A907CatVigencia[0] ;
         A122CatBasico = T002T6_A122CatBasico[0] ;
         n122CatBasico = T002T6_n122CatBasico[0] ;
         A731CatValorHora = T002T6_A731CatValorHora[0] ;
         n731CatValorHora = T002T6_n731CatValorHora[0] ;
         A908CatAdicional = T002T6_A908CatAdicional[0] ;
         n908CatAdicional = T002T6_n908CatAdicional[0] ;
         A909CatAdiHora = T002T6_A909CatAdiHora[0] ;
         n909CatAdiHora = T002T6_n909CatAdiHora[0] ;
         A1892EscBasico = T002T6_A1892EscBasico[0] ;
         A1893EscAdicional = T002T6_A1893EscAdicional[0] ;
         A1891CatSalRelSec = T002T6_A1891CatSalRelSec[0] ;
         n1891CatSalRelSec = T002T6_n1891CatSalRelSec[0] ;
         O907CatVigencia = A907CatVigencia ;
         O1892EscBasico = A1892EscBasico ;
         O1893EscAdicional = A1893EscAdicional ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2T206( ) ;
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound206 = (short)(0) ;
         initializeNonKey2T206( ) ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal2T206( ) ;
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2T206( ) ;
      }
      pr_default.close(4);
   }

   public void checkOptimisticConcurrency2T206( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002T5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(3) == 101) || ( DecimalUtil.compareTo(Z122CatBasico, T002T5_A122CatBasico[0]) != 0 ) || ( DecimalUtil.compareTo(Z731CatValorHora, T002T5_A731CatValorHora[0]) != 0 ) || ( DecimalUtil.compareTo(Z908CatAdicional, T002T5_A908CatAdicional[0]) != 0 ) || ( DecimalUtil.compareTo(Z909CatAdiHora, T002T5_A909CatAdiHora[0]) != 0 ) || ( DecimalUtil.compareTo(Z1892EscBasico, T002T5_A1892EscBasico[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1893EscAdicional, T002T5_A1893EscAdicional[0]) != 0 ) || ( Z1891CatSalRelSec != T002T5_A1891CatSalRelSec[0] ) )
         {
            if ( DecimalUtil.compareTo(Z122CatBasico, T002T5_A122CatBasico[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatBasico");
               GXutil.writeLogRaw("Old: ",Z122CatBasico);
               GXutil.writeLogRaw("Current: ",T002T5_A122CatBasico[0]);
            }
            if ( DecimalUtil.compareTo(Z731CatValorHora, T002T5_A731CatValorHora[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatValorHora");
               GXutil.writeLogRaw("Old: ",Z731CatValorHora);
               GXutil.writeLogRaw("Current: ",T002T5_A731CatValorHora[0]);
            }
            if ( DecimalUtil.compareTo(Z908CatAdicional, T002T5_A908CatAdicional[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatAdicional");
               GXutil.writeLogRaw("Old: ",Z908CatAdicional);
               GXutil.writeLogRaw("Current: ",T002T5_A908CatAdicional[0]);
            }
            if ( DecimalUtil.compareTo(Z909CatAdiHora, T002T5_A909CatAdiHora[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatAdiHora");
               GXutil.writeLogRaw("Old: ",Z909CatAdiHora);
               GXutil.writeLogRaw("Current: ",T002T5_A909CatAdiHora[0]);
            }
            if ( DecimalUtil.compareTo(Z1892EscBasico, T002T5_A1892EscBasico[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"EscBasico");
               GXutil.writeLogRaw("Old: ",Z1892EscBasico);
               GXutil.writeLogRaw("Current: ",T002T5_A1892EscBasico[0]);
            }
            if ( DecimalUtil.compareTo(Z1893EscAdicional, T002T5_A1893EscAdicional[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"EscAdicional");
               GXutil.writeLogRaw("Old: ",Z1893EscAdicional);
               GXutil.writeLogRaw("Current: ",T002T5_A1893EscAdicional[0]);
            }
            if ( Z1891CatSalRelSec != T002T5_A1891CatSalRelSec[0] )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatSalRelSec");
               GXutil.writeLogRaw("Old: ",Z1891CatSalRelSec);
               GXutil.writeLogRaw("Current: ",T002T5_A1891CatSalRelSec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoriavalores1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2T206( )
   {
      beforeValidate2T206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2T206( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2T206( 0) ;
         checkOptimisticConcurrency2T206( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2T206( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2T206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002T21 */
                  pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A8CatCodigo, A907CatVigencia, Boolean.valueOf(n122CatBasico), A122CatBasico, Boolean.valueOf(n731CatValorHora), A731CatValorHora, Boolean.valueOf(n908CatAdicional), A908CatAdicional, Boolean.valueOf(n909CatAdiHora), A909CatAdiHora, A1892EscBasico, A1893EscAdicional, Boolean.valueOf(n1891CatSalRelSec), Integer.valueOf(A1891CatSalRelSec), Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                  if ( (pr_default.getStatus(19) == 1) )
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
            load2T206( ) ;
         }
         endLevel2T206( ) ;
      }
      closeExtendedTableCursors2T206( ) ;
   }

   public void update2T206( )
   {
      beforeValidate2T206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2T206( ) ;
      }
      if ( ( nIsMod_206 != 0 ) || ( nIsDirty_206 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency2T206( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm2T206( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate2T206( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T002T22 */
                     pr_default.execute(20, new Object[] {Boolean.valueOf(n122CatBasico), A122CatBasico, Boolean.valueOf(n731CatValorHora), A731CatValorHora, Boolean.valueOf(n908CatAdicional), A908CatAdicional, Boolean.valueOf(n909CatAdiHora), A909CatAdiHora, A1892EscBasico, A1893EscAdicional, Boolean.valueOf(n1891CatSalRelSec), Integer.valueOf(A1891CatSalRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                     if ( (pr_default.getStatus(20) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate2T206( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey2T206( ) ;
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
            endLevel2T206( ) ;
         }
      }
      closeExtendedTableCursors2T206( ) ;
   }

   public void deferredUpdate2T206( )
   {
   }

   public void delete2T206( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2T206( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2T206( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2T206( ) ;
         afterConfirm2T206( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2T206( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002T23 */
               pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode206 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2T206( ) ;
      Gx_mode = sMode206 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2T206( )
   {
      standaloneModal2T206( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean7[0] = AV32aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV9CliCod, A1891CatSalRelSec, GXv_boolean7) ;
            categoriaalta2_impl.this.AV32aplicadoHay = GXv_boolean7[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
         }
      }
   }

   public void endLevel2T206( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2T206( )
   {
      /* Scan By routine */
      /* Using cursor T002T24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A907CatVigencia = T002T24_A907CatVigencia[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2T206( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A907CatVigencia = T002T24_A907CatVigencia[0] ;
      }
   }

   public void scanEnd2T206( )
   {
      pr_default.close(22);
   }

   public void afterConfirm2T206( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV32aplicadoHay ) && ! (0==A1891CatSalRelSec) )
      {
         GXCCtl = "CATSALRELSEC_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV9CliCod), "CatSalRelSec", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatSalRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
      if ( ( isIns( )  || isUpd( )  ) && ( AV32aplicadoHay ) && ! (0==A1894CatRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV9CliCod), "CatRelSec", 1, "CATRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert2T206( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2T206( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2T206( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2T206( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2T206( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2T206( )
   {
      edtCatVigencia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtEscBasico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEscBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscBasico_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      edtEscAdicional_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEscAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscAdicional_Enabled), 5, 0), !bGXsfl_41_Refreshing);
      dynCatSalRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatSalRelSec.getEnabled(), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void send_integrity_lvl_hashes2T206( )
   {
   }

   public void zm2T274( int GX_JID )
   {
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2202CatProvRelSec = T002T3_A2202CatProvRelSec[0] ;
            Z2203CatProvRelRef = T002T3_A2203CatProvRelRef[0] ;
         }
         else
         {
            Z2202CatProvRelSec = A2202CatProvRelSec ;
            Z2203CatProvRelRef = A2203CatProvRelRef ;
         }
      }
      if ( GX_JID == -28 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z2202CatProvRelSec = A2202CatProvRelSec ;
         Z2203CatProvRelRef = A2203CatProvRelRef ;
         Z2204CatProvOld = A2204CatProvOld ;
         Z2200CatPaiCod = A2200CatPaiCod ;
         Z2201CatProvCod = A2201CatProvCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal2T274( )
   {
      gxacatprovrelsec_html2T274( AV9CliCod) ;
   }

   public void standaloneModal2T274( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCatPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      }
      else
      {
         edtCatPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCatProvCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      }
      else
      {
         edtCatProvCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      }
   }

   public void load2T274( )
   {
      /* Using cursor T002T25 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2202CatProvRelSec = T002T25_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = T002T25_n2202CatProvRelSec[0] ;
         A2203CatProvRelRef = T002T25_A2203CatProvRelRef[0] ;
         n2203CatProvRelRef = T002T25_n2203CatProvRelRef[0] ;
         A2204CatProvOld = T002T25_A2204CatProvOld[0] ;
         n2204CatProvOld = T002T25_n2204CatProvOld[0] ;
         zm2T274( -28) ;
      }
      pr_default.close(23);
      onLoadActions2T274( ) ;
   }

   public void onLoadActions2T274( )
   {
   }

   public void checkExtendedTable2T274( )
   {
      nIsDirty_274 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal2T274( ) ;
      /* Using cursor T002T4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "CATPROVCOD_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ( ( A2200CatPaiCod != O2200CatPaiCod ) || ( A2201CatProvCod != O2201CatProvCod ) ) && (0==A2202CatProvRelSec) )
      {
         GXCCtl = "CATPAICOD_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2T274( )
   {
      pr_default.close(2);
   }

   public void enableDisable2T274( )
   {
   }

   public void gxload_29( short A2200CatPaiCod ,
                          short A2201CatProvCod )
   {
      /* Using cursor T002T26 */
      pr_default.execute(24, new Object[] {Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(24) == 101) )
      {
         GXCCtl = "CATPROVCOD_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(24) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(24);
   }

   public void getKey2T274( )
   {
      /* Using cursor T002T27 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound274 = (short)(1) ;
      }
      else
      {
         RcdFound274 = (short)(0) ;
      }
      pr_default.close(25);
   }

   public void getByPrimaryKey2T274( )
   {
      /* Using cursor T002T3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2T274( 28) ;
         RcdFound274 = (short)(1) ;
         initializeNonKey2T274( ) ;
         A2202CatProvRelSec = T002T3_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = T002T3_n2202CatProvRelSec[0] ;
         A2203CatProvRelRef = T002T3_A2203CatProvRelRef[0] ;
         n2203CatProvRelRef = T002T3_n2203CatProvRelRef[0] ;
         A2204CatProvOld = T002T3_A2204CatProvOld[0] ;
         n2204CatProvOld = T002T3_n2204CatProvOld[0] ;
         A2200CatPaiCod = T002T3_A2200CatPaiCod[0] ;
         A2201CatProvCod = T002T3_A2201CatProvCod[0] ;
         O2200CatPaiCod = A2200CatPaiCod ;
         O2201CatProvCod = A2201CatProvCod ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z2200CatPaiCod = A2200CatPaiCod ;
         Z2201CatProvCod = A2201CatProvCod ;
         sMode274 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2T274( ) ;
         Gx_mode = sMode274 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound274 = (short)(0) ;
         initializeNonKey2T274( ) ;
         sMode274 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal2T274( ) ;
         Gx_mode = sMode274 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2T274( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency2T274( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002T2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CategoriaProvincias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z2202CatProvRelSec != T002T2_A2202CatProvRelSec[0] ) || ( GXutil.strcmp(Z2203CatProvRelRef, T002T2_A2203CatProvRelRef[0]) != 0 ) )
         {
            if ( Z2202CatProvRelSec != T002T2_A2202CatProvRelSec[0] )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatProvRelSec");
               GXutil.writeLogRaw("Old: ",Z2202CatProvRelSec);
               GXutil.writeLogRaw("Current: ",T002T2_A2202CatProvRelSec[0]);
            }
            if ( GXutil.strcmp(Z2203CatProvRelRef, T002T2_A2203CatProvRelRef[0]) != 0 )
            {
               GXutil.writeLogln("categoriaalta2:[seudo value changed for attri]"+"CatProvRelRef");
               GXutil.writeLogRaw("Old: ",Z2203CatProvRelRef);
               GXutil.writeLogRaw("Current: ",T002T2_A2203CatProvRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CategoriaProvincias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2T274( )
   {
      beforeValidate2T274( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2T274( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2T274( 0) ;
         checkOptimisticConcurrency2T274( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2T274( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2T274( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002T28 */
                  pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A8CatCodigo, Boolean.valueOf(n2202CatProvRelSec), Integer.valueOf(A2202CatProvRelSec), Boolean.valueOf(n2203CatProvRelRef), A2203CatProvRelRef, Boolean.valueOf(n2204CatProvOld), A2204CatProvOld, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod), Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
                  if ( (pr_default.getStatus(26) == 1) )
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
            load2T274( ) ;
         }
         endLevel2T274( ) ;
      }
      closeExtendedTableCursors2T274( ) ;
   }

   public void update2T274( )
   {
      beforeValidate2T274( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2T274( ) ;
      }
      if ( ( nIsMod_274 != 0 ) || ( nIsDirty_274 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency2T274( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm2T274( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate2T274( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T002T29 */
                     pr_default.execute(27, new Object[] {Boolean.valueOf(n2202CatProvRelSec), Integer.valueOf(A2202CatProvRelSec), Boolean.valueOf(n2203CatProvRelRef), A2203CatProvRelRef, Boolean.valueOf(n2204CatProvOld), A2204CatProvOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
                     if ( (pr_default.getStatus(27) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CategoriaProvincias"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate2T274( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey2T274( ) ;
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
            endLevel2T274( ) ;
         }
      }
      closeExtendedTableCursors2T274( ) ;
   }

   public void deferredUpdate2T274( )
   {
   }

   public void delete2T274( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2T274( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2T274( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2T274( ) ;
         afterConfirm2T274( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2T274( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002T30 */
               pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode274 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2T274( ) ;
      Gx_mode = sMode274 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2T274( )
   {
      standaloneModal2T274( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2T274( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2T274( )
   {
      /* Scan By routine */
      /* Using cursor T002T31 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      RcdFound274 = (short)(0) ;
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2200CatPaiCod = T002T31_A2200CatPaiCod[0] ;
         A2201CatProvCod = T002T31_A2201CatProvCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2T274( )
   {
      /* Scan next routine */
      pr_default.readNext(29);
      RcdFound274 = (short)(0) ;
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2200CatPaiCod = T002T31_A2200CatPaiCod[0] ;
         A2201CatProvCod = T002T31_A2201CatProvCod[0] ;
      }
   }

   public void scanEnd2T274( )
   {
      pr_default.close(29);
   }

   public void afterConfirm2T274( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2T274( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2T274( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2T274( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2T274( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2T274( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2T274( )
   {
      edtCatPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      edtCatProvCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      dynCatProvRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCatProvRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatProvRelSec.getEnabled(), 5, 0), !bGXsfl_51_Refreshing);
   }

   public void send_integrity_lvl_hashes2T274( )
   {
   }

   public void send_integrity_lvl_hashes2T205( )
   {
   }

   public void subsflControlProps_41206( )
   {
      edtCatVigencia_Internalname = "CATVIGENCIA_"+sGXsfl_41_idx ;
      edtEscBasico_Internalname = "ESCBASICO_"+sGXsfl_41_idx ;
      edtEscAdicional_Internalname = "ESCADICIONAL_"+sGXsfl_41_idx ;
      dynCatSalRelSec.setInternalname( "CATSALRELSEC_"+sGXsfl_41_idx );
   }

   public void subsflControlProps_fel_41206( )
   {
      edtCatVigencia_Internalname = "CATVIGENCIA_"+sGXsfl_41_fel_idx ;
      edtEscBasico_Internalname = "ESCBASICO_"+sGXsfl_41_fel_idx ;
      edtEscAdicional_Internalname = "ESCADICIONAL_"+sGXsfl_41_fel_idx ;
      dynCatSalRelSec.setInternalname( "CATSALRELSEC_"+sGXsfl_41_fel_idx );
   }

   public void addRow2T206( )
   {
      nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41206( ) ;
      sendRow2T206( ) ;
   }

   public void sendRow2T206( )
   {
      Gridlevel_valoresRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_valores_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_valores_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(0) ;
         subGridlevel_valores_Backcolor = subGridlevel_valores_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_valores_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
         }
         subGridlevel_valores_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_valores_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_41_idx) % (2))) == 0 )
         {
            subGridlevel_valores_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_valores_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "AttributeDate" ;
      Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatVigencia_Internalname,localUtil.format(A907CatVigencia, "99/99/9999"),localUtil.format( A907CatVigencia, "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,42);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatVigencia_Jsonclick,Integer.valueOf(0),"AttributeDate","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCatVigencia_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 43,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEscBasico_Internalname,GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtEscBasico_Enabled!=0) ? localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,43);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEscBasico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtEscBasico_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 44,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEscAdicional_Internalname,GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtEscAdicional_Enabled!=0) ? localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,44);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEscAdicional_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtEscAdicional_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(41),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      gxacatsalrelsec_html2T206( AV9CliCod) ;
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_41_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_41_idx + "',41)\"" ;
      if ( ( dynCatSalRelSec.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CATSALRELSEC_" + sGXsfl_41_idx ;
         dynCatSalRelSec.setName( GXCCtl );
         dynCatSalRelSec.setWebtags( "" );
      }
      /* ComboBox */
      Gridlevel_valoresRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynCatSalRelSec,dynCatSalRelSec.getInternalname(),GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0)),Integer.valueOf(1),dynCatSalRelSec.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(dynCatSalRelSec.getVisible()),Integer.valueOf(dynCatSalRelSec.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynCatSalRelSec.setValue( GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Values", dynCatSalRelSec.ToJavascriptSource(), !bGXsfl_41_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel_valoresRow);
      send_integrity_lvl_hashes2T206( ) ;
      GXCCtl = "Z907CatVigencia_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z907CatVigencia, 0, "/"));
      GXCCtl = "Z122CatBasico_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z731CatValorHora_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z908CatAdicional_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z909CatAdiHora_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1892EscBasico_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1893EscAdicional_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1891CatSalRelSec_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1891CatSalRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O907CatVigencia_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( O907CatVigencia, 0, "/"));
      GXCCtl = "O1892EscBasico_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O1893EscAdicional_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_206_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_206_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_206_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV30CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV31CliConvenio));
      GXCCtl = "vCATCODIGO_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV7CatCodigo));
      GXCCtl = "CLICOD_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "CLIPAICONVE_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "CLICONVENIO_" + sGXsfl_41_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "CATVIGENCIA_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ESCBASICO_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ESCADICIONAL_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscAdicional_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATSALRELSEC_"+sGXsfl_41_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynCatSalRelSec.getVisible(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATSALRELSEC_"+sGXsfl_41_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynCatSalRelSec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_valoresContainer.AddRow(Gridlevel_valoresRow);
   }

   public void readRow2T206( )
   {
      nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41206( ) ;
      edtCatVigencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATVIGENCIA_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtEscBasico_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCBASICO_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtEscAdicional_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCADICIONAL_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      dynCatSalRelSec.setVisible( (int)(localUtil.ctol( httpContext.cgiGet( "CATSALRELSEC_"+sGXsfl_41_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      dynCatSalRelSec.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CATSALRELSEC_"+sGXsfl_41_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      if ( localUtil.vcdate( httpContext.cgiGet( edtCatVigencia_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
      {
         GXCCtl = "CATVIGENCIA_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatVigencia_Internalname ;
         wbErr = true ;
         A907CatVigencia = GXutil.nullDate() ;
      }
      else
      {
         A907CatVigencia = localUtil.ctod( httpContext.cgiGet( edtCatVigencia_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      }
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "ESCBASICO_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEscBasico_Internalname ;
         wbErr = true ;
         A1892EscBasico = DecimalUtil.ZERO ;
      }
      else
      {
         A1892EscBasico = localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)) ;
      }
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "ESCADICIONAL_" + sGXsfl_41_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEscAdicional_Internalname ;
         wbErr = true ;
         A1893EscAdicional = DecimalUtil.ZERO ;
      }
      else
      {
         A1893EscAdicional = localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)) ;
      }
      dynCatSalRelSec.setName( dynCatSalRelSec.getInternalname() );
      dynCatSalRelSec.setValue( httpContext.cgiGet( dynCatSalRelSec.getInternalname()) );
      A1891CatSalRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCatSalRelSec.getInternalname()))) ;
      n1891CatSalRelSec = false ;
      n1891CatSalRelSec = ((0==A1891CatSalRelSec) ? true : false) ;
      GXCCtl = "Z907CatVigencia_" + sGXsfl_41_idx ;
      Z907CatVigencia = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z122CatBasico_" + sGXsfl_41_idx ;
      Z122CatBasico = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n122CatBasico = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A122CatBasico)==0) ? true : false) ;
      GXCCtl = "Z731CatValorHora_" + sGXsfl_41_idx ;
      Z731CatValorHora = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n731CatValorHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A731CatValorHora)==0) ? true : false) ;
      GXCCtl = "Z908CatAdicional_" + sGXsfl_41_idx ;
      Z908CatAdicional = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n908CatAdicional = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A908CatAdicional)==0) ? true : false) ;
      GXCCtl = "Z909CatAdiHora_" + sGXsfl_41_idx ;
      Z909CatAdiHora = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n909CatAdiHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A909CatAdiHora)==0) ? true : false) ;
      GXCCtl = "Z1892EscBasico_" + sGXsfl_41_idx ;
      Z1892EscBasico = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1893EscAdicional_" + sGXsfl_41_idx ;
      Z1893EscAdicional = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1891CatSalRelSec_" + sGXsfl_41_idx ;
      Z1891CatSalRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n1891CatSalRelSec = ((0==A1891CatSalRelSec) ? true : false) ;
      GXCCtl = "Z122CatBasico_" + sGXsfl_41_idx ;
      A122CatBasico = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n122CatBasico = false ;
      n122CatBasico = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A122CatBasico)==0) ? true : false) ;
      GXCCtl = "Z731CatValorHora_" + sGXsfl_41_idx ;
      A731CatValorHora = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n731CatValorHora = false ;
      n731CatValorHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A731CatValorHora)==0) ? true : false) ;
      GXCCtl = "Z908CatAdicional_" + sGXsfl_41_idx ;
      A908CatAdicional = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n908CatAdicional = false ;
      n908CatAdicional = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A908CatAdicional)==0) ? true : false) ;
      GXCCtl = "Z909CatAdiHora_" + sGXsfl_41_idx ;
      A909CatAdiHora = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n909CatAdiHora = false ;
      n909CatAdiHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A909CatAdiHora)==0) ? true : false) ;
      GXCCtl = "O907CatVigencia_" + sGXsfl_41_idx ;
      O907CatVigencia = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "O1892EscBasico_" + sGXsfl_41_idx ;
      O1892EscBasico = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "O1893EscAdicional_" + sGXsfl_41_idx ;
      O1893EscAdicional = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_206_" + sGXsfl_41_idx ;
      nRcdDeleted_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_206_" + sGXsfl_41_idx ;
      nRcdExists_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_206_" + sGXsfl_41_idx ;
      nIsMod_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void subsflControlProps_51274( )
   {
      edtCatPaiCod_Internalname = "CATPAICOD_"+sGXsfl_51_idx ;
      edtCatProvCod_Internalname = "CATPROVCOD_"+sGXsfl_51_idx ;
      dynCatProvRelSec.setInternalname( "CATPROVRELSEC_"+sGXsfl_51_idx );
   }

   public void subsflControlProps_fel_51274( )
   {
      edtCatPaiCod_Internalname = "CATPAICOD_"+sGXsfl_51_fel_idx ;
      edtCatProvCod_Internalname = "CATPROVCOD_"+sGXsfl_51_fel_idx ;
      dynCatProvRelSec.setInternalname( "CATPROVRELSEC_"+sGXsfl_51_fel_idx );
   }

   public void addRow2T274( )
   {
      nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51274( ) ;
      sendRow2T274( ) ;
   }

   public void sendRow2T274( )
   {
      Gridlevel_provinciasRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_provincias_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_provincias_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_provincias_Class, "") != 0 )
         {
            subGridlevel_provincias_Linesclass = subGridlevel_provincias_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_provincias_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_provincias_Backstyle = (byte)(0) ;
         subGridlevel_provincias_Backcolor = subGridlevel_provincias_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_provincias_Class, "") != 0 )
         {
            subGridlevel_provincias_Linesclass = subGridlevel_provincias_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_provincias_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_provincias_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_provincias_Class, "") != 0 )
         {
            subGridlevel_provincias_Linesclass = subGridlevel_provincias_Class+"Odd" ;
         }
         subGridlevel_provincias_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_provincias_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_provincias_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_51_idx) % (2))) == 0 )
         {
            subGridlevel_provincias_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_provincias_Class, "") != 0 )
            {
               subGridlevel_provincias_Linesclass = subGridlevel_provincias_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_provincias_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_provincias_Class, "") != 0 )
            {
               subGridlevel_provincias_Linesclass = subGridlevel_provincias_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_274_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 52,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_provinciasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatPaiCod_Internalname,GXutil.ltrim( localUtil.ntoc( A2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2200CatPaiCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatPaiCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCatPaiCod_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(51),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico",edtCatPaiCod_Horizontalalignment,Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_274_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 53,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_provinciasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatProvCod_Internalname,GXutil.ltrim( localUtil.ntoc( A2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2201CatProvCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,53);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatProvCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCatProvCod_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(51),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico",edtCatProvCod_Horizontalalignment,Boolean.valueOf(false),""});
      gxacatprovrelsec_html2T274( AV9CliCod) ;
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_274_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 54,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      if ( ( dynCatProvRelSec.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CATPROVRELSEC_" + sGXsfl_51_idx ;
         dynCatProvRelSec.setName( GXCCtl );
         dynCatProvRelSec.setWebtags( "" );
      }
      /* ComboBox */
      Gridlevel_provinciasRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynCatProvRelSec,dynCatProvRelSec.getInternalname(),GXutil.trim( GXutil.str( A2202CatProvRelSec, 6, 0)),Integer.valueOf(1),dynCatProvRelSec.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(dynCatProvRelSec.getVisible()),Integer.valueOf(dynCatProvRelSec.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynCatProvRelSec.setValue( GXutil.trim( GXutil.str( A2202CatProvRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatProvRelSec.getInternalname(), "Values", dynCatProvRelSec.ToJavascriptSource(), !bGXsfl_51_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel_provinciasRow);
      send_integrity_lvl_hashes2T274( ) ;
      GXCCtl = "Z2200CatPaiCod_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2201CatProvCod_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2202CatProvRelSec_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2202CatProvRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2203CatProvRelRef_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2203CatProvRelRef);
      GXCCtl = "O2200CatPaiCod_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O2201CatProvCod_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_274_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_274_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_274_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV30CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV31CliConvenio));
      GXCCtl = "vCATCODIGO_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV7CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPAICOD_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatPaiCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPAICOD_"+sGXsfl_51_idx+"Horizontalalignment", GXutil.rtrim( edtCatPaiCod_Horizontalalignment));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVCOD_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatProvCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVCOD_"+sGXsfl_51_idx+"Horizontalalignment", GXutil.rtrim( edtCatProvCod_Horizontalalignment));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVRELSEC_"+sGXsfl_51_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynCatProvRelSec.getVisible(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVRELSEC_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynCatProvRelSec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_provinciasContainer.AddRow(Gridlevel_provinciasRow);
   }

   public void readRow2T274( )
   {
      nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51274( ) ;
      edtCatPaiCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATPAICOD_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCatPaiCod_Horizontalalignment = httpContext.cgiGet( "CATPAICOD_"+sGXsfl_51_idx+"Horizontalalignment") ;
      edtCatProvCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVCOD_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCatProvCod_Horizontalalignment = httpContext.cgiGet( "CATPROVCOD_"+sGXsfl_51_idx+"Horizontalalignment") ;
      dynCatProvRelSec.setVisible( (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVRELSEC_"+sGXsfl_51_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      dynCatProvRelSec.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVRELSEC_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCatPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCatPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "CATPAICOD_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
         wbErr = true ;
         A2200CatPaiCod = (short)(0) ;
      }
      else
      {
         A2200CatPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtCatPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCatProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCatProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "CATPROVCOD_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatProvCod_Internalname ;
         wbErr = true ;
         A2201CatProvCod = (short)(0) ;
      }
      else
      {
         A2201CatProvCod = (short)(localUtil.ctol( httpContext.cgiGet( edtCatProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      dynCatProvRelSec.setName( dynCatProvRelSec.getInternalname() );
      dynCatProvRelSec.setValue( httpContext.cgiGet( dynCatProvRelSec.getInternalname()) );
      A2202CatProvRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCatProvRelSec.getInternalname()))) ;
      n2202CatProvRelSec = false ;
      n2202CatProvRelSec = ((0==A2202CatProvRelSec) ? true : false) ;
      GXCCtl = "Z2200CatPaiCod_" + sGXsfl_51_idx ;
      Z2200CatPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2201CatProvCod_" + sGXsfl_51_idx ;
      Z2201CatProvCod = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2202CatProvRelSec_" + sGXsfl_51_idx ;
      Z2202CatProvRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n2202CatProvRelSec = ((0==A2202CatProvRelSec) ? true : false) ;
      GXCCtl = "Z2203CatProvRelRef_" + sGXsfl_51_idx ;
      Z2203CatProvRelRef = httpContext.cgiGet( GXCCtl) ;
      n2203CatProvRelRef = ((GXutil.strcmp("", A2203CatProvRelRef)==0) ? true : false) ;
      GXCCtl = "Z2203CatProvRelRef_" + sGXsfl_51_idx ;
      A2203CatProvRelRef = httpContext.cgiGet( GXCCtl) ;
      n2203CatProvRelRef = false ;
      n2203CatProvRelRef = ((GXutil.strcmp("", A2203CatProvRelRef)==0) ? true : false) ;
      GXCCtl = "O2200CatPaiCod_" + sGXsfl_51_idx ;
      O2200CatPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "O2201CatProvCod_" + sGXsfl_51_idx ;
      O2201CatProvCod = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdDeleted_274_" + sGXsfl_51_idx ;
      nRcdDeleted_274 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_274_" + sGXsfl_51_idx ;
      nRcdExists_274 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_274_" + sGXsfl_51_idx ;
      nIsMod_274 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtCatProvCod_Enabled = edtCatProvCod_Enabled ;
      defedtCatPaiCod_Enabled = edtCatPaiCod_Enabled ;
      defedtCatVigencia_Enabled = edtCatVigencia_Enabled ;
   }

   public void confirmValues2T0( )
   {
      nGXsfl_41_idx = 0 ;
      sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_41206( ) ;
      while ( nGXsfl_41_idx < nRC_GXsfl_41 )
      {
         nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_41206( ) ;
         httpContext.changePostValue( "Z907CatVigencia_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z907CatVigencia_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z122CatBasico_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z122CatBasico_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z122CatBasico_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z731CatValorHora_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z731CatValorHora_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z731CatValorHora_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z908CatAdicional_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z908CatAdicional_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z908CatAdicional_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z909CatAdiHora_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z909CatAdiHora_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z909CatAdiHora_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1892EscBasico_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1892EscBasico_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1893EscAdicional_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1893EscAdicional_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1893EscAdicional_"+sGXsfl_41_idx) ;
         httpContext.changePostValue( "Z1891CatSalRelSec_"+sGXsfl_41_idx, httpContext.cgiGet( "ZT_"+"Z1891CatSalRelSec_"+sGXsfl_41_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1891CatSalRelSec_"+sGXsfl_41_idx) ;
      }
      nGXsfl_51_idx = 0 ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51274( ) ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_51274( ) ;
         httpContext.changePostValue( "Z2200CatPaiCod_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z2200CatPaiCod_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2200CatPaiCod_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z2201CatProvCod_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z2201CatProvCod_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2201CatProvCod_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z2202CatProvRelSec_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z2202CatProvRelSec_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2202CatProvRelSec_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z2203CatProvRelRef_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z2203CatProvRelRef_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2203CatProvRelRef_"+sGXsfl_51_idx) ;
      }
      httpContext.changePostValue( "O907CatVigencia", httpContext.cgiGet( "T907CatVigencia")) ;
      httpContext.deletePostValue( "T907CatVigencia") ;
      httpContext.changePostValue( "O1892EscBasico", httpContext.cgiGet( "T1892EscBasico")) ;
      httpContext.deletePostValue( "T1892EscBasico") ;
      httpContext.changePostValue( "O1893EscAdicional", httpContext.cgiGet( "T1893EscAdicional")) ;
      httpContext.deletePostValue( "T1893EscAdicional") ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.categoriaalta2", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV9CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV30CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV31CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV7CatCodigo))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CatCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"CategoriaAlta2");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CatDescripSinAc", GXutil.rtrim( localUtil.format( A676CatDescripSinAc, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("categoriaalta2:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z8CatCodigo", GXutil.rtrim( Z8CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z123CatDescrip", Z123CatDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z676CatDescripSinAc", Z676CatDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1894CatRelSec", GXutil.ltrim( localUtil.ntoc( Z1894CatRelSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O123CatDescrip", O123CatDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_41", GXutil.ltrim( localUtil.ntoc( nGXsfl_41_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_51", GXutil.ltrim( localUtil.ntoc( nGXsfl_51_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCATPAICOD_DATA", AV34CatPaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCATPAICOD_DATA", AV34CatPaiCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCATPROVCOD_DATA", AV35CatProvCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCATPROVCOD_DATA", AV35CatProvCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV9CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV30CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIPAICONVE", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV31CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV11EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVENIO", GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "vCATCODIGO", GXutil.rtrim( AV7CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7CatCodigo, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESSISTEMACONCEPTOSDEFAULT", AV37Essistemaconceptosdefault);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV33ClienteConveniador);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV32aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CATDESCRIPSINAC", A676CatDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV39Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "CATBASICO", GXutil.ltrim( localUtil.ntoc( A122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATVALORHORA", GXutil.ltrim( localUtil.ntoc( A731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATADICIONAL", GXutil.ltrim( localUtil.ntoc( A908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATADIHORA", GXutil.ltrim( localUtil.ntoc( A909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVRELREF", A2203CatProvRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVOLD", A2204CatProvOld);
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
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Objectcall", GXutil.rtrim( Combo_catpaicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Cls", GXutil.rtrim( Combo_catpaicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Enabled", GXutil.booltostr( Combo_catpaicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Titlecontrolidtoreplace", GXutil.rtrim( Combo_catpaicod_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Isgriditem", GXutil.booltostr( Combo_catpaicod_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Hasdescription", GXutil.booltostr( Combo_catpaicod_Hasdescription));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Datalistproc", GXutil.rtrim( Combo_catpaicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_catpaicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Emptyitem", GXutil.booltostr( Combo_catpaicod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Objectcall", GXutil.rtrim( Combo_catprovcod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Cls", GXutil.rtrim( Combo_catprovcod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Enabled", GXutil.booltostr( Combo_catprovcod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Titlecontrolidtoreplace", GXutil.rtrim( Combo_catprovcod_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Isgriditem", GXutil.booltostr( Combo_catprovcod_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Hasdescription", GXutil.booltostr( Combo_catprovcod_Hasdescription));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Datalistproc", GXutil.rtrim( Combo_catprovcod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_catprovcod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Emptyitem", GXutil.booltostr( Combo_catprovcod_Emptyitem));
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
      return formatLink("web.categoriaalta2", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV9CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV30CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV31CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV7CatCodigo))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CatCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "CategoriaAlta2" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Categoria Alta", "") ;
   }

   public void initializeNonKey2T205( )
   {
      AV32aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
      A123CatDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
      A676CatDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A676CatDescripSinAc", A676CatDescripSinAc);
      A1894CatRelSec = (short)(0) ;
      n1894CatRelSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1894CatRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1894CatRelSec), 4, 0));
      n1894CatRelSec = ((0==A1894CatRelSec) ? true : false) ;
      O123CatDescrip = A123CatDescrip ;
      httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
      Z123CatDescrip = "" ;
      Z676CatDescripSinAc = "" ;
      Z1894CatRelSec = (short)(0) ;
   }

   public void initAll2T205( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = new web.getconveniodefault(remoteHandle, context).executeUdp( AV9CliCod, AV11EmpCod, "") ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A8CatCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      initializeNonKey2T205( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey2T206( )
   {
      A122CatBasico = DecimalUtil.ZERO ;
      n122CatBasico = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A122CatBasico", GXutil.ltrimstr( A122CatBasico, 14, 2));
      A731CatValorHora = DecimalUtil.ZERO ;
      n731CatValorHora = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A731CatValorHora", GXutil.ltrimstr( A731CatValorHora, 14, 2));
      A908CatAdicional = DecimalUtil.ZERO ;
      n908CatAdicional = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A908CatAdicional", GXutil.ltrimstr( A908CatAdicional, 14, 2));
      A909CatAdiHora = DecimalUtil.ZERO ;
      n909CatAdiHora = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A909CatAdiHora", GXutil.ltrimstr( A909CatAdiHora, 14, 2));
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      A1891CatSalRelSec = 0 ;
      n1891CatSalRelSec = false ;
      O1892EscBasico = A1892EscBasico ;
      O1893EscAdicional = A1893EscAdicional ;
      Z122CatBasico = DecimalUtil.ZERO ;
      Z731CatValorHora = DecimalUtil.ZERO ;
      Z908CatAdicional = DecimalUtil.ZERO ;
      Z909CatAdiHora = DecimalUtil.ZERO ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      Z1893EscAdicional = DecimalUtil.ZERO ;
      Z1891CatSalRelSec = 0 ;
   }

   public void initAll2T206( )
   {
      A907CatVigencia = GXutil.nullDate() ;
      initializeNonKey2T206( ) ;
   }

   public void standaloneModalInsert2T206( )
   {
   }

   public void initializeNonKey2T274( )
   {
      A2202CatProvRelSec = 0 ;
      n2202CatProvRelSec = false ;
      A2203CatProvRelRef = "" ;
      n2203CatProvRelRef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2203CatProvRelRef", A2203CatProvRelRef);
      A2204CatProvOld = "" ;
      n2204CatProvOld = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2204CatProvOld", A2204CatProvOld);
      Z2202CatProvRelSec = 0 ;
      Z2203CatProvRelRef = "" ;
   }

   public void initAll2T274( )
   {
      A2200CatPaiCod = (short)(0) ;
      A2201CatProvCod = (short)(0) ;
      initializeNonKey2T274( ) ;
   }

   public void standaloneModalInsert2T274( )
   {
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713255752", true, true);
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
      httpContext.AddJavascriptSource("categoriaalta2.js", "?20251713255752", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties206( )
   {
      edtCatVigencia_Enabled = defedtCatVigencia_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_41_Refreshing);
   }

   public void init_level_properties274( )
   {
      edtCatProvCod_Enabled = defedtCatProvCod_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      edtCatPaiCod_Enabled = defedtCatPaiCod_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_51_Refreshing);
   }

   public void startgridcontrol41( )
   {
      Gridlevel_valoresContainer.AddObjectProperty("GridName", "Gridlevel_valores");
      Gridlevel_valoresContainer.AddObjectProperty("Header", subGridlevel_valores_Header);
      Gridlevel_valoresContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_valoresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_valoresContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_valoresColumn.AddObjectProperty("Value", localUtil.format(A907CatVigencia, "99/99/9999"));
      Gridlevel_valoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
      Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_valoresColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), ".", "")));
      Gridlevel_valoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
      Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_valoresColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), ".", "")));
      Gridlevel_valoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEscAdicional_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
      Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_valoresColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1891CatSalRelSec, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_valoresColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( dynCatSalRelSec.getVisible(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynCatSalRelSec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
      Gridlevel_valoresContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void startgridcontrol51( )
   {
      Gridlevel_provinciasContainer.AddObjectProperty("GridName", "Gridlevel_provincias");
      Gridlevel_provinciasContainer.AddObjectProperty("Header", subGridlevel_provincias_Header);
      Gridlevel_provinciasContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_provinciasContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_provincias_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_provinciasContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_provinciasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_provinciasColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2200CatPaiCod, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_provinciasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatPaiCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_provinciasColumn.AddObjectProperty("Horizontalalignment", GXutil.rtrim( edtCatPaiCod_Horizontalalignment));
      Gridlevel_provinciasContainer.AddColumnProperties(Gridlevel_provinciasColumn);
      Gridlevel_provinciasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_provinciasColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2201CatProvCod, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_provinciasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatProvCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_provinciasColumn.AddObjectProperty("Horizontalalignment", GXutil.rtrim( edtCatProvCod_Horizontalalignment));
      Gridlevel_provinciasContainer.AddColumnProperties(Gridlevel_provinciasColumn);
      Gridlevel_provinciasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_provinciasColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2202CatProvRelSec, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_provinciasColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( dynCatProvRelSec.getVisible(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_provinciasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynCatProvRelSec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddColumnProperties(Gridlevel_provinciasColumn);
      Gridlevel_provinciasContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_provincias_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_provincias_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_provincias_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_provincias_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_provincias_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_provincias_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_provinciasContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_provincias_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtCatCodigo_Internalname = "CATCODIGO" ;
      edtCatDescrip_Internalname = "CATDESCRIP" ;
      dynCatRelSec.setInternalname( "CATRELSEC" );
      divCatrelsec_cell_Internalname = "CATRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtCatVigencia_Internalname = "CATVIGENCIA" ;
      edtEscBasico_Internalname = "ESCBASICO" ;
      edtEscAdicional_Internalname = "ESCADICIONAL" ;
      dynCatSalRelSec.setInternalname( "CATSALRELSEC" );
      divTableleaflevel_valores_Internalname = "TABLELEAFLEVEL_VALORES" ;
      edtCatPaiCod_Internalname = "CATPAICOD" ;
      edtCatProvCod_Internalname = "CATPROVCOD" ;
      dynCatProvRelSec.setInternalname( "CATPROVRELSEC" );
      divTableleaflevel_provincias_Internalname = "TABLELEAFLEVEL_PROVINCIAS" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_catpaicod_Internalname = "COMBO_CATPAICOD" ;
      Combo_catprovcod_Internalname = "COMBO_CATPROVCOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_valores_Internalname = "GRIDLEVEL_VALORES" ;
      subGridlevel_provincias_Internalname = "GRIDLEVEL_PROVINCIAS" ;
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
      subGridlevel_provincias_Allowcollapsing = (byte)(0) ;
      subGridlevel_provincias_Allowselection = (byte)(0) ;
      subGridlevel_provincias_Header = "" ;
      subGridlevel_valores_Allowcollapsing = (byte)(0) ;
      subGridlevel_valores_Allowselection = (byte)(0) ;
      subGridlevel_valores_Header = "" ;
      Combo_catprovcod_Enabled = GXutil.toBoolean( -1) ;
      Combo_catpaicod_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Categoria Alta", "") );
      dynCatProvRelSec.setJsonclick( "" );
      edtCatProvCod_Jsonclick = "" ;
      edtCatPaiCod_Jsonclick = "" ;
      subGridlevel_provincias_Class = "WorkWith" ;
      subGridlevel_provincias_Backcolorstyle = (byte)(0) ;
      dynCatSalRelSec.setJsonclick( "" );
      edtEscAdicional_Jsonclick = "" ;
      edtEscBasico_Jsonclick = "" ;
      edtCatVigencia_Jsonclick = "" ;
      subGridlevel_valores_Class = "WorkWith" ;
      subGridlevel_valores_Backcolorstyle = (byte)(0) ;
      Combo_catprovcod_Datalistprocparametersprefix = "" ;
      Combo_catpaicod_Titlecontrolidtoreplace = "" ;
      Combo_catprovcod_Titlecontrolidtoreplace = "" ;
      Combo_catprovcod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_catprovcod_Datalistproc = "CategoriaAlta2LoadDVCombo" ;
      Combo_catprovcod_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_catprovcod_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_catprovcod_Cls = "ExtendedCombo" ;
      Combo_catprovcod_Caption = "" ;
      Combo_catpaicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_catpaicod_Datalistprocparametersprefix = " \"ComboName\": \"CatPaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"CatCodigo\": \"\"" ;
      Combo_catpaicod_Datalistproc = "CategoriaAlta2LoadDVCombo" ;
      Combo_catpaicod_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_catpaicod_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_catpaicod_Cls = "ExtendedCombo" ;
      Combo_catpaicod_Caption = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynCatProvRelSec.setEnabled( 1 );
      dynCatProvRelSec.setVisible( -1 );
      edtCatProvCod_Enabled = 1 ;
      edtCatPaiCod_Enabled = 1 ;
      dynCatSalRelSec.setEnabled( 1 );
      dynCatSalRelSec.setVisible( -1 );
      edtEscAdicional_Enabled = 1 ;
      edtEscBasico_Enabled = 1 ;
      edtCatVigencia_Enabled = 1 ;
      dynCatRelSec.setJsonclick( "" );
      dynCatRelSec.setEnabled( 1 );
      dynCatRelSec.setVisible( 1 );
      divCatrelsec_cell_Class = "col-xs-12" ;
      edtCatDescrip_Enabled = 1 ;
      edtCatCodigo_Jsonclick = "" ;
      edtCatCodigo_Enabled = 1 ;
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
      edtCatPaiCod_Horizontalalignment = "right" ;
      edtCatProvCod_Horizontalalignment = "right" ;
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

   public void gxdlacatrelsec2T205( int AV9CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacatrelsec_data2T205( AV9CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxacatrelsec_html2T205( int AV9CliCod )
   {
      int gxdynajaxvalue;
      gxdlacatrelsec_data2T205( AV9CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCatRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCatRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacatrelsec_data2T205( int AV9CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T002T32 */
      pr_default.execute(30, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(30) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T002T32_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T002T32_A1880CliReDTChar[0]);
         pr_default.readNext(30);
      }
      pr_default.close(30);
   }

   public void gxdlacatsalrelsec2T206( int AV9CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacatsalrelsec_data2T206( AV9CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxacatsalrelsec_html2T206( int AV9CliCod )
   {
      int gxdynajaxvalue;
      gxdlacatsalrelsec_data2T206( AV9CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCatSalRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCatSalRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacatsalrelsec_data2T206( int AV9CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T002T33 */
      pr_default.execute(31, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(31) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T002T33_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T002T33_A1880CliReDTChar[0]);
         pr_default.readNext(31);
      }
      pr_default.close(31);
   }

   public void gxdlacatprovrelsec2T274( int AV9CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacatprovrelsec_data2T274( AV9CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxacatprovrelsec_html2T274( int AV9CliCod )
   {
      int gxdynajaxvalue;
      gxdlacatprovrelsec_data2T274( AV9CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCatProvRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynCatProvRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacatprovrelsec_data2T274( int AV9CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T002T34 */
      pr_default.execute(32, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(32) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T002T34_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T002T34_A1880CliReDTChar[0]);
         pr_default.readNext(32);
      }
      pr_default.close(32);
   }

   public void gx2asaclipaiconve2T205( short AV30CliPaiConve ,
                                       int AV9CliCod )
   {
      if ( ! (0==AV30CliPaiConve) )
      {
         A1564CliPaiConve = AV30CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      else
      {
         GXt_int10 = A1564CliPaiConve ;
         GXv_int11[0] = GXt_int10 ;
         new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int11) ;
         categoriaalta2_impl.this.GXt_int10 = GXv_int11[0] ;
         A1564CliPaiConve = GXt_int10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx3asacliconvenio2T205( String AV31CliConvenio ,
                                       int AV9CliCod ,
                                       short AV11EmpCod ,
                                       byte Gx_BScreen )
   {
      if ( ! (GXutil.strcmp("", AV31CliConvenio)==0) )
      {
         A1565CliConvenio = AV31CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
         {
            GXt_char1 = A1565CliConvenio ;
            GXv_char2[0] = GXt_char1 ;
            new web.getconveniodefault(remoteHandle, context).execute( AV9CliCod, AV11EmpCod, "", GXv_char2) ;
            categoriaalta2_impl.this.GXt_char1 = GXv_char2[0] ;
            A1565CliConvenio = GXt_char1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1565CliConvenio))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_16_2T205( String Gx_mode ,
                            int AV9CliCod ,
                            short A1894CatRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV32aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV9CliCod, A1894CatRelSec, GXv_boolean7) ;
         AV32aplicadoHay = GXv_boolean7[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV32aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_21_2T206( String Gx_mode ,
                            int AV9CliCod ,
                            int A1891CatSalRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV32aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV9CliCod, A1891CatSalRelSec, GXv_boolean7) ;
         AV32aplicadoHay = GXv_boolean7[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV32aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_valores_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_41206( ) ;
      while ( nGXsfl_41_idx <= nRC_GXsfl_41 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal2T206( ) ;
         standaloneModal2T206( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow2T206( ) ;
         nGXsfl_41_idx = (int)(nGXsfl_41_idx+1) ;
         sGXsfl_41_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_41_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_41206( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_valoresContainer)) ;
      /* End function gxnrGridlevel_valores_newrow */
   }

   public void gxnrgridlevel_provincias_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_51274( ) ;
      while ( nGXsfl_51_idx <= nRC_GXsfl_51 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal2T274( ) ;
         standaloneModal2T274( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow2T274( ) ;
         nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_51274( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_provinciasContainer)) ;
      /* End function gxnrGridlevel_provincias_newrow */
   }

   public void init_web_controls( )
   {
      dynCatRelSec.setName( "CATRELSEC" );
      dynCatRelSec.setWebtags( "" );
      GXCCtl = "CATSALRELSEC_" + sGXsfl_41_idx ;
      dynCatSalRelSec.setName( GXCCtl );
      dynCatSalRelSec.setWebtags( "" );
      GXCCtl = "CATPROVRELSEC_" + sGXsfl_51_idx ;
      dynCatProvRelSec.setName( GXCCtl );
      dynCatProvRelSec.setWebtags( "" );
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

   public void valid_Catrelsec( )
   {
      n1894CatRelSec = false ;
      A1894CatRelSec = (short)(GXutil.lval( dynCatRelSec.getValue())) ;
      n1894CatRelSec = false ;
      n1891CatSalRelSec = false ;
      A1891CatSalRelSec = (int)(GXutil.lval( dynCatSalRelSec.getValue())) ;
      n1891CatSalRelSec = false ;
      n2202CatProvRelSec = false ;
      A2202CatProvRelSec = (int)(GXutil.lval( dynCatProvRelSec.getValue())) ;
      n2202CatProvRelSec = false ;
      if ( ( ( GXutil.strcmp(A123CatDescrip, O123CatDescrip) != 0 ) ) && (0==A1894CatRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CATRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV32aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV9CliCod, A1894CatRelSec, GXv_boolean7) ;
         categoriaalta2_impl.this.AV32aplicadoHay = GXv_boolean7[0] ;
         AV32aplicadoHay = this.AV32aplicadoHay ;
      }
      O123CatDescrip = A123CatDescrip ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
   }

   public void valid_Catsalrelsec( )
   {
      n1894CatRelSec = false ;
      A1894CatRelSec = (short)(GXutil.lval( dynCatRelSec.getValue())) ;
      n1894CatRelSec = false ;
      n1891CatSalRelSec = false ;
      A1891CatSalRelSec = (int)(GXutil.lval( dynCatSalRelSec.getValue())) ;
      n1891CatSalRelSec = false ;
      n2202CatProvRelSec = false ;
      A2202CatProvRelSec = (int)(GXutil.lval( dynCatProvRelSec.getValue())) ;
      n2202CatProvRelSec = false ;
      if ( ( !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) && (0==A1891CatSalRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CATSALRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatSalRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean7[0] = AV32aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV9CliCod, A1891CatSalRelSec, GXv_boolean7) ;
         categoriaalta2_impl.this.AV32aplicadoHay = GXv_boolean7[0] ;
         AV32aplicadoHay = this.AV32aplicadoHay ;
      }
      O907CatVigencia = A907CatVigencia ;
      O1892EscBasico = A1892EscBasico ;
      O1893EscAdicional = A1893EscAdicional ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV32aplicadoHay", AV32aplicadoHay);
   }

   public void valid_Catprovcod( )
   {
      n1894CatRelSec = false ;
      A1894CatRelSec = (short)(GXutil.lval( dynCatRelSec.getValue())) ;
      n1894CatRelSec = false ;
      n1891CatSalRelSec = false ;
      A1891CatSalRelSec = (int)(GXutil.lval( dynCatSalRelSec.getValue())) ;
      n1891CatSalRelSec = false ;
      n2202CatProvRelSec = false ;
      A2202CatProvRelSec = (int)(GXutil.lval( dynCatProvRelSec.getValue())) ;
      n2202CatProvRelSec = false ;
      /* Using cursor T002T35 */
      pr_default.execute(33, new Object[] {Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(33) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CATPROVCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
      }
      pr_default.close(33);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV30CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV31CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:'',hsh:true},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV30CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV31CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV7CatCodigo',fld:'vCATCODIGO',pic:'',hsh:true},{av:'A676CatDescripSinAc',fld:'CATDESCRIPSINAC',pic:''},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e122T2',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CATCODIGO","{handler:'valid_Catcodigo',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATCODIGO",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CATDESCRIP","{handler:'valid_Catdescrip',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATDESCRIP",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CATRELSEC","{handler:'valid_Catrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'O123CatDescrip'},{av:'A123CatDescrip',fld:'CATDESCRIP',pic:''},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'dynCatProvRelSec'},{av:'A2202CatProvRelSec',fld:'CATPROVRELSEC',pic:'ZZZZZ9'},{av:'AV32aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATRELSEC",",oparms:[{av:'AV32aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CATVIGENCIA","{handler:'valid_Catvigencia',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATVIGENCIA",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_ESCBASICO","{handler:'valid_Escbasico',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_ESCBASICO",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_ESCADICIONAL","{handler:'valid_Escadicional',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_ESCADICIONAL",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CATSALRELSEC","{handler:'valid_Catsalrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'O1893EscAdicional'},{av:'O1892EscBasico'},{av:'O907CatVigencia'},{av:'A907CatVigencia',fld:'CATVIGENCIA',pic:''},{av:'A1892EscBasico',fld:'ESCBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1893EscAdicional',fld:'ESCADICIONAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'dynCatProvRelSec'},{av:'A2202CatProvRelSec',fld:'CATPROVRELSEC',pic:'ZZZZZ9'},{av:'AV32aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATSALRELSEC",",oparms:[{av:'AV32aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CATPAICOD","{handler:'valid_Catpaicod',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATPAICOD",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CATPROVCOD","{handler:'valid_Catprovcod',iparms:[{av:'A2200CatPaiCod',fld:'CATPAICOD',pic:'ZZZ9'},{av:'A2201CatProvCod',fld:'CATPROVCOD',pic:'ZZZ9'},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'dynCatProvRelSec'},{av:'A2202CatProvRelSec',fld:'CATPROVRELSEC',pic:'ZZZZZ9'},{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATPROVCOD",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_CATPROVRELSEC","{handler:'valid_Catprovrelsec',iparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATPROVRELSEC",",oparms:[{av:'AV9CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatRelSec'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'}]}");
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
      return "categoria_Execute";
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
      pr_default.close(33);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV31CliConvenio = "" ;
      wcpOAV7CatCodigo = "" ;
      Z1565CliConvenio = "" ;
      Z8CatCodigo = "" ;
      Z123CatDescrip = "" ;
      Z676CatDescripSinAc = "" ;
      O123CatDescrip = "" ;
      Z907CatVigencia = GXutil.nullDate() ;
      Z122CatBasico = DecimalUtil.ZERO ;
      Z731CatValorHora = DecimalUtil.ZERO ;
      Z908CatAdicional = DecimalUtil.ZERO ;
      Z909CatAdiHora = DecimalUtil.ZERO ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      Z1893EscAdicional = DecimalUtil.ZERO ;
      O907CatVigencia = GXutil.nullDate() ;
      O1892EscBasico = DecimalUtil.ZERO ;
      O1893EscAdicional = DecimalUtil.ZERO ;
      Z2203CatProvRelRef = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV31CliConvenio = "" ;
      AV7CatCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A8CatCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A123CatDescrip = "" ;
      Gridlevel_valoresContainer = new com.genexus.webpanels.GXWebGrid(context);
      B123CatDescrip = "" ;
      sMode206 = "" ;
      Gridlevel_provinciasContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode274 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_catpaicod = new com.genexus.webpanels.GXUserControl();
      AV21DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV34CatPaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ucCombo_catprovcod = new com.genexus.webpanels.GXUserControl();
      AV35CatProvCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A676CatDescripSinAc = "" ;
      A1565CliConvenio = "" ;
      AV39Pgmname = "" ;
      A122CatBasico = DecimalUtil.ZERO ;
      A731CatValorHora = DecimalUtil.ZERO ;
      A908CatAdicional = DecimalUtil.ZERO ;
      A909CatAdiHora = DecimalUtil.ZERO ;
      A2203CatProvRelRef = "" ;
      A2204CatProvOld = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Combo_catpaicod_Objectcall = "" ;
      Combo_catpaicod_Class = "" ;
      Combo_catpaicod_Icontype = "" ;
      Combo_catpaicod_Icon = "" ;
      Combo_catpaicod_Tooltip = "" ;
      Combo_catpaicod_Selectedvalue_set = "" ;
      Combo_catpaicod_Selectedvalue_get = "" ;
      Combo_catpaicod_Selectedtext_set = "" ;
      Combo_catpaicod_Selectedtext_get = "" ;
      Combo_catpaicod_Gamoauthtoken = "" ;
      Combo_catpaicod_Ddointernalname = "" ;
      Combo_catpaicod_Titlecontrolalign = "" ;
      Combo_catpaicod_Dropdownoptionstype = "" ;
      Combo_catpaicod_Datalisttype = "" ;
      Combo_catpaicod_Datalistfixedvalues = "" ;
      Combo_catpaicod_Remoteservicesparameters = "" ;
      Combo_catpaicod_Htmltemplate = "" ;
      Combo_catpaicod_Multiplevaluestype = "" ;
      Combo_catpaicod_Loadingdata = "" ;
      Combo_catpaicod_Noresultsfound = "" ;
      Combo_catpaicod_Emptyitemtext = "" ;
      Combo_catpaicod_Onlyselectedvalues = "" ;
      Combo_catpaicod_Selectalltext = "" ;
      Combo_catpaicod_Multiplevaluesseparator = "" ;
      Combo_catpaicod_Addnewoptiontext = "" ;
      Combo_catprovcod_Objectcall = "" ;
      Combo_catprovcod_Class = "" ;
      Combo_catprovcod_Icontype = "" ;
      Combo_catprovcod_Icon = "" ;
      Combo_catprovcod_Tooltip = "" ;
      Combo_catprovcod_Selectedvalue_set = "" ;
      Combo_catprovcod_Selectedvalue_get = "" ;
      Combo_catprovcod_Selectedtext_set = "" ;
      Combo_catprovcod_Selectedtext_get = "" ;
      Combo_catprovcod_Gamoauthtoken = "" ;
      Combo_catprovcod_Ddointernalname = "" ;
      Combo_catprovcod_Titlecontrolalign = "" ;
      Combo_catprovcod_Dropdownoptionstype = "" ;
      Combo_catprovcod_Datalisttype = "" ;
      Combo_catprovcod_Datalistfixedvalues = "" ;
      Combo_catprovcod_Remoteservicesparameters = "" ;
      Combo_catprovcod_Htmltemplate = "" ;
      Combo_catprovcod_Multiplevaluestype = "" ;
      Combo_catprovcod_Loadingdata = "" ;
      Combo_catprovcod_Noresultsfound = "" ;
      Combo_catprovcod_Emptyitemtext = "" ;
      Combo_catprovcod_Onlyselectedvalues = "" ;
      Combo_catprovcod_Selectalltext = "" ;
      Combo_catprovcod_Multiplevaluesseparator = "" ;
      Combo_catprovcod_Addnewoptiontext = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode205 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      T907CatVigencia = GXutil.nullDate() ;
      T1892EscBasico = DecimalUtil.ZERO ;
      T1893EscAdicional = DecimalUtil.ZERO ;
      AV16WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      GXv_int9 = new int[1] ;
      AV17SinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_objcol_char12 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char13 = new GXSimpleCollection[1] ;
      T002T9_A3CliCod = new int[1] ;
      T002T10_A8CatCodigo = new String[] {""} ;
      T002T10_A123CatDescrip = new String[] {""} ;
      T002T10_A676CatDescripSinAc = new String[] {""} ;
      T002T10_A1894CatRelSec = new short[1] ;
      T002T10_n1894CatRelSec = new boolean[] {false} ;
      T002T10_A3CliCod = new int[1] ;
      T002T10_A1564CliPaiConve = new short[1] ;
      T002T10_A1565CliConvenio = new String[] {""} ;
      T002T11_A3CliCod = new int[1] ;
      T002T11_A1564CliPaiConve = new short[1] ;
      T002T11_A1565CliConvenio = new String[] {""} ;
      T002T11_A8CatCodigo = new String[] {""} ;
      T002T8_A8CatCodigo = new String[] {""} ;
      T002T8_A123CatDescrip = new String[] {""} ;
      T002T8_A676CatDescripSinAc = new String[] {""} ;
      T002T8_A1894CatRelSec = new short[1] ;
      T002T8_n1894CatRelSec = new boolean[] {false} ;
      T002T8_A3CliCod = new int[1] ;
      T002T8_A1564CliPaiConve = new short[1] ;
      T002T8_A1565CliConvenio = new String[] {""} ;
      T002T12_A3CliCod = new int[1] ;
      T002T12_A1564CliPaiConve = new short[1] ;
      T002T12_A1565CliConvenio = new String[] {""} ;
      T002T12_A8CatCodigo = new String[] {""} ;
      T002T13_A3CliCod = new int[1] ;
      T002T13_A1564CliPaiConve = new short[1] ;
      T002T13_A1565CliConvenio = new String[] {""} ;
      T002T13_A8CatCodigo = new String[] {""} ;
      T002T7_A8CatCodigo = new String[] {""} ;
      T002T7_A123CatDescrip = new String[] {""} ;
      T002T7_A676CatDescripSinAc = new String[] {""} ;
      T002T7_A1894CatRelSec = new short[1] ;
      T002T7_n1894CatRelSec = new boolean[] {false} ;
      T002T7_A3CliCod = new int[1] ;
      T002T7_A1564CliPaiConve = new short[1] ;
      T002T7_A1565CliConvenio = new String[] {""} ;
      T002T17_A3CliCod = new int[1] ;
      T002T17_A1EmpCod = new short[1] ;
      T002T17_A31LiqNro = new int[1] ;
      T002T17_A2142LiqPaiConve = new short[1] ;
      T002T17_A2143LiqConvenio = new String[] {""} ;
      T002T17_A2144LiqCatCodigo = new String[] {""} ;
      T002T18_A3CliCod = new int[1] ;
      T002T18_A1564CliPaiConve = new short[1] ;
      T002T18_A1565CliConvenio = new String[] {""} ;
      T002T18_A8CatCodigo = new String[] {""} ;
      T002T19_A3CliCod = new int[1] ;
      T002T19_A1565CliConvenio = new String[] {""} ;
      T002T19_A8CatCodigo = new String[] {""} ;
      T002T19_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T002T19_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T19_n122CatBasico = new boolean[] {false} ;
      T002T19_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T19_n731CatValorHora = new boolean[] {false} ;
      T002T19_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T19_n908CatAdicional = new boolean[] {false} ;
      T002T19_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T19_n909CatAdiHora = new boolean[] {false} ;
      T002T19_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T19_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T19_A1891CatSalRelSec = new int[1] ;
      T002T19_n1891CatSalRelSec = new boolean[] {false} ;
      T002T19_A1564CliPaiConve = new short[1] ;
      T002T20_A3CliCod = new int[1] ;
      T002T20_A1564CliPaiConve = new short[1] ;
      T002T20_A1565CliConvenio = new String[] {""} ;
      T002T20_A8CatCodigo = new String[] {""} ;
      T002T20_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T002T6_A3CliCod = new int[1] ;
      T002T6_A1565CliConvenio = new String[] {""} ;
      T002T6_A8CatCodigo = new String[] {""} ;
      T002T6_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T002T6_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T6_n122CatBasico = new boolean[] {false} ;
      T002T6_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T6_n731CatValorHora = new boolean[] {false} ;
      T002T6_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T6_n908CatAdicional = new boolean[] {false} ;
      T002T6_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T6_n909CatAdiHora = new boolean[] {false} ;
      T002T6_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T6_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T6_A1891CatSalRelSec = new int[1] ;
      T002T6_n1891CatSalRelSec = new boolean[] {false} ;
      T002T6_A1564CliPaiConve = new short[1] ;
      T002T5_A3CliCod = new int[1] ;
      T002T5_A1565CliConvenio = new String[] {""} ;
      T002T5_A8CatCodigo = new String[] {""} ;
      T002T5_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T002T5_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T5_n122CatBasico = new boolean[] {false} ;
      T002T5_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T5_n731CatValorHora = new boolean[] {false} ;
      T002T5_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T5_n908CatAdicional = new boolean[] {false} ;
      T002T5_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T5_n909CatAdiHora = new boolean[] {false} ;
      T002T5_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T5_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002T5_A1891CatSalRelSec = new int[1] ;
      T002T5_n1891CatSalRelSec = new boolean[] {false} ;
      T002T5_A1564CliPaiConve = new short[1] ;
      T002T24_A3CliCod = new int[1] ;
      T002T24_A1564CliPaiConve = new short[1] ;
      T002T24_A1565CliConvenio = new String[] {""} ;
      T002T24_A8CatCodigo = new String[] {""} ;
      T002T24_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      Z2204CatProvOld = "" ;
      T002T25_A3CliCod = new int[1] ;
      T002T25_A1565CliConvenio = new String[] {""} ;
      T002T25_A8CatCodigo = new String[] {""} ;
      T002T25_A2202CatProvRelSec = new int[1] ;
      T002T25_n2202CatProvRelSec = new boolean[] {false} ;
      T002T25_A2203CatProvRelRef = new String[] {""} ;
      T002T25_n2203CatProvRelRef = new boolean[] {false} ;
      T002T25_A2204CatProvOld = new String[] {""} ;
      T002T25_n2204CatProvOld = new boolean[] {false} ;
      T002T25_A2200CatPaiCod = new short[1] ;
      T002T25_A2201CatProvCod = new short[1] ;
      T002T25_A1564CliPaiConve = new short[1] ;
      T002T4_A2200CatPaiCod = new short[1] ;
      T002T26_A2200CatPaiCod = new short[1] ;
      T002T27_A3CliCod = new int[1] ;
      T002T27_A1564CliPaiConve = new short[1] ;
      T002T27_A1565CliConvenio = new String[] {""} ;
      T002T27_A8CatCodigo = new String[] {""} ;
      T002T27_A2200CatPaiCod = new short[1] ;
      T002T27_A2201CatProvCod = new short[1] ;
      T002T3_A3CliCod = new int[1] ;
      T002T3_A1565CliConvenio = new String[] {""} ;
      T002T3_A8CatCodigo = new String[] {""} ;
      T002T3_A2202CatProvRelSec = new int[1] ;
      T002T3_n2202CatProvRelSec = new boolean[] {false} ;
      T002T3_A2203CatProvRelRef = new String[] {""} ;
      T002T3_n2203CatProvRelRef = new boolean[] {false} ;
      T002T3_A2204CatProvOld = new String[] {""} ;
      T002T3_n2204CatProvOld = new boolean[] {false} ;
      T002T3_A2200CatPaiCod = new short[1] ;
      T002T3_A2201CatProvCod = new short[1] ;
      T002T3_A1564CliPaiConve = new short[1] ;
      T002T2_A3CliCod = new int[1] ;
      T002T2_A1565CliConvenio = new String[] {""} ;
      T002T2_A8CatCodigo = new String[] {""} ;
      T002T2_A2202CatProvRelSec = new int[1] ;
      T002T2_n2202CatProvRelSec = new boolean[] {false} ;
      T002T2_A2203CatProvRelRef = new String[] {""} ;
      T002T2_n2203CatProvRelRef = new boolean[] {false} ;
      T002T2_A2204CatProvOld = new String[] {""} ;
      T002T2_n2204CatProvOld = new boolean[] {false} ;
      T002T2_A2200CatPaiCod = new short[1] ;
      T002T2_A2201CatProvCod = new short[1] ;
      T002T2_A1564CliPaiConve = new short[1] ;
      T002T31_A3CliCod = new int[1] ;
      T002T31_A1564CliPaiConve = new short[1] ;
      T002T31_A1565CliConvenio = new String[] {""} ;
      T002T31_A8CatCodigo = new String[] {""} ;
      T002T31_A2200CatPaiCod = new short[1] ;
      T002T31_A2201CatProvCod = new short[1] ;
      Gridlevel_valoresRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_valores_Linesclass = "" ;
      ROClassString = "" ;
      Gridlevel_provinciasRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_provincias_Linesclass = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_valoresColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_provinciasColumn = new com.genexus.webpanels.GXWebColumn();
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T002T32_A3CliCod = new int[1] ;
      T002T32_A1885CliRelSec = new int[1] ;
      T002T32_A1880CliReDTChar = new String[] {""} ;
      T002T33_A3CliCod = new int[1] ;
      T002T33_A1885CliRelSec = new int[1] ;
      T002T33_A1880CliReDTChar = new String[] {""} ;
      T002T34_A3CliCod = new int[1] ;
      T002T34_A1885CliRelSec = new int[1] ;
      T002T34_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new short[1] ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_boolean7 = new boolean[1] ;
      T002T35_A2200CatPaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.categoriaalta2__default(),
         new Object[] {
             new Object[] {
            T002T2_A3CliCod, T002T2_A1565CliConvenio, T002T2_A8CatCodigo, T002T2_A2202CatProvRelSec, T002T2_n2202CatProvRelSec, T002T2_A2203CatProvRelRef, T002T2_n2203CatProvRelRef, T002T2_A2204CatProvOld, T002T2_n2204CatProvOld, T002T2_A2200CatPaiCod,
            T002T2_A2201CatProvCod, T002T2_A1564CliPaiConve
            }
            , new Object[] {
            T002T3_A3CliCod, T002T3_A1565CliConvenio, T002T3_A8CatCodigo, T002T3_A2202CatProvRelSec, T002T3_n2202CatProvRelSec, T002T3_A2203CatProvRelRef, T002T3_n2203CatProvRelRef, T002T3_A2204CatProvOld, T002T3_n2204CatProvOld, T002T3_A2200CatPaiCod,
            T002T3_A2201CatProvCod, T002T3_A1564CliPaiConve
            }
            , new Object[] {
            T002T4_A2200CatPaiCod
            }
            , new Object[] {
            T002T5_A3CliCod, T002T5_A1565CliConvenio, T002T5_A8CatCodigo, T002T5_A907CatVigencia, T002T5_A122CatBasico, T002T5_n122CatBasico, T002T5_A731CatValorHora, T002T5_n731CatValorHora, T002T5_A908CatAdicional, T002T5_n908CatAdicional,
            T002T5_A909CatAdiHora, T002T5_n909CatAdiHora, T002T5_A1892EscBasico, T002T5_A1893EscAdicional, T002T5_A1891CatSalRelSec, T002T5_n1891CatSalRelSec, T002T5_A1564CliPaiConve
            }
            , new Object[] {
            T002T6_A3CliCod, T002T6_A1565CliConvenio, T002T6_A8CatCodigo, T002T6_A907CatVigencia, T002T6_A122CatBasico, T002T6_n122CatBasico, T002T6_A731CatValorHora, T002T6_n731CatValorHora, T002T6_A908CatAdicional, T002T6_n908CatAdicional,
            T002T6_A909CatAdiHora, T002T6_n909CatAdiHora, T002T6_A1892EscBasico, T002T6_A1893EscAdicional, T002T6_A1891CatSalRelSec, T002T6_n1891CatSalRelSec, T002T6_A1564CliPaiConve
            }
            , new Object[] {
            T002T7_A8CatCodigo, T002T7_A123CatDescrip, T002T7_A676CatDescripSinAc, T002T7_A1894CatRelSec, T002T7_n1894CatRelSec, T002T7_A3CliCod, T002T7_A1564CliPaiConve, T002T7_A1565CliConvenio
            }
            , new Object[] {
            T002T8_A8CatCodigo, T002T8_A123CatDescrip, T002T8_A676CatDescripSinAc, T002T8_A1894CatRelSec, T002T8_n1894CatRelSec, T002T8_A3CliCod, T002T8_A1564CliPaiConve, T002T8_A1565CliConvenio
            }
            , new Object[] {
            T002T9_A3CliCod
            }
            , new Object[] {
            T002T10_A8CatCodigo, T002T10_A123CatDescrip, T002T10_A676CatDescripSinAc, T002T10_A1894CatRelSec, T002T10_n1894CatRelSec, T002T10_A3CliCod, T002T10_A1564CliPaiConve, T002T10_A1565CliConvenio
            }
            , new Object[] {
            T002T11_A3CliCod, T002T11_A1564CliPaiConve, T002T11_A1565CliConvenio, T002T11_A8CatCodigo
            }
            , new Object[] {
            T002T12_A3CliCod, T002T12_A1564CliPaiConve, T002T12_A1565CliConvenio, T002T12_A8CatCodigo
            }
            , new Object[] {
            T002T13_A3CliCod, T002T13_A1564CliPaiConve, T002T13_A1565CliConvenio, T002T13_A8CatCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002T17_A3CliCod, T002T17_A1EmpCod, T002T17_A31LiqNro, T002T17_A2142LiqPaiConve, T002T17_A2143LiqConvenio, T002T17_A2144LiqCatCodigo
            }
            , new Object[] {
            T002T18_A3CliCod, T002T18_A1564CliPaiConve, T002T18_A1565CliConvenio, T002T18_A8CatCodigo
            }
            , new Object[] {
            T002T19_A3CliCod, T002T19_A1565CliConvenio, T002T19_A8CatCodigo, T002T19_A907CatVigencia, T002T19_A122CatBasico, T002T19_n122CatBasico, T002T19_A731CatValorHora, T002T19_n731CatValorHora, T002T19_A908CatAdicional, T002T19_n908CatAdicional,
            T002T19_A909CatAdiHora, T002T19_n909CatAdiHora, T002T19_A1892EscBasico, T002T19_A1893EscAdicional, T002T19_A1891CatSalRelSec, T002T19_n1891CatSalRelSec, T002T19_A1564CliPaiConve
            }
            , new Object[] {
            T002T20_A3CliCod, T002T20_A1564CliPaiConve, T002T20_A1565CliConvenio, T002T20_A8CatCodigo, T002T20_A907CatVigencia
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002T24_A3CliCod, T002T24_A1564CliPaiConve, T002T24_A1565CliConvenio, T002T24_A8CatCodigo, T002T24_A907CatVigencia
            }
            , new Object[] {
            T002T25_A3CliCod, T002T25_A1565CliConvenio, T002T25_A8CatCodigo, T002T25_A2202CatProvRelSec, T002T25_n2202CatProvRelSec, T002T25_A2203CatProvRelRef, T002T25_n2203CatProvRelRef, T002T25_A2204CatProvOld, T002T25_n2204CatProvOld, T002T25_A2200CatPaiCod,
            T002T25_A2201CatProvCod, T002T25_A1564CliPaiConve
            }
            , new Object[] {
            T002T26_A2200CatPaiCod
            }
            , new Object[] {
            T002T27_A3CliCod, T002T27_A1564CliPaiConve, T002T27_A1565CliConvenio, T002T27_A8CatCodigo, T002T27_A2200CatPaiCod, T002T27_A2201CatProvCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002T31_A3CliCod, T002T31_A1564CliPaiConve, T002T31_A1565CliConvenio, T002T31_A8CatCodigo, T002T31_A2200CatPaiCod, T002T31_A2201CatProvCod
            }
            , new Object[] {
            T002T32_A3CliCod, T002T32_A1885CliRelSec, T002T32_A1880CliReDTChar
            }
            , new Object[] {
            T002T33_A3CliCod, T002T33_A1885CliRelSec, T002T33_A1880CliReDTChar
            }
            , new Object[] {
            T002T34_A3CliCod, T002T34_A1885CliRelSec, T002T34_A1880CliReDTChar
            }
            , new Object[] {
            T002T35_A2200CatPaiCod
            }
         }
      );
      AV39Pgmname = "CategoriaAlta2" ;
      Z1565CliConvenio = "" ;
      A1565CliConvenio = "" ;
   }

   private byte GxWebError ;
   private byte Gx_BScreen ;
   private byte nKeyPressed ;
   private byte subGridlevel_valores_Backcolorstyle ;
   private byte subGridlevel_valores_Backstyle ;
   private byte subGridlevel_provincias_Backcolorstyle ;
   private byte subGridlevel_provincias_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_valores_Allowselection ;
   private byte subGridlevel_valores_Allowhovering ;
   private byte subGridlevel_valores_Allowcollapsing ;
   private byte subGridlevel_valores_Collapsed ;
   private byte subGridlevel_provincias_Allowselection ;
   private byte subGridlevel_provincias_Allowhovering ;
   private byte subGridlevel_provincias_Allowcollapsing ;
   private byte subGridlevel_provincias_Collapsed ;
   private short wcpOAV30CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short Z1894CatRelSec ;
   private short nRcdDeleted_206 ;
   private short nRcdExists_206 ;
   private short nIsMod_206 ;
   private short Z2200CatPaiCod ;
   private short Z2201CatProvCod ;
   private short O2200CatPaiCod ;
   private short O2201CatProvCod ;
   private short nRcdDeleted_274 ;
   private short nRcdExists_274 ;
   private short nIsMod_274 ;
   private short A1894CatRelSec ;
   private short AV30CliPaiConve ;
   private short AV11EmpCod ;
   private short A2200CatPaiCod ;
   private short A2201CatProvCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount206 ;
   private short RcdFound206 ;
   private short nBlankRcdUsr206 ;
   private short nBlankRcdCount274 ;
   private short RcdFound274 ;
   private short nBlankRcdUsr274 ;
   private short A1564CliPaiConve ;
   private short RcdFound205 ;
   private short T2200CatPaiCod ;
   private short T2201CatProvCod ;
   private short nIsDirty_205 ;
   private short nIsDirty_206 ;
   private short nIsDirty_274 ;
   private short GXt_int10 ;
   private short GXv_int11[] ;
   private int wcpOAV9CliCod ;
   private int Z3CliCod ;
   private int nRC_GXsfl_41 ;
   private int nGXsfl_41_idx=1 ;
   private int nRC_GXsfl_51 ;
   private int nGXsfl_51_idx=1 ;
   private int Z1891CatSalRelSec ;
   private int Z2202CatProvRelSec ;
   private int AV9CliCod ;
   private int A1891CatSalRelSec ;
   private int trnEnded ;
   private int A3CliCod ;
   private int edtCatCodigo_Enabled ;
   private int edtCatDescrip_Enabled ;
   private int edtCatVigencia_Enabled ;
   private int edtEscBasico_Enabled ;
   private int edtEscAdicional_Enabled ;
   private int fRowAdded ;
   private int edtCatPaiCod_Enabled ;
   private int edtCatProvCod_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Combo_catpaicod_Datalistupdateminimumcharacters ;
   private int Combo_catpaicod_Gxcontroltype ;
   private int Combo_catprovcod_Datalistupdateminimumcharacters ;
   private int Combo_catprovcod_Gxcontroltype ;
   private int A2202CatProvRelSec ;
   private int GXt_int8 ;
   private int GXv_int9[] ;
   private int GX_JID ;
   private int subGridlevel_valores_Backcolor ;
   private int subGridlevel_valores_Allbackcolor ;
   private int subGridlevel_provincias_Backcolor ;
   private int subGridlevel_provincias_Allbackcolor ;
   private int defedtCatProvCod_Enabled ;
   private int defedtCatPaiCod_Enabled ;
   private int defedtCatVigencia_Enabled ;
   private int idxLst ;
   private int subGridlevel_valores_Selectedindex ;
   private int subGridlevel_valores_Selectioncolor ;
   private int subGridlevel_valores_Hoveringcolor ;
   private int subGridlevel_provincias_Selectedindex ;
   private int subGridlevel_provincias_Selectioncolor ;
   private int subGridlevel_provincias_Hoveringcolor ;
   private int gxdynajaxindex ;
   private long GRIDLEVEL_VALORES_nFirstRecordOnPage ;
   private long GRIDLEVEL_PROVINCIAS_nFirstRecordOnPage ;
   private java.math.BigDecimal Z122CatBasico ;
   private java.math.BigDecimal Z731CatValorHora ;
   private java.math.BigDecimal Z908CatAdicional ;
   private java.math.BigDecimal Z909CatAdiHora ;
   private java.math.BigDecimal Z1892EscBasico ;
   private java.math.BigDecimal Z1893EscAdicional ;
   private java.math.BigDecimal O1892EscBasico ;
   private java.math.BigDecimal O1893EscAdicional ;
   private java.math.BigDecimal A122CatBasico ;
   private java.math.BigDecimal A731CatValorHora ;
   private java.math.BigDecimal A908CatAdicional ;
   private java.math.BigDecimal A909CatAdiHora ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private java.math.BigDecimal T1892EscBasico ;
   private java.math.BigDecimal T1893EscAdicional ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV31CliConvenio ;
   private String wcpOAV7CatCodigo ;
   private String Z1565CliConvenio ;
   private String Z8CatCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV31CliConvenio ;
   private String AV7CatCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCatCodigo_Internalname ;
   private String sGXsfl_41_idx="0001" ;
   private String sGXsfl_51_idx="0001" ;
   private String edtCatProvCod_Horizontalalignment ;
   private String edtCatProvCod_Internalname ;
   private String edtCatPaiCod_Horizontalalignment ;
   private String edtCatPaiCod_Internalname ;
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
   private String A8CatCodigo ;
   private String edtCatCodigo_Jsonclick ;
   private String edtCatDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divCatrelsec_cell_Internalname ;
   private String divCatrelsec_cell_Class ;
   private String divTableleaflevel_valores_Internalname ;
   private String sMode206 ;
   private String edtCatVigencia_Internalname ;
   private String edtEscBasico_Internalname ;
   private String edtEscAdicional_Internalname ;
   private String subGridlevel_valores_Internalname ;
   private String divTableleaflevel_provincias_Internalname ;
   private String sMode274 ;
   private String subGridlevel_provincias_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_catpaicod_Caption ;
   private String Combo_catpaicod_Cls ;
   private String Combo_catpaicod_Datalistproc ;
   private String Combo_catpaicod_Datalistprocparametersprefix ;
   private String Combo_catpaicod_Internalname ;
   private String Combo_catprovcod_Caption ;
   private String Combo_catprovcod_Cls ;
   private String Combo_catprovcod_Datalistproc ;
   private String Combo_catprovcod_Internalname ;
   private String A1565CliConvenio ;
   private String AV39Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Combo_catpaicod_Objectcall ;
   private String Combo_catpaicod_Class ;
   private String Combo_catpaicod_Icontype ;
   private String Combo_catpaicod_Icon ;
   private String Combo_catpaicod_Tooltip ;
   private String Combo_catpaicod_Selectedvalue_set ;
   private String Combo_catpaicod_Selectedvalue_get ;
   private String Combo_catpaicod_Selectedtext_set ;
   private String Combo_catpaicod_Selectedtext_get ;
   private String Combo_catpaicod_Gamoauthtoken ;
   private String Combo_catpaicod_Ddointernalname ;
   private String Combo_catpaicod_Titlecontrolalign ;
   private String Combo_catpaicod_Dropdownoptionstype ;
   private String Combo_catpaicod_Titlecontrolidtoreplace ;
   private String Combo_catpaicod_Datalisttype ;
   private String Combo_catpaicod_Datalistfixedvalues ;
   private String Combo_catpaicod_Remoteservicesparameters ;
   private String Combo_catpaicod_Htmltemplate ;
   private String Combo_catpaicod_Multiplevaluestype ;
   private String Combo_catpaicod_Loadingdata ;
   private String Combo_catpaicod_Noresultsfound ;
   private String Combo_catpaicod_Emptyitemtext ;
   private String Combo_catpaicod_Onlyselectedvalues ;
   private String Combo_catpaicod_Selectalltext ;
   private String Combo_catpaicod_Multiplevaluesseparator ;
   private String Combo_catpaicod_Addnewoptiontext ;
   private String Combo_catprovcod_Objectcall ;
   private String Combo_catprovcod_Class ;
   private String Combo_catprovcod_Icontype ;
   private String Combo_catprovcod_Icon ;
   private String Combo_catprovcod_Tooltip ;
   private String Combo_catprovcod_Selectedvalue_set ;
   private String Combo_catprovcod_Selectedvalue_get ;
   private String Combo_catprovcod_Selectedtext_set ;
   private String Combo_catprovcod_Selectedtext_get ;
   private String Combo_catprovcod_Gamoauthtoken ;
   private String Combo_catprovcod_Ddointernalname ;
   private String Combo_catprovcod_Titlecontrolalign ;
   private String Combo_catprovcod_Dropdownoptionstype ;
   private String Combo_catprovcod_Titlecontrolidtoreplace ;
   private String Combo_catprovcod_Datalisttype ;
   private String Combo_catprovcod_Datalistfixedvalues ;
   private String Combo_catprovcod_Datalistprocparametersprefix ;
   private String Combo_catprovcod_Remoteservicesparameters ;
   private String Combo_catprovcod_Htmltemplate ;
   private String Combo_catprovcod_Multiplevaluestype ;
   private String Combo_catprovcod_Loadingdata ;
   private String Combo_catprovcod_Noresultsfound ;
   private String Combo_catprovcod_Emptyitemtext ;
   private String Combo_catprovcod_Onlyselectedvalues ;
   private String Combo_catprovcod_Selectalltext ;
   private String Combo_catprovcod_Multiplevaluesseparator ;
   private String Combo_catprovcod_Addnewoptiontext ;
   private String hsh ;
   private String sMode205 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_41_fel_idx="0001" ;
   private String subGridlevel_valores_Class ;
   private String subGridlevel_valores_Linesclass ;
   private String ROClassString ;
   private String edtCatVigencia_Jsonclick ;
   private String edtEscBasico_Jsonclick ;
   private String edtEscAdicional_Jsonclick ;
   private String sGXsfl_51_fel_idx="0001" ;
   private String subGridlevel_provincias_Class ;
   private String subGridlevel_provincias_Linesclass ;
   private String edtCatPaiCod_Jsonclick ;
   private String edtCatProvCod_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_valores_Header ;
   private String subGridlevel_provincias_Header ;
   private String gxwrpcisep ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date Z907CatVigencia ;
   private java.util.Date O907CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private java.util.Date T907CatVigencia ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1894CatRelSec ;
   private boolean n1891CatSalRelSec ;
   private boolean wbErr ;
   private boolean bGXsfl_51_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_41_Refreshing=false ;
   private boolean Combo_catpaicod_Isgriditem ;
   private boolean Combo_catpaicod_Hasdescription ;
   private boolean Combo_catpaicod_Emptyitem ;
   private boolean Combo_catprovcod_Isgriditem ;
   private boolean Combo_catprovcod_Hasdescription ;
   private boolean Combo_catprovcod_Emptyitem ;
   private boolean AV37Essistemaconceptosdefault ;
   private boolean AV33ClienteConveniador ;
   private boolean AV32aplicadoHay ;
   private boolean n122CatBasico ;
   private boolean n731CatValorHora ;
   private boolean n908CatAdicional ;
   private boolean n909CatAdiHora ;
   private boolean n2203CatProvRelRef ;
   private boolean n2204CatProvOld ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Combo_catpaicod_Enabled ;
   private boolean Combo_catpaicod_Visible ;
   private boolean Combo_catpaicod_Allowmultipleselection ;
   private boolean Combo_catpaicod_Includeonlyselectedoption ;
   private boolean Combo_catpaicod_Includeselectalloption ;
   private boolean Combo_catpaicod_Includeaddnewoption ;
   private boolean Combo_catprovcod_Enabled ;
   private boolean Combo_catprovcod_Visible ;
   private boolean Combo_catprovcod_Allowmultipleselection ;
   private boolean Combo_catprovcod_Includeonlyselectedoption ;
   private boolean Combo_catprovcod_Includeselectalloption ;
   private boolean Combo_catprovcod_Includeaddnewoption ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean Gx_longc ;
   private boolean n2202CatProvRelSec ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean ZV32aplicadoHay ;
   private boolean GXv_boolean7[] ;
   private String A2204CatProvOld ;
   private String Z2204CatProvOld ;
   private String Z123CatDescrip ;
   private String Z676CatDescripSinAc ;
   private String O123CatDescrip ;
   private String Z2203CatProvRelRef ;
   private String A123CatDescrip ;
   private String B123CatDescrip ;
   private String A676CatDescripSinAc ;
   private String A2203CatProvRelRef ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_valoresContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_provinciasContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_valoresRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_provinciasRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_valoresColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_provinciasColumn ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_catpaicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_catprovcod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynCatRelSec ;
   private HTMLChoice dynCatSalRelSec ;
   private HTMLChoice dynCatProvRelSec ;
   private IDataStoreProvider pr_default ;
   private int[] T002T9_A3CliCod ;
   private String[] T002T10_A8CatCodigo ;
   private String[] T002T10_A123CatDescrip ;
   private String[] T002T10_A676CatDescripSinAc ;
   private short[] T002T10_A1894CatRelSec ;
   private boolean[] T002T10_n1894CatRelSec ;
   private int[] T002T10_A3CliCod ;
   private short[] T002T10_A1564CliPaiConve ;
   private String[] T002T10_A1565CliConvenio ;
   private int[] T002T11_A3CliCod ;
   private short[] T002T11_A1564CliPaiConve ;
   private String[] T002T11_A1565CliConvenio ;
   private String[] T002T11_A8CatCodigo ;
   private String[] T002T8_A8CatCodigo ;
   private String[] T002T8_A123CatDescrip ;
   private String[] T002T8_A676CatDescripSinAc ;
   private short[] T002T8_A1894CatRelSec ;
   private boolean[] T002T8_n1894CatRelSec ;
   private int[] T002T8_A3CliCod ;
   private short[] T002T8_A1564CliPaiConve ;
   private String[] T002T8_A1565CliConvenio ;
   private int[] T002T12_A3CliCod ;
   private short[] T002T12_A1564CliPaiConve ;
   private String[] T002T12_A1565CliConvenio ;
   private String[] T002T12_A8CatCodigo ;
   private int[] T002T13_A3CliCod ;
   private short[] T002T13_A1564CliPaiConve ;
   private String[] T002T13_A1565CliConvenio ;
   private String[] T002T13_A8CatCodigo ;
   private String[] T002T7_A8CatCodigo ;
   private String[] T002T7_A123CatDescrip ;
   private String[] T002T7_A676CatDescripSinAc ;
   private short[] T002T7_A1894CatRelSec ;
   private boolean[] T002T7_n1894CatRelSec ;
   private int[] T002T7_A3CliCod ;
   private short[] T002T7_A1564CliPaiConve ;
   private String[] T002T7_A1565CliConvenio ;
   private int[] T002T17_A3CliCod ;
   private short[] T002T17_A1EmpCod ;
   private int[] T002T17_A31LiqNro ;
   private short[] T002T17_A2142LiqPaiConve ;
   private String[] T002T17_A2143LiqConvenio ;
   private String[] T002T17_A2144LiqCatCodigo ;
   private int[] T002T18_A3CliCod ;
   private short[] T002T18_A1564CliPaiConve ;
   private String[] T002T18_A1565CliConvenio ;
   private String[] T002T18_A8CatCodigo ;
   private int[] T002T19_A3CliCod ;
   private String[] T002T19_A1565CliConvenio ;
   private String[] T002T19_A8CatCodigo ;
   private java.util.Date[] T002T19_A907CatVigencia ;
   private java.math.BigDecimal[] T002T19_A122CatBasico ;
   private boolean[] T002T19_n122CatBasico ;
   private java.math.BigDecimal[] T002T19_A731CatValorHora ;
   private boolean[] T002T19_n731CatValorHora ;
   private java.math.BigDecimal[] T002T19_A908CatAdicional ;
   private boolean[] T002T19_n908CatAdicional ;
   private java.math.BigDecimal[] T002T19_A909CatAdiHora ;
   private boolean[] T002T19_n909CatAdiHora ;
   private java.math.BigDecimal[] T002T19_A1892EscBasico ;
   private java.math.BigDecimal[] T002T19_A1893EscAdicional ;
   private int[] T002T19_A1891CatSalRelSec ;
   private boolean[] T002T19_n1891CatSalRelSec ;
   private short[] T002T19_A1564CliPaiConve ;
   private int[] T002T20_A3CliCod ;
   private short[] T002T20_A1564CliPaiConve ;
   private String[] T002T20_A1565CliConvenio ;
   private String[] T002T20_A8CatCodigo ;
   private java.util.Date[] T002T20_A907CatVigencia ;
   private int[] T002T6_A3CliCod ;
   private String[] T002T6_A1565CliConvenio ;
   private String[] T002T6_A8CatCodigo ;
   private java.util.Date[] T002T6_A907CatVigencia ;
   private java.math.BigDecimal[] T002T6_A122CatBasico ;
   private boolean[] T002T6_n122CatBasico ;
   private java.math.BigDecimal[] T002T6_A731CatValorHora ;
   private boolean[] T002T6_n731CatValorHora ;
   private java.math.BigDecimal[] T002T6_A908CatAdicional ;
   private boolean[] T002T6_n908CatAdicional ;
   private java.math.BigDecimal[] T002T6_A909CatAdiHora ;
   private boolean[] T002T6_n909CatAdiHora ;
   private java.math.BigDecimal[] T002T6_A1892EscBasico ;
   private java.math.BigDecimal[] T002T6_A1893EscAdicional ;
   private int[] T002T6_A1891CatSalRelSec ;
   private boolean[] T002T6_n1891CatSalRelSec ;
   private short[] T002T6_A1564CliPaiConve ;
   private int[] T002T5_A3CliCod ;
   private String[] T002T5_A1565CliConvenio ;
   private String[] T002T5_A8CatCodigo ;
   private java.util.Date[] T002T5_A907CatVigencia ;
   private java.math.BigDecimal[] T002T5_A122CatBasico ;
   private boolean[] T002T5_n122CatBasico ;
   private java.math.BigDecimal[] T002T5_A731CatValorHora ;
   private boolean[] T002T5_n731CatValorHora ;
   private java.math.BigDecimal[] T002T5_A908CatAdicional ;
   private boolean[] T002T5_n908CatAdicional ;
   private java.math.BigDecimal[] T002T5_A909CatAdiHora ;
   private boolean[] T002T5_n909CatAdiHora ;
   private java.math.BigDecimal[] T002T5_A1892EscBasico ;
   private java.math.BigDecimal[] T002T5_A1893EscAdicional ;
   private int[] T002T5_A1891CatSalRelSec ;
   private boolean[] T002T5_n1891CatSalRelSec ;
   private short[] T002T5_A1564CliPaiConve ;
   private int[] T002T24_A3CliCod ;
   private short[] T002T24_A1564CliPaiConve ;
   private String[] T002T24_A1565CliConvenio ;
   private String[] T002T24_A8CatCodigo ;
   private java.util.Date[] T002T24_A907CatVigencia ;
   private int[] T002T25_A3CliCod ;
   private String[] T002T25_A1565CliConvenio ;
   private String[] T002T25_A8CatCodigo ;
   private int[] T002T25_A2202CatProvRelSec ;
   private boolean[] T002T25_n2202CatProvRelSec ;
   private String[] T002T25_A2203CatProvRelRef ;
   private boolean[] T002T25_n2203CatProvRelRef ;
   private String[] T002T25_A2204CatProvOld ;
   private boolean[] T002T25_n2204CatProvOld ;
   private short[] T002T25_A2200CatPaiCod ;
   private short[] T002T25_A2201CatProvCod ;
   private short[] T002T25_A1564CliPaiConve ;
   private short[] T002T4_A2200CatPaiCod ;
   private short[] T002T26_A2200CatPaiCod ;
   private int[] T002T27_A3CliCod ;
   private short[] T002T27_A1564CliPaiConve ;
   private String[] T002T27_A1565CliConvenio ;
   private String[] T002T27_A8CatCodigo ;
   private short[] T002T27_A2200CatPaiCod ;
   private short[] T002T27_A2201CatProvCod ;
   private int[] T002T3_A3CliCod ;
   private String[] T002T3_A1565CliConvenio ;
   private String[] T002T3_A8CatCodigo ;
   private int[] T002T3_A2202CatProvRelSec ;
   private boolean[] T002T3_n2202CatProvRelSec ;
   private String[] T002T3_A2203CatProvRelRef ;
   private boolean[] T002T3_n2203CatProvRelRef ;
   private String[] T002T3_A2204CatProvOld ;
   private boolean[] T002T3_n2204CatProvOld ;
   private short[] T002T3_A2200CatPaiCod ;
   private short[] T002T3_A2201CatProvCod ;
   private short[] T002T3_A1564CliPaiConve ;
   private int[] T002T2_A3CliCod ;
   private String[] T002T2_A1565CliConvenio ;
   private String[] T002T2_A8CatCodigo ;
   private int[] T002T2_A2202CatProvRelSec ;
   private boolean[] T002T2_n2202CatProvRelSec ;
   private String[] T002T2_A2203CatProvRelRef ;
   private boolean[] T002T2_n2203CatProvRelRef ;
   private String[] T002T2_A2204CatProvOld ;
   private boolean[] T002T2_n2204CatProvOld ;
   private short[] T002T2_A2200CatPaiCod ;
   private short[] T002T2_A2201CatProvCod ;
   private short[] T002T2_A1564CliPaiConve ;
   private int[] T002T31_A3CliCod ;
   private short[] T002T31_A1564CliPaiConve ;
   private String[] T002T31_A1565CliConvenio ;
   private String[] T002T31_A8CatCodigo ;
   private short[] T002T31_A2200CatPaiCod ;
   private short[] T002T31_A2201CatProvCod ;
   private int[] T002T32_A3CliCod ;
   private int[] T002T32_A1885CliRelSec ;
   private String[] T002T32_A1880CliReDTChar ;
   private int[] T002T33_A3CliCod ;
   private int[] T002T33_A1885CliRelSec ;
   private String[] T002T33_A1880CliReDTChar ;
   private int[] T002T34_A3CliCod ;
   private int[] T002T34_A1885CliRelSec ;
   private String[] T002T34_A1880CliReDTChar ;
   private short[] T002T35_A2200CatPaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV17SinCod ;
   private GXSimpleCollection<String> GXt_objcol_char12 ;
   private GXSimpleCollection<String> GXv_objcol_char13[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV34CatPaiCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV35CatProvCod_Data ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV16WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV21DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[] ;
}

final  class categoriaalta2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002T2", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?  FOR UPDATE OF CategoriaProvincias NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T3", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T4", "SELECT PaiCod AS CatPaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T5", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CatSalRelSec, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?  FOR UPDATE OF Categoriavalores1 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T6", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CatSalRelSec, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T7", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatRelSec, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?  FOR UPDATE OF Categoria1 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T8", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatRelSec, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T9", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T10", "SELECT TM1.CatCodigo, TM1.CatDescrip, TM1.CatDescripSinAc, TM1.CatRelSec, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM Categoria1 TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CatCodigo = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CatCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T11", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T12", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatCodigo > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002T13", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatCodigo < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, CatCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002T14", "SAVEPOINT gxupdate;INSERT INTO Categoria1(CatCodigo, CatDescrip, CatDescripSinAc, CatRelSec, CliCod, CliPaiConve, CliConvenio, CatClase, CatFrecAct, CatRelRef, CatOld, CatAfipCod, CatTipoTarifa) VALUES(?, ?, ?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002T15", "SAVEPOINT gxupdate;UPDATE Categoria1 SET CatDescrip=?, CatDescripSinAc=?, CatRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002T16", "SAVEPOINT gxupdate;DELETE FROM Categoria1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002T17", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio, LiqCatCodigo FROM LiquidacionCategoria WHERE CliCod = ? AND LiqPaiConve = ? AND LiqConvenio = ? AND LiqCatCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002T18", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T19", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CatSalRelSec, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T20", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T002T21", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CatSalRelSec, CliPaiConve, CatSalRelRef, CatSalOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002T22", "SAVEPOINT gxupdate;UPDATE Categoriavalores1 SET CatBasico=?, CatValorHora=?, CatAdicional=?, CatAdiHora=?, EscBasico=?, EscAdicional=?, CatSalRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002T23", "SAVEPOINT gxupdate;DELETE FROM Categoriavalores1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002T24", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T25", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatPaiCod = ? and CatProvCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T26", "SELECT PaiCod AS CatPaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T27", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T002T28", "SAVEPOINT gxupdate;INSERT INTO CategoriaProvincias(CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002T29", "SAVEPOINT gxupdate;UPDATE CategoriaProvincias SET CatProvRelSec=?, CatProvRelRef=?, CatProvOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002T30", "SAVEPOINT gxupdate;DELETE FROM CategoriaProvincias  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002T31", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T32", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T33", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T34", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002T35", "SELECT PaiCod AS CatPaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((int[]) buf[14])[0] = rslt.getInt(11);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((short[]) buf[16])[0] = rslt.getShort(12);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((int[]) buf[14])[0] = rslt.getInt(11);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((short[]) buf[16])[0] = rslt.getShort(12);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((int[]) buf[14])[0] = rslt.getInt(11);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((short[]) buf[16])[0] = rslt.getShort(12);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 24 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 33 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 40);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 40);
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[4]).shortValue());
               }
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setString(7, (String)parms[7], 20);
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               stmt.setString(6, (String)parms[6], 20);
               stmt.setString(7, (String)parms[7], 40);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setDate(4, (java.util.Date)parms[3]);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 2);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(6, (java.math.BigDecimal)parms[7], 2);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(7, (java.math.BigDecimal)parms[9], 2);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(8, (java.math.BigDecimal)parms[11], 2);
               }
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[13], 2);
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(11, ((Number) parms[15]).intValue());
               }
               stmt.setShort(12, ((Number) parms[16]).shortValue());
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(1, (java.math.BigDecimal)parms[1], 2);
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
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[9], 2);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(7, ((Number) parms[11]).intValue());
               }
               stmt.setInt(8, ((Number) parms[12]).intValue());
               stmt.setShort(9, ((Number) parms[13]).shortValue());
               stmt.setString(10, (String)parms[14], 20);
               stmt.setString(11, (String)parms[15], 40);
               stmt.setDate(12, (java.util.Date)parms[16]);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 24 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 40);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[4]).intValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[6], 40);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(6, (String)parms[8]);
               }
               stmt.setShort(7, ((Number) parms[9]).shortValue());
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setShort(9, ((Number) parms[11]).shortValue());
               return;
            case 27 :
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
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 40);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[5]);
               }
               stmt.setInt(4, ((Number) parms[6]).intValue());
               stmt.setShort(5, ((Number) parms[7]).shortValue());
               stmt.setString(6, (String)parms[8], 20);
               stmt.setString(7, (String)parms[9], 40);
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setShort(9, ((Number) parms[11]).shortValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 33 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

