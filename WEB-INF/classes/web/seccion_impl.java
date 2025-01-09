package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class seccion_impl extends GXDataArea
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
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         A1984SecRelSec = (int)(GXutil.lval( httpContext.GetPar( "SecRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1984SecRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1984SecRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_16_1A43( Gx_mode, AV11CliCod, A1984SecRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action22") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         A1987PuestoRelSec = (int)(GXutil.lval( httpContext.GetPar( "PuestoRelSec"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_22_1A153( Gx_mode, AV11CliCod, A1987PuestoRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"SECRELSEC") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlasecrelsec1A43( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"PUESTORELSEC") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlapuestorelsec1A153( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"SECDESCRIPSINAC") == 0 )
      {
         A329SecDescrip = httpContext.GetPar( "SecDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asasecdescripsinac1A43( A329SecDescrip) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLICOD") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asaclicod1A43( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel7"+"_"+"") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxasa19841A43( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel8"+"_"+"") == 0 )
      {
         AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxasa19871A43( AV11CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel18"+"_"+"PUESTODESCRIPSINAC") == 0 )
      {
         A1241PuestoDescrip = httpContext.GetPar( "PuestoDescrip") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx18asapuestodescripsinac1A153( A1241PuestoDescrip) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_25") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_25( A3CliCod) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel1") == 0 )
      {
         gxnrgridlevel1_newrow_invoke( ) ;
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
            AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
            AV7SecCodigo = httpContext.GetPar( "SecCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SecCodigo", AV7SecCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7SecCodigo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Area", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSecCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel1_newrow_invoke( )
   {
      nRC_GXsfl_51 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_51"))) ;
      nGXsfl_51_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_51_idx"))) ;
      sGXsfl_51_idx = httpContext.GetPar( "sGXsfl_51_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV11CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel1_newrow( ) ;
      /* End function gxnrGridlevel1_newrow_invoke */
   }

   public seccion_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public seccion_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( seccion_impl.class ));
   }

   public seccion_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynSecRelSec = new HTMLChoice();
      chkSecApoOpc = UIFactory.getCheckbox(this);
      chkPuestoHorasExt = UIFactory.getCheckbox(this);
      dynPuestoRelSec = new HTMLChoice();
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
      if ( dynSecRelSec.getItemCount() > 0 )
      {
         A1984SecRelSec = (int)(GXutil.lval( dynSecRelSec.getValidValue(GXutil.trim( GXutil.str( A1984SecRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1984SecRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1984SecRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynSecRelSec.setValue( GXutil.trim( GXutil.str( A1984SecRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynSecRelSec.getInternalname(), "Values", dynSecRelSec.ToJavascriptSource(), true);
      }
      A2308SecApoOpc = GXutil.strtobool( GXutil.booltostr( A2308SecApoOpc)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2308SecApoOpc", A2308SecApoOpc);
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
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Área", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Seccion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSecCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtSecCodigo_Internalname, GXutil.rtrim( A13SecCodigo), GXutil.rtrim( localUtil.format( A13SecCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_Seccion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtSecDescrip_Internalname, httpContext.getMessage( "Area", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtSecDescrip_Internalname, A329SecDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", (short)(0), 1, edtSecDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Seccion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSecrelsec_cell_Internalname, 1, 0, "px", 0, "px", divSecrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynSecRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynSecRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynSecRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynSecRelSec, dynSecRelSec.getInternalname(), GXutil.trim( GXutil.str( A1984SecRelSec, 6, 0)), 1, dynSecRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynSecRelSec.getVisible(), dynSecRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "", true, (byte)(0), "HLP_Seccion.htm");
      dynSecRelSec.setValue( GXutil.trim( GXutil.str( A1984SecRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynSecRelSec.getInternalname(), "Values", dynSecRelSec.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkSecApoOpc.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkSecApoOpc.getInternalname(), httpContext.getMessage( "Es opcional la liquidación de descuentos de ley", ""), " AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkSecApoOpc.getInternalname(), GXutil.booltostr( A2308SecApoOpc), "", httpContext.getMessage( "Es opcional la liquidación de descuentos de ley", ""), 1, chkSecApoOpc.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(43, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,43);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
      ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
      ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
      ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
      ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
      ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
      ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
      ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
      ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
      ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
      ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      gxdraw_gridlevel1( ) ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Seccion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Seccion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Seccion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Seccion.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridlevel1( )
   {
      /*  Grid Control  */
      startgridcontrol51( ) ;
      nGXsfl_51_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount153 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_153 = (short)(1) ;
            scanStart1A153( ) ;
            while ( RcdFound153 != 0 )
            {
               init_level_properties153( ) ;
               getByPrimaryKey1A153( ) ;
               addRow1A153( ) ;
               scanNext1A153( ) ;
            }
            scanEnd1A153( ) ;
            nBlankRcdCount153 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B329SecDescrip = A329SecDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
         B13SecCodigo = A13SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         standaloneNotModal1A153( ) ;
         standaloneModal1A153( ) ;
         sMode153 = Gx_mode ;
         while ( nGXsfl_51_idx < nRC_GXsfl_51 )
         {
            bGXsfl_51_Refreshing = true ;
            readRow1A153( ) ;
            edtPuestoCodigo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PUESTOCODIGO_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), !bGXsfl_51_Refreshing);
            edtPuestoDescrip_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PUESTODESCRIP_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPuestoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoDescrip_Enabled), 5, 0), !bGXsfl_51_Refreshing);
            chkPuestoHorasExt.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "PUESTOHORASEXT_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkPuestoHorasExt.getInternalname(), "Enabled", GXutil.ltrimstr( chkPuestoHorasExt.getEnabled(), 5, 0), !bGXsfl_51_Refreshing);
            dynPuestoRelSec.setVisible( (int)(localUtil.ctol( httpContext.cgiGet( "PUESTORELSEC_"+sGXsfl_51_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynPuestoRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynPuestoRelSec.getVisible(), 5, 0), !bGXsfl_51_Refreshing);
            dynPuestoRelSec.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "PUESTORELSEC_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynPuestoRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynPuestoRelSec.getEnabled(), 5, 0), !bGXsfl_51_Refreshing);
            if ( ( nRcdExists_153 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1A153( ) ;
            }
            sendRow1A153( ) ;
            bGXsfl_51_Refreshing = false ;
         }
         Gx_mode = sMode153 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A329SecDescrip = B329SecDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
         A13SecCodigo = B13SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount153 = (short)(5) ;
         nRcdExists_153 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1A153( ) ;
            while ( RcdFound153 != 0 )
            {
               sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_51153( ) ;
               init_level_properties153( ) ;
               standaloneNotModal1A153( ) ;
               getByPrimaryKey1A153( ) ;
               standaloneModal1A153( ) ;
               addRow1A153( ) ;
               scanNext1A153( ) ;
            }
            scanEnd1A153( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode153 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_51153( ) ;
         initAll1A153( ) ;
         init_level_properties153( ) ;
         B329SecDescrip = A329SecDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
         B13SecCodigo = A13SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         nRcdExists_153 = (short)(0) ;
         nIsMod_153 = (short)(0) ;
         nRcdDeleted_153 = (short)(0) ;
         nBlankRcdCount153 = (short)(nBlankRcdUsr153+nBlankRcdCount153) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount153 > 0 )
         {
            standaloneNotModal1A153( ) ;
            standaloneModal1A153( ) ;
            addRow1A153( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtPuestoCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount153 = (short)(nBlankRcdCount153-1) ;
         }
         Gx_mode = sMode153 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A329SecDescrip = B329SecDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
         A13SecCodigo = B13SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel1", Gridlevel1Container, subGridlevel1_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData", Gridlevel1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData"+"V", Gridlevel1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel1ContainerData"+"V"+"\" value='"+Gridlevel1Container.GridValuesHidden()+"'/>") ;
      }
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
      e111A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z13SecCodigo = httpContext.cgiGet( "Z13SecCodigo") ;
            Z675SecDescripSinAc = httpContext.cgiGet( "Z675SecDescripSinAc") ;
            Z329SecDescrip = httpContext.cgiGet( "Z329SecDescrip") ;
            Z330SecHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z330SecHabilitada")) ;
            Z1984SecRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1984SecRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1985SecRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1985SecRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1986SecPadre = httpContext.cgiGet( "Z1986SecPadre") ;
            Z2015SecRelRef = httpContext.cgiGet( "Z2015SecRelRef") ;
            Z2308SecApoOpc = GXutil.strtobool( httpContext.cgiGet( "Z2308SecApoOpc")) ;
            A675SecDescripSinAc = httpContext.cgiGet( "Z675SecDescripSinAc") ;
            A330SecHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z330SecHabilitada")) ;
            A1985SecRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1985SecRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1986SecPadre = httpContext.cgiGet( "Z1986SecPadre") ;
            A2015SecRelRef = httpContext.cgiGet( "Z2015SecRelRef") ;
            O329SecDescrip = httpContext.cgiGet( "O329SecDescrip") ;
            O13SecCodigo = httpContext.cgiGet( "O13SecCodigo") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_51 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_51"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A675SecDescripSinAc = httpContext.cgiGet( "SECDESCRIPSINAC") ;
            AV11CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7SecCodigo = httpContext.cgiGet( "vSECCODIGO") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A330SecHabilitada = GXutil.strtobool( httpContext.cgiGet( "SECHABILITADA")) ;
            AV15aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A1985SecRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "SECRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1986SecPadre = httpContext.cgiGet( "SECPADRE") ;
            A2015SecRelRef = httpContext.cgiGet( "SECRELREF") ;
            A2033SecOld = httpContext.cgiGet( "SECOLD") ;
            AV17Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A1242PuestoDescripSinAc = httpContext.cgiGet( "PUESTODESCRIPSINAC") ;
            A1988PuestoRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "PUESTORELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1989PuestoPadre = httpContext.cgiGet( "PUESTOPADRE") ;
            A2016PuestoRelRef = httpContext.cgiGet( "PUESTORELREF") ;
            A2034PuestoOld = httpContext.cgiGet( "PUESTOOLD") ;
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
            Dvpanel_unnamedtable1_Objectcall = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Objectcall") ;
            Dvpanel_unnamedtable1_Class = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Class") ;
            Dvpanel_unnamedtable1_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Enabled")) ;
            Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
            Dvpanel_unnamedtable1_Height = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Height") ;
            Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
            Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
            Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
            Dvpanel_unnamedtable1_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showheader")) ;
            Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
            Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
            Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
            Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
            Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
            Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
            Dvpanel_unnamedtable1_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Visible")) ;
            Dvpanel_unnamedtable1_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A13SecCodigo = httpContext.cgiGet( edtSecCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
            A329SecDescrip = httpContext.cgiGet( edtSecDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
            dynSecRelSec.setName( dynSecRelSec.getInternalname() );
            dynSecRelSec.setValue( httpContext.cgiGet( dynSecRelSec.getInternalname()) );
            A1984SecRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynSecRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1984SecRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1984SecRelSec), 6, 0));
            A2308SecApoOpc = GXutil.strtobool( httpContext.cgiGet( chkSecApoOpc.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2308SecApoOpc", A2308SecApoOpc);
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Seccion");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("SecHabilitada", GXutil.booltostr( A330SecHabilitada));
            forbiddenHiddens.add("SecRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1985SecRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("SecPadre", GXutil.rtrim( localUtil.format( A1986SecPadre, "")));
            forbiddenHiddens.add("SecRelRef", GXutil.rtrim( localUtil.format( A2015SecRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("seccion:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
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
               A13SecCodigo = httpContext.GetPar( "SecCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
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
                  sMode43 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode43 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound43 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1A0( ) ;
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
                        e111A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121A2 ();
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
         e121A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1A43( ) ;
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
         disableAttributes1A43( ) ;
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

   public void confirm_1A0( )
   {
      beforeValidate1A43( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1A43( ) ;
         }
         else
         {
            checkExtendedTable1A43( ) ;
            closeExtendedTableCursors1A43( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode43 = Gx_mode ;
         confirm_1A153( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode43 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode43 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_1A153( )
   {
      nGXsfl_51_idx = 0 ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         readRow1A153( ) ;
         if ( ( nRcdExists_153 != 0 ) || ( nIsMod_153 != 0 ) )
         {
            getKey1A153( ) ;
            if ( ( nRcdExists_153 == 0 ) && ( nRcdDeleted_153 == 0 ) )
            {
               if ( RcdFound153 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1A153( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1A153( ) ;
                     closeExtendedTableCursors1A153( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "PUESTOCODIGO_" + sGXsfl_51_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPuestoCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound153 != 0 )
               {
                  if ( nRcdDeleted_153 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey1A153( ) ;
                     load1A153( ) ;
                     beforeValidate1A153( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1A153( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_153 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1A153( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1A153( ) ;
                           closeExtendedTableCursors1A153( ) ;
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
                  if ( nRcdDeleted_153 == 0 )
                  {
                     GXCCtl = "PUESTOCODIGO_" + sGXsfl_51_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPuestoCodigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtPuestoCodigo_Internalname, GXutil.rtrim( A1240PuestoCodigo)) ;
         httpContext.changePostValue( edtPuestoDescrip_Internalname, A1241PuestoDescrip) ;
         httpContext.changePostValue( chkPuestoHorasExt.getInternalname(), GXutil.booltostr( A1255PuestoHorasExt)) ;
         httpContext.changePostValue( dynPuestoRelSec.getInternalname(), GXutil.ltrim( localUtil.ntoc( A1987PuestoRelSec, (byte)(6), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1240PuestoCodigo_"+sGXsfl_51_idx, GXutil.rtrim( Z1240PuestoCodigo)) ;
         httpContext.changePostValue( "ZT_"+"Z1242PuestoDescripSinAc_"+sGXsfl_51_idx, Z1242PuestoDescripSinAc) ;
         httpContext.changePostValue( "ZT_"+"Z1241PuestoDescrip_"+sGXsfl_51_idx, Z1241PuestoDescrip) ;
         httpContext.changePostValue( "ZT_"+"Z1255PuestoHorasExt_"+sGXsfl_51_idx, GXutil.booltostr( Z1255PuestoHorasExt)) ;
         httpContext.changePostValue( "ZT_"+"Z1987PuestoRelSec_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z1987PuestoRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1988PuestoRelSecCli_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z1988PuestoRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1989PuestoPadre_"+sGXsfl_51_idx, GXutil.rtrim( Z1989PuestoPadre)) ;
         httpContext.changePostValue( "ZT_"+"Z2016PuestoRelRef_"+sGXsfl_51_idx, Z2016PuestoRelRef) ;
         httpContext.changePostValue( "T1240PuestoCodigo_"+sGXsfl_51_idx, GXutil.rtrim( O1240PuestoCodigo)) ;
         httpContext.changePostValue( "T1255PuestoHorasExt_"+sGXsfl_51_idx, GXutil.booltostr( O1255PuestoHorasExt)) ;
         httpContext.changePostValue( "nRcdDeleted_153_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_153_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_153_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_153 != 0 )
         {
            httpContext.changePostValue( "PUESTOCODIGO_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPuestoCodigo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PUESTODESCRIP_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPuestoDescrip_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PUESTOHORASEXT_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkPuestoHorasExt.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PUESTORELSEC_"+sGXsfl_51_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynPuestoRelSec.getVisible(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PUESTORELSEC_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynPuestoRelSec.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption1A0( )
   {
   }

   public void e111A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSeccion_Insert", GXv_boolean3) ;
         seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSeccion_Update", GXv_boolean3) ;
         seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSeccion_Delete", GXv_boolean3) ;
         seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e121A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.secciongrabarrelref(remoteHandle, context).execute( A3CliCod) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divSecrelsec_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
      httpContext.ajax_rsp_assign_prop("", false, divSecrelsec_cell_Internalname, "Class", divSecrelsec_cell_Class, true);
   }

   public void zm1A43( int GX_JID )
   {
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z675SecDescripSinAc = T001A5_A675SecDescripSinAc[0] ;
            Z329SecDescrip = T001A5_A329SecDescrip[0] ;
            Z330SecHabilitada = T001A5_A330SecHabilitada[0] ;
            Z1984SecRelSec = T001A5_A1984SecRelSec[0] ;
            Z1985SecRelSecCli = T001A5_A1985SecRelSecCli[0] ;
            Z1986SecPadre = T001A5_A1986SecPadre[0] ;
            Z2015SecRelRef = T001A5_A2015SecRelRef[0] ;
            Z2308SecApoOpc = T001A5_A2308SecApoOpc[0] ;
         }
         else
         {
            Z675SecDescripSinAc = A675SecDescripSinAc ;
            Z329SecDescrip = A329SecDescrip ;
            Z330SecHabilitada = A330SecHabilitada ;
            Z1984SecRelSec = A1984SecRelSec ;
            Z1985SecRelSecCli = A1985SecRelSecCli ;
            Z1986SecPadre = A1986SecPadre ;
            Z2015SecRelRef = A2015SecRelRef ;
            Z2308SecApoOpc = A2308SecApoOpc ;
         }
      }
      if ( GX_JID == -24 )
      {
         Z675SecDescripSinAc = A675SecDescripSinAc ;
         Z13SecCodigo = A13SecCodigo ;
         Z329SecDescrip = A329SecDescrip ;
         Z330SecHabilitada = A330SecHabilitada ;
         Z1984SecRelSec = A1984SecRelSec ;
         Z1985SecRelSecCli = A1985SecRelSecCli ;
         Z1986SecPadre = A1986SecPadre ;
         Z2015SecRelRef = A2015SecRelRef ;
         Z2033SecOld = A2033SecOld ;
         Z2308SecApoOpc = A2308SecApoOpc ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxasecrelsec_html1A43( AV11CliCod) ;
      if ( ! (0==AV11CliCod) )
      {
         A3CliCod = AV11CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            seccion_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV11CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynSecRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynSecRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynSecRelSec.getVisible(), 5, 0), true);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynPuestoRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynPuestoRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynPuestoRelSec.getVisible(), 5, 0), !bGXsfl_51_Refreshing);
      if ( ! (0==AV11CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7SecCodigo)==0) )
      {
         A13SecCodigo = AV7SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
      }
      if ( ! (GXutil.strcmp("", AV7SecCodigo)==0) )
      {
         edtSecCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtSecCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7SecCodigo)==0) )
      {
         edtSecCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Enabled), 5, 0), true);
      }
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
      if ( isIns( )  && (false==A330SecHabilitada) && ( Gx_BScreen == 0 ) )
      {
         A330SecHabilitada = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A330SecHabilitada", A330SecHabilitada);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV17Pgmname = "Seccion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      }
   }

   public void load1A43( )
   {
      /* Using cursor T001A7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A675SecDescripSinAc = T001A7_A675SecDescripSinAc[0] ;
         A329SecDescrip = T001A7_A329SecDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
         A330SecHabilitada = T001A7_A330SecHabilitada[0] ;
         A1984SecRelSec = T001A7_A1984SecRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1984SecRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1984SecRelSec), 6, 0));
         A1985SecRelSecCli = T001A7_A1985SecRelSecCli[0] ;
         A1986SecPadre = T001A7_A1986SecPadre[0] ;
         A2015SecRelRef = T001A7_A2015SecRelRef[0] ;
         A2033SecOld = T001A7_A2033SecOld[0] ;
         A2308SecApoOpc = T001A7_A2308SecApoOpc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2308SecApoOpc", A2308SecApoOpc);
         zm1A43( -24) ;
      }
      pr_default.close(5);
      onLoadActions1A43( ) ;
   }

   public void onLoadActions1A43( )
   {
      AV17Pgmname = "Seccion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) ) )
      {
         divSecrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divSecrelsec_cell_Internalname, "Class", divSecrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) )
         {
            divSecrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSecrelsec_cell_Internalname, "Class", divSecrelsec_cell_Class, true);
         }
      }
      GXt_char6 = A675SecDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char7) ;
      seccion_impl.this.GXt_char6 = GXv_char7[0] ;
      A675SecDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A675SecDescripSinAc", A675SecDescripSinAc);
   }

   public void checkExtendedTable1A43( )
   {
      nIsDirty_43 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV17Pgmname = "Seccion" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1984SecRelSec, GXv_boolean3) ;
         seccion_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      }
      /* Using cursor T001A6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) ) )
      {
         divSecrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divSecrelsec_cell_Internalname, "Class", divSecrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) )
         {
            divSecrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSecrelsec_cell_Internalname, "Class", divSecrelsec_cell_Class, true);
         }
      }
      if ( (GXutil.strcmp("", A13SecCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Area", ""), "", "", "", "", "", "", "", ""), 1, "SECCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV11CliCod) && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) ) && (0==A1984SecRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "SECCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_43 = (short)(1) ;
      GXt_char6 = A675SecDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char7) ;
      seccion_impl.this.GXt_char6 = GXv_char7[0] ;
      A675SecDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A675SecDescripSinAc", A675SecDescripSinAc);
      if ( (GXutil.strcmp("", A329SecDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Area", ""), "", "", "", "", "", "", "", ""), 1, "SECDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecDescrip_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1A43( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_25( int A3CliCod )
   {
      /* Using cursor T001A8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey1A43( )
   {
      /* Using cursor T001A9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound43 = (short)(1) ;
      }
      else
      {
         RcdFound43 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001A5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm1A43( 24) ;
         RcdFound43 = (short)(1) ;
         A675SecDescripSinAc = T001A5_A675SecDescripSinAc[0] ;
         A13SecCodigo = T001A5_A13SecCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         A329SecDescrip = T001A5_A329SecDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
         A330SecHabilitada = T001A5_A330SecHabilitada[0] ;
         A1984SecRelSec = T001A5_A1984SecRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1984SecRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1984SecRelSec), 6, 0));
         A1985SecRelSecCli = T001A5_A1985SecRelSecCli[0] ;
         A1986SecPadre = T001A5_A1986SecPadre[0] ;
         A2015SecRelRef = T001A5_A2015SecRelRef[0] ;
         A2033SecOld = T001A5_A2033SecOld[0] ;
         A2308SecApoOpc = T001A5_A2308SecApoOpc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2308SecApoOpc", A2308SecApoOpc);
         A3CliCod = T001A5_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         O329SecDescrip = A329SecDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
         O13SecCodigo = A13SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1A43( ) ;
         if ( AnyError == 1 )
         {
            RcdFound43 = (short)(0) ;
            initializeNonKey1A43( ) ;
         }
         Gx_mode = sMode43 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound43 = (short)(0) ;
         initializeNonKey1A43( ) ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode43 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey1A43( ) ;
      if ( RcdFound43 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound43 = (short)(0) ;
      /* Using cursor T001A10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001A10_A3CliCod[0] < A3CliCod ) || ( T001A10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001A10_A13SecCodigo[0], A13SecCodigo) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001A10_A3CliCod[0] > A3CliCod ) || ( T001A10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001A10_A13SecCodigo[0], A13SecCodigo) > 0 ) ) )
         {
            A3CliCod = T001A10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A13SecCodigo = T001A10_A13SecCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
            RcdFound43 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound43 = (short)(0) ;
      /* Using cursor T001A11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001A11_A3CliCod[0] > A3CliCod ) || ( T001A11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001A11_A13SecCodigo[0], A13SecCodigo) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001A11_A3CliCod[0] < A3CliCod ) || ( T001A11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001A11_A13SecCodigo[0], A13SecCodigo) < 0 ) ) )
         {
            A3CliCod = T001A11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A13SecCodigo = T001A11_A13SecCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
            RcdFound43 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1A43( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSecCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1A43( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound43 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A13SecCodigo = Z13SecCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSecCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1A43( ) ;
               GX_FocusControl = edtSecCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtSecCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1A43( ) ;
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
                  GX_FocusControl = edtSecCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1A43( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A13SecCodigo = Z13SecCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSecCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1A43( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001A4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Seccion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z675SecDescripSinAc, T001A4_A675SecDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z329SecDescrip, T001A4_A329SecDescrip[0]) != 0 ) || ( Z330SecHabilitada != T001A4_A330SecHabilitada[0] ) || ( Z1984SecRelSec != T001A4_A1984SecRelSec[0] ) || ( Z1985SecRelSecCli != T001A4_A1985SecRelSecCli[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1986SecPadre, T001A4_A1986SecPadre[0]) != 0 ) || ( GXutil.strcmp(Z2015SecRelRef, T001A4_A2015SecRelRef[0]) != 0 ) || ( Z2308SecApoOpc != T001A4_A2308SecApoOpc[0] ) )
         {
            if ( GXutil.strcmp(Z675SecDescripSinAc, T001A4_A675SecDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"SecDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z675SecDescripSinAc);
               GXutil.writeLogRaw("Current: ",T001A4_A675SecDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z329SecDescrip, T001A4_A329SecDescrip[0]) != 0 )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"SecDescrip");
               GXutil.writeLogRaw("Old: ",Z329SecDescrip);
               GXutil.writeLogRaw("Current: ",T001A4_A329SecDescrip[0]);
            }
            if ( Z330SecHabilitada != T001A4_A330SecHabilitada[0] )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"SecHabilitada");
               GXutil.writeLogRaw("Old: ",Z330SecHabilitada);
               GXutil.writeLogRaw("Current: ",T001A4_A330SecHabilitada[0]);
            }
            if ( Z1984SecRelSec != T001A4_A1984SecRelSec[0] )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"SecRelSec");
               GXutil.writeLogRaw("Old: ",Z1984SecRelSec);
               GXutil.writeLogRaw("Current: ",T001A4_A1984SecRelSec[0]);
            }
            if ( Z1985SecRelSecCli != T001A4_A1985SecRelSecCli[0] )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"SecRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1985SecRelSecCli);
               GXutil.writeLogRaw("Current: ",T001A4_A1985SecRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z1986SecPadre, T001A4_A1986SecPadre[0]) != 0 )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"SecPadre");
               GXutil.writeLogRaw("Old: ",Z1986SecPadre);
               GXutil.writeLogRaw("Current: ",T001A4_A1986SecPadre[0]);
            }
            if ( GXutil.strcmp(Z2015SecRelRef, T001A4_A2015SecRelRef[0]) != 0 )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"SecRelRef");
               GXutil.writeLogRaw("Old: ",Z2015SecRelRef);
               GXutil.writeLogRaw("Current: ",T001A4_A2015SecRelRef[0]);
            }
            if ( Z2308SecApoOpc != T001A4_A2308SecApoOpc[0] )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"SecApoOpc");
               GXutil.writeLogRaw("Old: ",Z2308SecApoOpc);
               GXutil.writeLogRaw("Current: ",T001A4_A2308SecApoOpc[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Seccion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1A43( )
   {
      beforeValidate1A43( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1A43( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1A43( 0) ;
         checkOptimisticConcurrency1A43( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1A43( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1A43( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001A12 */
                  pr_default.execute(10, new Object[] {A675SecDescripSinAc, A13SecCodigo, A329SecDescrip, Boolean.valueOf(A330SecHabilitada), Integer.valueOf(A1984SecRelSec), Integer.valueOf(A1985SecRelSecCli), A1986SecPadre, A2015SecRelRef, A2033SecOld, Boolean.valueOf(A2308SecApoOpc), Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        processLevel1A43( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption1A0( ) ;
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
            load1A43( ) ;
         }
         endLevel1A43( ) ;
      }
      closeExtendedTableCursors1A43( ) ;
   }

   public void update1A43( )
   {
      beforeValidate1A43( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1A43( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1A43( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1A43( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1A43( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001A13 */
                  pr_default.execute(11, new Object[] {A675SecDescripSinAc, A329SecDescrip, Boolean.valueOf(A330SecHabilitada), Integer.valueOf(A1984SecRelSec), Integer.valueOf(A1985SecRelSecCli), A1986SecPadre, A2015SecRelRef, A2033SecOld, Boolean.valueOf(A2308SecApoOpc), Integer.valueOf(A3CliCod), A13SecCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Seccion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1A43( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1A43( ) ;
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
         endLevel1A43( ) ;
      }
      closeExtendedTableCursors1A43( ) ;
   }

   public void deferredUpdate1A43( )
   {
   }

   public void delete( )
   {
      beforeValidate1A43( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1A43( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1A43( ) ;
         afterConfirm1A43( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1A43( ) ;
            if ( AnyError == 0 )
            {
               scanStart1A153( ) ;
               while ( RcdFound153 != 0 )
               {
                  getByPrimaryKey1A153( ) ;
                  delete1A153( ) ;
                  scanNext1A153( ) ;
               }
               scanEnd1A153( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001A14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
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
      sMode43 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1A43( ) ;
      Gx_mode = sMode43 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1A43( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV15aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1984SecRelSec, GXv_boolean3) ;
            seccion_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
         }
         AV17Pgmname = "Seccion" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) ) )
         {
            divSecrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divSecrelsec_cell_Internalname, "Class", divSecrelsec_cell_Class, true);
         }
         else
         {
            GXt_boolean2 = false ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
            seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) )
            {
               divSecrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divSecrelsec_cell_Internalname, "Class", divSecrelsec_cell_Class, true);
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001A15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionArea", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T001A16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")+" ("+httpContext.getMessage( "Legajo Seccion", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T001A17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T001A18 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void processNestedLevel1A153( )
   {
      nGXsfl_51_idx = 0 ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         readRow1A153( ) ;
         if ( ( nRcdExists_153 != 0 ) || ( nIsMod_153 != 0 ) )
         {
            standaloneNotModal1A153( ) ;
            getKey1A153( ) ;
            if ( ( nRcdExists_153 == 0 ) && ( nRcdDeleted_153 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1A153( ) ;
            }
            else
            {
               if ( RcdFound153 != 0 )
               {
                  if ( ( nRcdDeleted_153 != 0 ) && ( nRcdExists_153 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1A153( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_153 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1A153( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_153 == 0 )
                  {
                     GXCCtl = "PUESTOCODIGO_" + sGXsfl_51_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPuestoCodigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtPuestoCodigo_Internalname, GXutil.rtrim( A1240PuestoCodigo)) ;
         httpContext.changePostValue( edtPuestoDescrip_Internalname, A1241PuestoDescrip) ;
         httpContext.changePostValue( chkPuestoHorasExt.getInternalname(), GXutil.booltostr( A1255PuestoHorasExt)) ;
         httpContext.changePostValue( dynPuestoRelSec.getInternalname(), GXutil.ltrim( localUtil.ntoc( A1987PuestoRelSec, (byte)(6), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1240PuestoCodigo_"+sGXsfl_51_idx, GXutil.rtrim( Z1240PuestoCodigo)) ;
         httpContext.changePostValue( "ZT_"+"Z1242PuestoDescripSinAc_"+sGXsfl_51_idx, Z1242PuestoDescripSinAc) ;
         httpContext.changePostValue( "ZT_"+"Z1241PuestoDescrip_"+sGXsfl_51_idx, Z1241PuestoDescrip) ;
         httpContext.changePostValue( "ZT_"+"Z1255PuestoHorasExt_"+sGXsfl_51_idx, GXutil.booltostr( Z1255PuestoHorasExt)) ;
         httpContext.changePostValue( "ZT_"+"Z1987PuestoRelSec_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z1987PuestoRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1988PuestoRelSecCli_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z1988PuestoRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1989PuestoPadre_"+sGXsfl_51_idx, GXutil.rtrim( Z1989PuestoPadre)) ;
         httpContext.changePostValue( "ZT_"+"Z2016PuestoRelRef_"+sGXsfl_51_idx, Z2016PuestoRelRef) ;
         httpContext.changePostValue( "T1240PuestoCodigo_"+sGXsfl_51_idx, GXutil.rtrim( O1240PuestoCodigo)) ;
         httpContext.changePostValue( "T1255PuestoHorasExt_"+sGXsfl_51_idx, GXutil.booltostr( O1255PuestoHorasExt)) ;
         httpContext.changePostValue( "nRcdDeleted_153_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_153_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_153_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_153 != 0 )
         {
            httpContext.changePostValue( "PUESTOCODIGO_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPuestoCodigo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PUESTODESCRIP_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPuestoDescrip_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PUESTOHORASEXT_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkPuestoHorasExt.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PUESTORELSEC_"+sGXsfl_51_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynPuestoRelSec.getVisible(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PUESTORELSEC_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynPuestoRelSec.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1A153( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_153 = (short)(0) ;
      nIsMod_153 = (short)(0) ;
      nRcdDeleted_153 = (short)(0) ;
   }

   public void processLevel1A43( )
   {
      /* Save parent mode. */
      sMode43 = Gx_mode ;
      processNestedLevel1A153( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode43 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1A43( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1A43( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "seccion");
         if ( AnyError == 0 )
         {
            confirmValues1A0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "seccion");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1A43( )
   {
      /* Scan By routine */
      /* Using cursor T001A19 */
      pr_default.execute(17);
      RcdFound43 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A3CliCod = T001A19_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A13SecCodigo = T001A19_A13SecCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1A43( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound43 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A3CliCod = T001A19_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A13SecCodigo = T001A19_A13SecCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
      }
   }

   public void scanEnd1A43( )
   {
      pr_default.close(17);
   }

   public void afterConfirm1A43( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV15aplicadoHay ) && ! (0==A1984SecRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV11CliCod), "SecRelSec", 1, "SECRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynSecRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert1A43( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1A43( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1A43( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1A43( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1A43( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1A43( )
   {
      edtSecCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecCodigo_Enabled), 5, 0), true);
      edtSecDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecDescrip_Enabled), 5, 0), true);
      dynSecRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynSecRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynSecRelSec.getEnabled(), 5, 0), true);
      chkSecApoOpc.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkSecApoOpc.getInternalname(), "Enabled", GXutil.ltrimstr( chkSecApoOpc.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void zm1A153( int GX_JID )
   {
      if ( ( GX_JID == 26 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1242PuestoDescripSinAc = T001A3_A1242PuestoDescripSinAc[0] ;
            Z1241PuestoDescrip = T001A3_A1241PuestoDescrip[0] ;
            Z1255PuestoHorasExt = T001A3_A1255PuestoHorasExt[0] ;
            Z1987PuestoRelSec = T001A3_A1987PuestoRelSec[0] ;
            Z1988PuestoRelSecCli = T001A3_A1988PuestoRelSecCli[0] ;
            Z1989PuestoPadre = T001A3_A1989PuestoPadre[0] ;
            Z2016PuestoRelRef = T001A3_A2016PuestoRelRef[0] ;
         }
         else
         {
            Z1242PuestoDescripSinAc = A1242PuestoDescripSinAc ;
            Z1241PuestoDescrip = A1241PuestoDescrip ;
            Z1255PuestoHorasExt = A1255PuestoHorasExt ;
            Z1987PuestoRelSec = A1987PuestoRelSec ;
            Z1988PuestoRelSecCli = A1988PuestoRelSecCli ;
            Z1989PuestoPadre = A1989PuestoPadre ;
            Z2016PuestoRelRef = A2016PuestoRelRef ;
         }
      }
      if ( GX_JID == -26 )
      {
         Z1242PuestoDescripSinAc = A1242PuestoDescripSinAc ;
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
         Z1240PuestoCodigo = A1240PuestoCodigo ;
         Z1241PuestoDescrip = A1241PuestoDescrip ;
         Z1255PuestoHorasExt = A1255PuestoHorasExt ;
         Z1987PuestoRelSec = A1987PuestoRelSec ;
         Z1988PuestoRelSecCli = A1988PuestoRelSecCli ;
         Z1989PuestoPadre = A1989PuestoPadre ;
         Z2016PuestoRelRef = A2016PuestoRelRef ;
         Z2034PuestoOld = A2034PuestoOld ;
      }
   }

   public void standaloneNotModal1A153( )
   {
      gxapuestorelsec_html1A153( AV11CliCod) ;
   }

   public void standaloneModal1A153( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtPuestoCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      }
      else
      {
         edtPuestoCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      }
   }

   public void load1A153( )
   {
      /* Using cursor T001A20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A1242PuestoDescripSinAc = T001A20_A1242PuestoDescripSinAc[0] ;
         A1241PuestoDescrip = T001A20_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = T001A20_A1255PuestoHorasExt[0] ;
         A1987PuestoRelSec = T001A20_A1987PuestoRelSec[0] ;
         A1988PuestoRelSecCli = T001A20_A1988PuestoRelSecCli[0] ;
         A1989PuestoPadre = T001A20_A1989PuestoPadre[0] ;
         A2016PuestoRelRef = T001A20_A2016PuestoRelRef[0] ;
         A2034PuestoOld = T001A20_A2034PuestoOld[0] ;
         zm1A153( -26) ;
      }
      pr_default.close(18);
      onLoadActions1A153( ) ;
   }

   public void onLoadActions1A153( )
   {
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char7) ;
      seccion_impl.this.GXt_char6 = GXv_char7[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
   }

   public void checkExtendedTable1A153( )
   {
      nIsDirty_153 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal1A153( ) ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1987PuestoRelSec, GXv_boolean3) ;
         seccion_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV11CliCod) && ( ( GXutil.strcmp(A1240PuestoCodigo, O1240PuestoCodigo) != 0 ) || ( A1255PuestoHorasExt != O1255PuestoHorasExt ) ) ) && (0==A1987PuestoRelSec) )
      {
         GXCCtl = "PUESTOCODIGO_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtPuestoCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_153 = (short)(1) ;
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char7) ;
      seccion_impl.this.GXt_char6 = GXv_char7[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
   }

   public void closeExtendedTableCursors1A153( )
   {
   }

   public void enableDisable1A153( )
   {
   }

   public void getKey1A153( )
   {
      /* Using cursor T001A21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound153 = (short)(1) ;
      }
      else
      {
         RcdFound153 = (short)(0) ;
      }
      pr_default.close(19);
   }

   public void getByPrimaryKey1A153( )
   {
      /* Using cursor T001A3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1A153( 26) ;
         RcdFound153 = (short)(1) ;
         initializeNonKey1A153( ) ;
         A1242PuestoDescripSinAc = T001A3_A1242PuestoDescripSinAc[0] ;
         A1240PuestoCodigo = T001A3_A1240PuestoCodigo[0] ;
         A1241PuestoDescrip = T001A3_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = T001A3_A1255PuestoHorasExt[0] ;
         A1987PuestoRelSec = T001A3_A1987PuestoRelSec[0] ;
         A1988PuestoRelSecCli = T001A3_A1988PuestoRelSecCli[0] ;
         A1989PuestoPadre = T001A3_A1989PuestoPadre[0] ;
         A2016PuestoRelRef = T001A3_A2016PuestoRelRef[0] ;
         A2034PuestoOld = T001A3_A2034PuestoOld[0] ;
         O1240PuestoCodigo = A1240PuestoCodigo ;
         O1255PuestoHorasExt = A1255PuestoHorasExt ;
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
         Z1240PuestoCodigo = A1240PuestoCodigo ;
         sMode153 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1A153( ) ;
         Gx_mode = sMode153 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound153 = (short)(0) ;
         initializeNonKey1A153( ) ;
         sMode153 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1A153( ) ;
         Gx_mode = sMode153 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1A153( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency1A153( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001A2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Puesto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1242PuestoDescripSinAc, T001A2_A1242PuestoDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z1241PuestoDescrip, T001A2_A1241PuestoDescrip[0]) != 0 ) || ( Z1255PuestoHorasExt != T001A2_A1255PuestoHorasExt[0] ) || ( Z1987PuestoRelSec != T001A2_A1987PuestoRelSec[0] ) || ( Z1988PuestoRelSecCli != T001A2_A1988PuestoRelSecCli[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1989PuestoPadre, T001A2_A1989PuestoPadre[0]) != 0 ) || ( GXutil.strcmp(Z2016PuestoRelRef, T001A2_A2016PuestoRelRef[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1242PuestoDescripSinAc, T001A2_A1242PuestoDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"PuestoDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z1242PuestoDescripSinAc);
               GXutil.writeLogRaw("Current: ",T001A2_A1242PuestoDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z1241PuestoDescrip, T001A2_A1241PuestoDescrip[0]) != 0 )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"PuestoDescrip");
               GXutil.writeLogRaw("Old: ",Z1241PuestoDescrip);
               GXutil.writeLogRaw("Current: ",T001A2_A1241PuestoDescrip[0]);
            }
            if ( Z1255PuestoHorasExt != T001A2_A1255PuestoHorasExt[0] )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"PuestoHorasExt");
               GXutil.writeLogRaw("Old: ",Z1255PuestoHorasExt);
               GXutil.writeLogRaw("Current: ",T001A2_A1255PuestoHorasExt[0]);
            }
            if ( Z1987PuestoRelSec != T001A2_A1987PuestoRelSec[0] )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"PuestoRelSec");
               GXutil.writeLogRaw("Old: ",Z1987PuestoRelSec);
               GXutil.writeLogRaw("Current: ",T001A2_A1987PuestoRelSec[0]);
            }
            if ( Z1988PuestoRelSecCli != T001A2_A1988PuestoRelSecCli[0] )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"PuestoRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1988PuestoRelSecCli);
               GXutil.writeLogRaw("Current: ",T001A2_A1988PuestoRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z1989PuestoPadre, T001A2_A1989PuestoPadre[0]) != 0 )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"PuestoPadre");
               GXutil.writeLogRaw("Old: ",Z1989PuestoPadre);
               GXutil.writeLogRaw("Current: ",T001A2_A1989PuestoPadre[0]);
            }
            if ( GXutil.strcmp(Z2016PuestoRelRef, T001A2_A2016PuestoRelRef[0]) != 0 )
            {
               GXutil.writeLogln("seccion:[seudo value changed for attri]"+"PuestoRelRef");
               GXutil.writeLogRaw("Old: ",Z2016PuestoRelRef);
               GXutil.writeLogRaw("Current: ",T001A2_A2016PuestoRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Puesto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1A153( )
   {
      beforeValidate1A153( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1A153( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1A153( 0) ;
         checkOptimisticConcurrency1A153( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1A153( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1A153( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001A22 */
                  pr_default.execute(20, new Object[] {A1242PuestoDescripSinAc, Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
                  if ( (pr_default.getStatus(20) == 1) )
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
            load1A153( ) ;
         }
         endLevel1A153( ) ;
      }
      closeExtendedTableCursors1A153( ) ;
   }

   public void update1A153( )
   {
      beforeValidate1A153( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1A153( ) ;
      }
      if ( ( nIsMod_153 != 0 ) || ( nIsDirty_153 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency1A153( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm1A153( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate1A153( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001A23 */
                     pr_default.execute(21, new Object[] {A1242PuestoDescripSinAc, A1241PuestoDescrip, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld, Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
                     if ( (pr_default.getStatus(21) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Puesto"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate1A153( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey1A153( ) ;
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
            endLevel1A153( ) ;
         }
      }
      closeExtendedTableCursors1A153( ) ;
   }

   public void deferredUpdate1A153( )
   {
   }

   public void delete1A153( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1A153( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1A153( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1A153( ) ;
         afterConfirm1A153( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1A153( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001A24 */
               pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
      sMode153 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1A153( ) ;
      Gx_mode = sMode153 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1A153( )
   {
      standaloneModal1A153( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV15aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1987PuestoRelSec, GXv_boolean3) ;
            seccion_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001A25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionPuesto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T001A26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
      }
   }

   public void endLevel1A153( )
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

   public void scanStart1A153( )
   {
      /* Scan By routine */
      /* Using cursor T001A27 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      RcdFound153 = (short)(0) ;
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A1240PuestoCodigo = T001A27_A1240PuestoCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1A153( )
   {
      /* Scan next routine */
      pr_default.readNext(25);
      RcdFound153 = (short)(0) ;
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A1240PuestoCodigo = T001A27_A1240PuestoCodigo[0] ;
      }
   }

   public void scanEnd1A153( )
   {
      pr_default.close(25);
   }

   public void afterConfirm1A153( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV15aplicadoHay ) && ! (0==A1987PuestoRelSec) )
      {
         GXCCtl = "PUESTORELSEC_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV11CliCod), "PuestoRelSec", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = dynPuestoRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
      if ( ( isIns( )  || isUpd( )  ) && ( AV15aplicadoHay ) && ! (0==A1984SecRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV11CliCod), "SecRelSec", 1, "SECRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynSecRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert1A153( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1A153( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1A153( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1A153( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1A153( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1A153( )
   {
      edtPuestoCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      edtPuestoDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPuestoDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoDescrip_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      chkPuestoHorasExt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkPuestoHorasExt.getInternalname(), "Enabled", GXutil.ltrimstr( chkPuestoHorasExt.getEnabled(), 5, 0), !bGXsfl_51_Refreshing);
      dynPuestoRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynPuestoRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynPuestoRelSec.getEnabled(), 5, 0), !bGXsfl_51_Refreshing);
   }

   public void send_integrity_lvl_hashes1A153( )
   {
   }

   public void send_integrity_lvl_hashes1A43( )
   {
   }

   public void subsflControlProps_51153( )
   {
      edtPuestoCodigo_Internalname = "PUESTOCODIGO_"+sGXsfl_51_idx ;
      edtPuestoDescrip_Internalname = "PUESTODESCRIP_"+sGXsfl_51_idx ;
      chkPuestoHorasExt.setInternalname( "PUESTOHORASEXT_"+sGXsfl_51_idx );
      dynPuestoRelSec.setInternalname( "PUESTORELSEC_"+sGXsfl_51_idx );
   }

   public void subsflControlProps_fel_51153( )
   {
      edtPuestoCodigo_Internalname = "PUESTOCODIGO_"+sGXsfl_51_fel_idx ;
      edtPuestoDescrip_Internalname = "PUESTODESCRIP_"+sGXsfl_51_fel_idx ;
      chkPuestoHorasExt.setInternalname( "PUESTOHORASEXT_"+sGXsfl_51_fel_idx );
      dynPuestoRelSec.setInternalname( "PUESTORELSEC_"+sGXsfl_51_fel_idx );
   }

   public void addRow1A153( )
   {
      nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51153( ) ;
      sendRow1A153( ) ;
   }

   public void sendRow1A153( )
   {
      Gridlevel1Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         subGridlevel1_Backcolor = subGridlevel1_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
         subGridlevel1_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_51_idx) % (2))) == 0 )
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_153_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 52,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPuestoCodigo_Internalname,GXutil.rtrim( A1240PuestoCodigo),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPuestoCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtPuestoCodigo_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(51),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_153_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 53,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPuestoDescrip_Internalname,A1241PuestoDescrip,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPuestoDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtPuestoDescrip_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(51),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_153_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 54,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "PUESTOHORASEXT_" + sGXsfl_51_idx ;
      chkPuestoHorasExt.setName( GXCCtl );
      chkPuestoHorasExt.setWebtags( "" );
      chkPuestoHorasExt.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPuestoHorasExt.getInternalname(), "TitleCaption", chkPuestoHorasExt.getCaption(), !bGXsfl_51_Refreshing);
      chkPuestoHorasExt.setCheckedValue( "false" );
      A1255PuestoHorasExt = GXutil.strtobool( GXutil.booltostr( A1255PuestoHorasExt)) ;
      Gridlevel1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkPuestoHorasExt.getInternalname(),GXutil.booltostr( A1255PuestoHorasExt),"","",Integer.valueOf(-1),Integer.valueOf(chkPuestoHorasExt.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(54, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,54);\""});
      gxapuestorelsec_html1A153( AV11CliCod) ;
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_153_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 55,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      if ( ( dynPuestoRelSec.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "PUESTORELSEC_" + sGXsfl_51_idx ;
         dynPuestoRelSec.setName( GXCCtl );
         dynPuestoRelSec.setWebtags( "" );
      }
      /* ComboBox */
      Gridlevel1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynPuestoRelSec,dynPuestoRelSec.getInternalname(),GXutil.trim( GXutil.str( A1987PuestoRelSec, 6, 0)),Integer.valueOf(1),dynPuestoRelSec.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(dynPuestoRelSec.getVisible()),Integer.valueOf(dynPuestoRelSec.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,55);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynPuestoRelSec.setValue( GXutil.trim( GXutil.str( A1987PuestoRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynPuestoRelSec.getInternalname(), "Values", dynPuestoRelSec.ToJavascriptSource(), !bGXsfl_51_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes1A153( ) ;
      GXCCtl = "Z1240PuestoCodigo_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1240PuestoCodigo));
      GXCCtl = "Z1242PuestoDescripSinAc_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z1242PuestoDescripSinAc);
      GXCCtl = "Z1241PuestoDescrip_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z1241PuestoDescrip);
      GXCCtl = "Z1255PuestoHorasExt_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z1255PuestoHorasExt);
      GXCCtl = "Z1987PuestoRelSec_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1987PuestoRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1988PuestoRelSecCli_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1988PuestoRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1989PuestoPadre_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1989PuestoPadre));
      GXCCtl = "Z2016PuestoRelRef_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2016PuestoRelRef);
      GXCCtl = "O1240PuestoCodigo_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( O1240PuestoCodigo));
      GXCCtl = "O1255PuestoHorasExt_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, O1255PuestoHorasExt);
      GXCCtl = "nRcdDeleted_153_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_153_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_153_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_153, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vSECCODIGO_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV7SecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTOCODIGO_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPuestoCodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTODESCRIP_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPuestoDescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTOHORASEXT_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkPuestoHorasExt.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTORELSEC_"+sGXsfl_51_idx+"Visible", GXutil.ltrim( localUtil.ntoc( dynPuestoRelSec.getVisible(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTORELSEC_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynPuestoRelSec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow1A153( )
   {
      nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51153( ) ;
      edtPuestoCodigo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PUESTOCODIGO_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtPuestoDescrip_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PUESTODESCRIP_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      chkPuestoHorasExt.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "PUESTOHORASEXT_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      dynPuestoRelSec.setVisible( (int)(localUtil.ctol( httpContext.cgiGet( "PUESTORELSEC_"+sGXsfl_51_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      dynPuestoRelSec.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "PUESTORELSEC_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      A1240PuestoCodigo = httpContext.cgiGet( edtPuestoCodigo_Internalname) ;
      A1241PuestoDescrip = httpContext.cgiGet( edtPuestoDescrip_Internalname) ;
      A1255PuestoHorasExt = GXutil.strtobool( httpContext.cgiGet( chkPuestoHorasExt.getInternalname())) ;
      dynPuestoRelSec.setName( dynPuestoRelSec.getInternalname() );
      dynPuestoRelSec.setValue( httpContext.cgiGet( dynPuestoRelSec.getInternalname()) );
      A1987PuestoRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynPuestoRelSec.getInternalname()))) ;
      GXCCtl = "Z1240PuestoCodigo_" + sGXsfl_51_idx ;
      Z1240PuestoCodigo = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1242PuestoDescripSinAc_" + sGXsfl_51_idx ;
      Z1242PuestoDescripSinAc = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1241PuestoDescrip_" + sGXsfl_51_idx ;
      Z1241PuestoDescrip = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1255PuestoHorasExt_" + sGXsfl_51_idx ;
      Z1255PuestoHorasExt = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1987PuestoRelSec_" + sGXsfl_51_idx ;
      Z1987PuestoRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1988PuestoRelSecCli_" + sGXsfl_51_idx ;
      Z1988PuestoRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1989PuestoPadre_" + sGXsfl_51_idx ;
      Z1989PuestoPadre = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2016PuestoRelRef_" + sGXsfl_51_idx ;
      Z2016PuestoRelRef = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1242PuestoDescripSinAc_" + sGXsfl_51_idx ;
      A1242PuestoDescripSinAc = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1988PuestoRelSecCli_" + sGXsfl_51_idx ;
      A1988PuestoRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1989PuestoPadre_" + sGXsfl_51_idx ;
      A1989PuestoPadre = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2016PuestoRelRef_" + sGXsfl_51_idx ;
      A2016PuestoRelRef = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "O1240PuestoCodigo_" + sGXsfl_51_idx ;
      O1240PuestoCodigo = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "O1255PuestoHorasExt_" + sGXsfl_51_idx ;
      O1255PuestoHorasExt = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_153_" + sGXsfl_51_idx ;
      nRcdDeleted_153 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_153_" + sGXsfl_51_idx ;
      nRcdExists_153 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_153_" + sGXsfl_51_idx ;
      nIsMod_153 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtPuestoCodigo_Enabled = edtPuestoCodigo_Enabled ;
   }

   public void confirmValues1A0( )
   {
      nGXsfl_51_idx = 0 ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51153( ) ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_51153( ) ;
         httpContext.changePostValue( "Z1240PuestoCodigo_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z1240PuestoCodigo_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1240PuestoCodigo_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z1242PuestoDescripSinAc_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z1242PuestoDescripSinAc_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1242PuestoDescripSinAc_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z1241PuestoDescrip_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z1241PuestoDescrip_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1241PuestoDescrip_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z1255PuestoHorasExt_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z1255PuestoHorasExt_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1255PuestoHorasExt_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z1987PuestoRelSec_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z1987PuestoRelSec_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1987PuestoRelSec_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z1988PuestoRelSecCli_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z1988PuestoRelSecCli_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1988PuestoRelSecCli_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z1989PuestoPadre_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z1989PuestoPadre_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1989PuestoPadre_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z2016PuestoRelRef_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z2016PuestoRelRef_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2016PuestoRelRef_"+sGXsfl_51_idx) ;
      }
      httpContext.changePostValue( "O1240PuestoCodigo", httpContext.cgiGet( "T1240PuestoCodigo")) ;
      httpContext.deletePostValue( "T1240PuestoCodigo") ;
      httpContext.changePostValue( "O1255PuestoHorasExt", httpContext.cgiGet( "T1255PuestoHorasExt")) ;
      httpContext.deletePostValue( "T1255PuestoHorasExt") ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.seccion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7SecCodigo))}, new String[] {"Gx_mode","CliCod","SecCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Seccion");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("SecHabilitada", GXutil.booltostr( A330SecHabilitada));
      forbiddenHiddens.add("SecRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1985SecRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("SecPadre", GXutil.rtrim( localUtil.format( A1986SecPadre, "")));
      forbiddenHiddens.add("SecRelRef", GXutil.rtrim( localUtil.format( A2015SecRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("seccion:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z13SecCodigo", GXutil.rtrim( Z13SecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z675SecDescripSinAc", Z675SecDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z329SecDescrip", Z329SecDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z330SecHabilitada", Z330SecHabilitada);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1984SecRelSec", GXutil.ltrim( localUtil.ntoc( Z1984SecRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1985SecRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1985SecRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1986SecPadre", GXutil.rtrim( Z1986SecPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2015SecRelRef", Z2015SecRelRef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2308SecApoOpc", Z2308SecApoOpc);
      web.GxWebStd.gx_hidden_field( httpContext, "O329SecDescrip", O329SecDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "O13SecCodigo", GXutil.rtrim( O13SecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_51", GXutil.ltrim( localUtil.ntoc( nGXsfl_51_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "SECDESCRIPSINAC", A675SecDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV11CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vSECCODIGO", GXutil.rtrim( AV7SecCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7SecCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "SECHABILITADA", A330SecHabilitada);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV15aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "SECRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1985SecRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "SECPADRE", GXutil.rtrim( A1986SecPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "SECRELREF", A2015SecRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "SECOLD", A2033SecOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV17Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTODESCRIPSINAC", A1242PuestoDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTORELSECCLI", GXutil.ltrim( localUtil.ntoc( A1988PuestoRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTOPADRE", GXutil.rtrim( A1989PuestoPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTORELREF", A2016PuestoRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "PUESTOOLD", A2034PuestoOld);
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Objectcall", GXutil.rtrim( Dvpanel_unnamedtable1_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Enabled", GXutil.booltostr( Dvpanel_unnamedtable1_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
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
      return formatLink("web.seccion", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV7SecCodigo))}, new String[] {"Gx_mode","CliCod","SecCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "Seccion" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Area", "") ;
   }

   public void initializeNonKey1A43( )
   {
      AV15aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      A675SecDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A675SecDescripSinAc", A675SecDescripSinAc);
      A329SecDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
      A1984SecRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1984SecRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1984SecRelSec), 6, 0));
      A1985SecRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1985SecRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1985SecRelSecCli), 6, 0));
      A1986SecPadre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1986SecPadre", A1986SecPadre);
      A2015SecRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2015SecRelRef", A2015SecRelRef);
      A2033SecOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2033SecOld", A2033SecOld);
      A2308SecApoOpc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2308SecApoOpc", A2308SecApoOpc);
      A330SecHabilitada = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A330SecHabilitada", A330SecHabilitada);
      O329SecDescrip = A329SecDescrip ;
      httpContext.ajax_rsp_assign_attri("", false, "A329SecDescrip", A329SecDescrip);
      Z675SecDescripSinAc = "" ;
      Z329SecDescrip = "" ;
      Z330SecHabilitada = false ;
      Z1984SecRelSec = 0 ;
      Z1985SecRelSecCli = 0 ;
      Z1986SecPadre = "" ;
      Z2015SecRelRef = "" ;
      Z2308SecApoOpc = false ;
   }

   public void initAll1A43( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A13SecCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A13SecCodigo", A13SecCodigo);
      initializeNonKey1A43( ) ;
   }

   public void standaloneModalInsert( )
   {
      A330SecHabilitada = i330SecHabilitada ;
      httpContext.ajax_rsp_assign_attri("", false, "A330SecHabilitada", A330SecHabilitada);
   }

   public void initializeNonKey1A153( )
   {
      A1242PuestoDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
      A1241PuestoDescrip = "" ;
      A1255PuestoHorasExt = false ;
      A1987PuestoRelSec = 0 ;
      A1988PuestoRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1988PuestoRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1988PuestoRelSecCli), 6, 0));
      A1989PuestoPadre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1989PuestoPadre", A1989PuestoPadre);
      A2016PuestoRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2016PuestoRelRef", A2016PuestoRelRef);
      A2034PuestoOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2034PuestoOld", A2034PuestoOld);
      O1255PuestoHorasExt = A1255PuestoHorasExt ;
      Z1242PuestoDescripSinAc = "" ;
      Z1241PuestoDescrip = "" ;
      Z1255PuestoHorasExt = false ;
      Z1987PuestoRelSec = 0 ;
      Z1988PuestoRelSecCli = 0 ;
      Z1989PuestoPadre = "" ;
      Z2016PuestoRelRef = "" ;
   }

   public void initAll1A153( )
   {
      A1240PuestoCodigo = "" ;
      initializeNonKey1A153( ) ;
   }

   public void standaloneModalInsert1A153( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713583068", true, true);
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
      httpContext.AddJavascriptSource("seccion.js", "?20251713583069", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties153( )
   {
      edtPuestoCodigo_Enabled = defedtPuestoCodigo_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtPuestoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPuestoCodigo_Enabled), 5, 0), !bGXsfl_51_Refreshing);
   }

   public void startgridcontrol51( )
   {
      Gridlevel1Container.AddObjectProperty("GridName", "Gridlevel1");
      Gridlevel1Container.AddObjectProperty("Header", subGridlevel1_Header);
      Gridlevel1Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("CmpContext", "");
      Gridlevel1Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A1240PuestoCodigo));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPuestoCodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", A1241PuestoDescrip);
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPuestoDescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.booltostr( A1255PuestoHorasExt));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkPuestoHorasExt.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1987PuestoRelSec, (byte)(6), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( dynPuestoRelSec.getVisible(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynPuestoRelSec.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtSecCodigo_Internalname = "SECCODIGO" ;
      edtSecDescrip_Internalname = "SECDESCRIP" ;
      dynSecRelSec.setInternalname( "SECRELSEC" );
      divSecrelsec_cell_Internalname = "SECRELSEC_CELL" ;
      chkSecApoOpc.setInternalname( "SECAPOOPC" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtPuestoCodigo_Internalname = "PUESTOCODIGO" ;
      edtPuestoDescrip_Internalname = "PUESTODESCRIP" ;
      chkPuestoHorasExt.setInternalname( "PUESTOHORASEXT" );
      dynPuestoRelSec.setInternalname( "PUESTORELSEC" );
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel1_Internalname = "GRIDLEVEL1" ;
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
      subGridlevel1_Allowcollapsing = (byte)(0) ;
      subGridlevel1_Allowselection = (byte)(0) ;
      subGridlevel1_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Area", "") );
      dynPuestoRelSec.setJsonclick( "" );
      chkPuestoHorasExt.setCaption( "" );
      edtPuestoDescrip_Jsonclick = "" ;
      edtPuestoCodigo_Jsonclick = "" ;
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      dynPuestoRelSec.setEnabled( 1 );
      dynPuestoRelSec.setVisible( -1 );
      chkPuestoHorasExt.setEnabled( 1 );
      edtPuestoDescrip_Enabled = 1 ;
      edtPuestoCodigo_Enabled = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "Puestos", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      chkSecApoOpc.setEnabled( 1 );
      dynSecRelSec.setJsonclick( "" );
      dynSecRelSec.setEnabled( 1 );
      dynSecRelSec.setVisible( 1 );
      divSecrelsec_cell_Class = "col-xs-12 col-sm-6" ;
      edtSecDescrip_Enabled = 1 ;
      edtSecCodigo_Jsonclick = "" ;
      edtSecCodigo_Enabled = 1 ;
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

   public void gxdlasecrelsec1A43( int AV11CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlasecrelsec_data1A43( AV11CliCod) ;
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

   public void gxasecrelsec_html1A43( int AV11CliCod )
   {
      int gxdynajaxvalue;
      gxdlasecrelsec_data1A43( AV11CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynSecRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynSecRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlasecrelsec_data1A43( int AV11CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T001A28 */
      pr_default.execute(26, new Object[] {Integer.valueOf(AV11CliCod)});
      while ( (pr_default.getStatus(26) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T001A28_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T001A28_A1880CliReDTChar[0]);
         pr_default.readNext(26);
      }
      pr_default.close(26);
   }

   public void gxdlapuestorelsec1A153( int AV11CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlapuestorelsec_data1A153( AV11CliCod) ;
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

   public void gxapuestorelsec_html1A153( int AV11CliCod )
   {
      int gxdynajaxvalue;
      gxdlapuestorelsec_data1A153( AV11CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynPuestoRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynPuestoRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlapuestorelsec_data1A153( int AV11CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T001A29 */
      pr_default.execute(27, new Object[] {Integer.valueOf(AV11CliCod)});
      while ( (pr_default.getStatus(27) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T001A29_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T001A29_A1880CliReDTChar[0]);
         pr_default.readNext(27);
      }
      pr_default.close(27);
   }

   public void gx1asasecdescripsinac1A43( String A329SecDescrip )
   {
      GXt_char6 = A675SecDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char7) ;
      seccion_impl.this.GXt_char6 = GXv_char7[0] ;
      A675SecDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A675SecDescripSinAc", A675SecDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A675SecDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx2asaclicod1A43( int AV11CliCod )
   {
      if ( ! (0==AV11CliCod) )
      {
         A3CliCod = AV11CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            seccion_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
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

   public void gxasa19841A43( int AV11CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynSecRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynSecRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynSecRelSec.getVisible(), 5, 0), true);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxasa19871A43( int AV11CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynPuestoRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynPuestoRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynPuestoRelSec.getVisible(), 5, 0), !bGXsfl_51_Refreshing);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx18asapuestodescripsinac1A153( String A1241PuestoDescrip )
   {
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char7) ;
      seccion_impl.this.GXt_char6 = GXv_char7[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1242PuestoDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_16_1A43( String Gx_mode ,
                           int AV11CliCod ,
                           int A1984SecRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1984SecRelSec, GXv_boolean3) ;
         AV15aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV15aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_22_1A153( String Gx_mode ,
                            int AV11CliCod ,
                            int A1987PuestoRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1987PuestoRelSec, GXv_boolean3) ;
         AV15aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV15aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_51153( ) ;
      while ( nGXsfl_51_idx <= nRC_GXsfl_51 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1A153( ) ;
         standaloneModal1A153( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1A153( ) ;
         nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_51153( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      dynSecRelSec.setName( "SECRELSEC" );
      dynSecRelSec.setWebtags( "" );
      chkSecApoOpc.setName( "SECAPOOPC" );
      chkSecApoOpc.setWebtags( "" );
      chkSecApoOpc.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkSecApoOpc.getInternalname(), "TitleCaption", chkSecApoOpc.getCaption(), true);
      chkSecApoOpc.setCheckedValue( "false" );
      A2308SecApoOpc = GXutil.strtobool( GXutil.booltostr( A2308SecApoOpc)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2308SecApoOpc", A2308SecApoOpc);
      GXCCtl = "PUESTOHORASEXT_" + sGXsfl_51_idx ;
      chkPuestoHorasExt.setName( GXCCtl );
      chkPuestoHorasExt.setWebtags( "" );
      chkPuestoHorasExt.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkPuestoHorasExt.getInternalname(), "TitleCaption", chkPuestoHorasExt.getCaption(), !bGXsfl_51_Refreshing);
      chkPuestoHorasExt.setCheckedValue( "false" );
      A1255PuestoHorasExt = GXutil.strtobool( GXutil.booltostr( A1255PuestoHorasExt)) ;
      GXCCtl = "PUESTORELSEC_" + sGXsfl_51_idx ;
      dynPuestoRelSec.setName( GXCCtl );
      dynPuestoRelSec.setWebtags( "" );
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

   public void valid_Clicod( )
   {
      A1984SecRelSec = (int)(GXutil.lval( dynSecRelSec.getValue())) ;
      A1987PuestoRelSec = (int)(GXutil.lval( dynPuestoRelSec.getValue())) ;
      /* Using cursor T001A30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(28) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(28);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Secdescrip( )
   {
      A1984SecRelSec = (int)(GXutil.lval( dynSecRelSec.getValue())) ;
      A1987PuestoRelSec = (int)(GXutil.lval( dynPuestoRelSec.getValue())) ;
      GXt_char6 = A675SecDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char7) ;
      seccion_impl.this.GXt_char6 = GXv_char7[0] ;
      A675SecDescripSinAc = GXt_char6 ;
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
      seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) ) )
      {
         divSecrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 DataContentCell DscTop", "") ;
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV11CliCod, GXv_boolean3) ;
         seccion_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) )
         {
            divSecrelsec_cell_Class = httpContext.getMessage( "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "") ;
         }
      }
      if ( (GXutil.strcmp("", A329SecDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Area", ""), "", "", "", "", "", "", "", ""), 1, "SECDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecDescrip_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A675SecDescripSinAc", A675SecDescripSinAc);
      httpContext.ajax_rsp_assign_prop("", false, divSecrelsec_cell_Internalname, "Class", divSecrelsec_cell_Class, true);
   }

   public void valid_Secrelsec( )
   {
      A1984SecRelSec = (int)(GXutil.lval( dynSecRelSec.getValue())) ;
      A1987PuestoRelSec = (int)(GXutil.lval( dynPuestoRelSec.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV11CliCod) && ( ( GXutil.strcmp(A13SecCodigo, O13SecCodigo) != 0 ) || ( GXutil.strcmp(A329SecDescrip, O329SecDescrip) != 0 ) ) ) && (0==A1984SecRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "SECRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynSecRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1984SecRelSec, GXv_boolean3) ;
         seccion_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
         AV15aplicadoHay = this.AV15aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
   }

   public void valid_Puestodescrip( )
   {
      A1984SecRelSec = (int)(GXutil.lval( dynSecRelSec.getValue())) ;
      A1987PuestoRelSec = (int)(GXutil.lval( dynPuestoRelSec.getValue())) ;
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char7) ;
      seccion_impl.this.GXt_char6 = GXv_char7[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1242PuestoDescripSinAc", A1242PuestoDescripSinAc);
   }

   public void valid_Puestorelsec( )
   {
      A1984SecRelSec = (int)(GXutil.lval( dynSecRelSec.getValue())) ;
      A1987PuestoRelSec = (int)(GXutil.lval( dynPuestoRelSec.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV11CliCod) && ( ( GXutil.strcmp(A1240PuestoCodigo, O1240PuestoCodigo) != 0 ) || ( A1255PuestoHorasExt != O1255PuestoHorasExt ) ) ) && (0==A1987PuestoRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "PUESTORELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynPuestoRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV15aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV11CliCod, A1987PuestoRelSec, GXv_boolean3) ;
         seccion_impl.this.AV15aplicadoHay = GXv_boolean3[0] ;
         AV15aplicadoHay = this.AV15aplicadoHay ;
      }
      O1240PuestoCodigo = A1240PuestoCodigo ;
      O1255PuestoHorasExt = A1255PuestoHorasExt ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV15aplicadoHay", AV15aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SecCodigo',fld:'vSECCODIGO',pic:'',hsh:true},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SecCodigo',fld:'vSECCODIGO',pic:'',hsh:true},{av:'A330SecHabilitada',fld:'SECHABILITADA',pic:''},{av:'A1985SecRelSecCli',fld:'SECRELSECCLI',pic:'ZZZZZ9'},{av:'A1986SecPadre',fld:'SECPADRE',pic:''},{av:'A2015SecRelRef',fld:'SECRELREF',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e121A2',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("VALID_SECCODIGO","{handler:'valid_Seccodigo',iparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("VALID_SECCODIGO",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("VALID_SECDESCRIP","{handler:'valid_Secdescrip',iparms:[{av:'O329SecDescrip'},{av:'O13SecCodigo'},{av:'A329SecDescrip',fld:'SECDESCRIP',pic:''},{av:'A13SecCodigo',fld:'SECCODIGO',pic:''},{av:'dynPuestoRelSec'},{av:'A1987PuestoRelSec',fld:'PUESTORELSEC',pic:'ZZZZZ9'},{av:'A675SecDescripSinAc',fld:'SECDESCRIPSINAC',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("VALID_SECDESCRIP",",oparms:[{av:'A675SecDescripSinAc',fld:'SECDESCRIPSINAC',pic:''},{av:'divSecrelsec_cell_Class',ctrl:'SECRELSEC_CELL',prop:'Class'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("VALID_SECRELSEC","{handler:'valid_Secrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'O329SecDescrip'},{av:'O13SecCodigo'},{av:'A13SecCodigo',fld:'SECCODIGO',pic:''},{av:'A329SecDescrip',fld:'SECDESCRIP',pic:''},{av:'dynPuestoRelSec'},{av:'A1987PuestoRelSec',fld:'PUESTORELSEC',pic:'ZZZZZ9'},{av:'AV15aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("VALID_SECRELSEC",",oparms:[{av:'AV15aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynPuestoRelSec'},{av:'A1987PuestoRelSec',fld:'PUESTORELSEC',pic:'ZZZZZ9'},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("VALID_PUESTOCODIGO","{handler:'valid_Puestocodigo',iparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("VALID_PUESTOCODIGO",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("VALID_PUESTODESCRIP","{handler:'valid_Puestodescrip',iparms:[{av:'A1241PuestoDescrip',fld:'PUESTODESCRIP',pic:''},{av:'dynPuestoRelSec'},{av:'A1987PuestoRelSec',fld:'PUESTORELSEC',pic:'ZZZZZ9'},{av:'A1242PuestoDescripSinAc',fld:'PUESTODESCRIPSINAC',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("VALID_PUESTODESCRIP",",oparms:[{av:'A1242PuestoDescripSinAc',fld:'PUESTODESCRIPSINAC',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("VALID_PUESTOHORASEXT","{handler:'valid_Puestohorasext',iparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("VALID_PUESTOHORASEXT",",oparms:[{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
      setEventMetadata("VALID_PUESTORELSEC","{handler:'valid_Puestorelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'O1255PuestoHorasExt'},{av:'O1240PuestoCodigo'},{av:'A1240PuestoCodigo',fld:'PUESTOCODIGO',pic:''},{av:'A1255PuestoHorasExt',fld:'PUESTOHORASEXT',pic:''},{av:'dynPuestoRelSec'},{av:'A1987PuestoRelSec',fld:'PUESTORELSEC',pic:'ZZZZZ9'},{av:'AV15aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]");
      setEventMetadata("VALID_PUESTORELSEC",",oparms:[{av:'AV15aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV11CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynSecRelSec'},{av:'A1984SecRelSec',fld:'SECRELSEC',pic:'ZZZZZ9'},{av:'A2308SecApoOpc',fld:'SECAPOOPC',pic:''}]}");
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
      return "seccion_Execute";
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
      pr_default.close(28);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7SecCodigo = "" ;
      Z13SecCodigo = "" ;
      Z675SecDescripSinAc = "" ;
      Z329SecDescrip = "" ;
      Z1986SecPadre = "" ;
      Z2015SecRelRef = "" ;
      O329SecDescrip = "" ;
      O13SecCodigo = "" ;
      Z1240PuestoCodigo = "" ;
      Z1242PuestoDescripSinAc = "" ;
      Z1241PuestoDescrip = "" ;
      Z1989PuestoPadre = "" ;
      Z2016PuestoRelRef = "" ;
      O1240PuestoCodigo = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A329SecDescrip = "" ;
      A1241PuestoDescrip = "" ;
      AV7SecCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A13SecCodigo = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      B329SecDescrip = "" ;
      B13SecCodigo = "" ;
      sMode153 = "" ;
      sStyleString = "" ;
      A675SecDescripSinAc = "" ;
      A1986SecPadre = "" ;
      A2015SecRelRef = "" ;
      A2033SecOld = "" ;
      AV17Pgmname = "" ;
      A1242PuestoDescripSinAc = "" ;
      A1989PuestoPadre = "" ;
      A2016PuestoRelRef = "" ;
      A2034PuestoOld = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_unnamedtable1_Objectcall = "" ;
      Dvpanel_unnamedtable1_Class = "" ;
      Dvpanel_unnamedtable1_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode43 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A1240PuestoCodigo = "" ;
      T1240PuestoCodigo = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      Z2033SecOld = "" ;
      T001A7_A675SecDescripSinAc = new String[] {""} ;
      T001A7_A13SecCodigo = new String[] {""} ;
      T001A7_A329SecDescrip = new String[] {""} ;
      T001A7_A330SecHabilitada = new boolean[] {false} ;
      T001A7_A1984SecRelSec = new int[1] ;
      T001A7_A1985SecRelSecCli = new int[1] ;
      T001A7_A1986SecPadre = new String[] {""} ;
      T001A7_A2015SecRelRef = new String[] {""} ;
      T001A7_A2033SecOld = new String[] {""} ;
      T001A7_A2308SecApoOpc = new boolean[] {false} ;
      T001A7_A3CliCod = new int[1] ;
      T001A6_A3CliCod = new int[1] ;
      T001A8_A3CliCod = new int[1] ;
      T001A9_A3CliCod = new int[1] ;
      T001A9_A13SecCodigo = new String[] {""} ;
      T001A5_A675SecDescripSinAc = new String[] {""} ;
      T001A5_A13SecCodigo = new String[] {""} ;
      T001A5_A329SecDescrip = new String[] {""} ;
      T001A5_A330SecHabilitada = new boolean[] {false} ;
      T001A5_A1984SecRelSec = new int[1] ;
      T001A5_A1985SecRelSecCli = new int[1] ;
      T001A5_A1986SecPadre = new String[] {""} ;
      T001A5_A2015SecRelRef = new String[] {""} ;
      T001A5_A2033SecOld = new String[] {""} ;
      T001A5_A2308SecApoOpc = new boolean[] {false} ;
      T001A5_A3CliCod = new int[1] ;
      T001A10_A3CliCod = new int[1] ;
      T001A10_A13SecCodigo = new String[] {""} ;
      T001A11_A3CliCod = new int[1] ;
      T001A11_A13SecCodigo = new String[] {""} ;
      T001A4_A675SecDescripSinAc = new String[] {""} ;
      T001A4_A13SecCodigo = new String[] {""} ;
      T001A4_A329SecDescrip = new String[] {""} ;
      T001A4_A330SecHabilitada = new boolean[] {false} ;
      T001A4_A1984SecRelSec = new int[1] ;
      T001A4_A1985SecRelSecCli = new int[1] ;
      T001A4_A1986SecPadre = new String[] {""} ;
      T001A4_A2015SecRelRef = new String[] {""} ;
      T001A4_A2033SecOld = new String[] {""} ;
      T001A4_A2308SecApoOpc = new boolean[] {false} ;
      T001A4_A3CliCod = new int[1] ;
      T001A15_A3CliCod = new int[1] ;
      T001A15_A1EmpCod = new short[1] ;
      T001A15_A31LiqNro = new int[1] ;
      T001A15_A2145LiqArea = new String[] {""} ;
      T001A16_A3CliCod = new int[1] ;
      T001A16_A1EmpCod = new short[1] ;
      T001A16_A6LegNumero = new int[1] ;
      T001A17_A3CliCod = new int[1] ;
      T001A17_A1EmpCod = new short[1] ;
      T001A17_A31LiqNro = new int[1] ;
      T001A17_A6LegNumero = new int[1] ;
      T001A18_A3CliCod = new int[1] ;
      T001A18_A1EmpCod = new short[1] ;
      T001A18_A6LegNumero = new int[1] ;
      T001A19_A3CliCod = new int[1] ;
      T001A19_A13SecCodigo = new String[] {""} ;
      Z2034PuestoOld = "" ;
      T001A20_A1242PuestoDescripSinAc = new String[] {""} ;
      T001A20_A3CliCod = new int[1] ;
      T001A20_A13SecCodigo = new String[] {""} ;
      T001A20_A1240PuestoCodigo = new String[] {""} ;
      T001A20_A1241PuestoDescrip = new String[] {""} ;
      T001A20_A1255PuestoHorasExt = new boolean[] {false} ;
      T001A20_A1987PuestoRelSec = new int[1] ;
      T001A20_A1988PuestoRelSecCli = new int[1] ;
      T001A20_A1989PuestoPadre = new String[] {""} ;
      T001A20_A2016PuestoRelRef = new String[] {""} ;
      T001A20_A2034PuestoOld = new String[] {""} ;
      T001A21_A3CliCod = new int[1] ;
      T001A21_A13SecCodigo = new String[] {""} ;
      T001A21_A1240PuestoCodigo = new String[] {""} ;
      T001A3_A1242PuestoDescripSinAc = new String[] {""} ;
      T001A3_A3CliCod = new int[1] ;
      T001A3_A13SecCodigo = new String[] {""} ;
      T001A3_A1240PuestoCodigo = new String[] {""} ;
      T001A3_A1241PuestoDescrip = new String[] {""} ;
      T001A3_A1255PuestoHorasExt = new boolean[] {false} ;
      T001A3_A1987PuestoRelSec = new int[1] ;
      T001A3_A1988PuestoRelSecCli = new int[1] ;
      T001A3_A1989PuestoPadre = new String[] {""} ;
      T001A3_A2016PuestoRelRef = new String[] {""} ;
      T001A3_A2034PuestoOld = new String[] {""} ;
      T001A2_A1242PuestoDescripSinAc = new String[] {""} ;
      T001A2_A3CliCod = new int[1] ;
      T001A2_A13SecCodigo = new String[] {""} ;
      T001A2_A1240PuestoCodigo = new String[] {""} ;
      T001A2_A1241PuestoDescrip = new String[] {""} ;
      T001A2_A1255PuestoHorasExt = new boolean[] {false} ;
      T001A2_A1987PuestoRelSec = new int[1] ;
      T001A2_A1988PuestoRelSecCli = new int[1] ;
      T001A2_A1989PuestoPadre = new String[] {""} ;
      T001A2_A2016PuestoRelRef = new String[] {""} ;
      T001A2_A2034PuestoOld = new String[] {""} ;
      T001A25_A3CliCod = new int[1] ;
      T001A25_A1EmpCod = new short[1] ;
      T001A25_A31LiqNro = new int[1] ;
      T001A25_A2145LiqArea = new String[] {""} ;
      T001A25_A2146LiqPuesto = new String[] {""} ;
      T001A26_A3CliCod = new int[1] ;
      T001A26_A1EmpCod = new short[1] ;
      T001A26_A6LegNumero = new int[1] ;
      T001A27_A3CliCod = new int[1] ;
      T001A27_A13SecCodigo = new String[] {""} ;
      T001A27_A1240PuestoCodigo = new String[] {""} ;
      Gridlevel1Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel1_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel1Column = new com.genexus.webpanels.GXWebColumn();
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T001A28_A3CliCod = new int[1] ;
      T001A28_A1885CliRelSec = new int[1] ;
      T001A28_A1880CliReDTChar = new String[] {""} ;
      T001A29_A3CliCod = new int[1] ;
      T001A29_A1885CliRelSec = new int[1] ;
      T001A29_A1880CliReDTChar = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T001A30_A3CliCod = new int[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.seccion__default(),
         new Object[] {
             new Object[] {
            T001A2_A1242PuestoDescripSinAc, T001A2_A3CliCod, T001A2_A13SecCodigo, T001A2_A1240PuestoCodigo, T001A2_A1241PuestoDescrip, T001A2_A1255PuestoHorasExt, T001A2_A1987PuestoRelSec, T001A2_A1988PuestoRelSecCli, T001A2_A1989PuestoPadre, T001A2_A2016PuestoRelRef,
            T001A2_A2034PuestoOld
            }
            , new Object[] {
            T001A3_A1242PuestoDescripSinAc, T001A3_A3CliCod, T001A3_A13SecCodigo, T001A3_A1240PuestoCodigo, T001A3_A1241PuestoDescrip, T001A3_A1255PuestoHorasExt, T001A3_A1987PuestoRelSec, T001A3_A1988PuestoRelSecCli, T001A3_A1989PuestoPadre, T001A3_A2016PuestoRelRef,
            T001A3_A2034PuestoOld
            }
            , new Object[] {
            T001A4_A675SecDescripSinAc, T001A4_A13SecCodigo, T001A4_A329SecDescrip, T001A4_A330SecHabilitada, T001A4_A1984SecRelSec, T001A4_A1985SecRelSecCli, T001A4_A1986SecPadre, T001A4_A2015SecRelRef, T001A4_A2033SecOld, T001A4_A2308SecApoOpc,
            T001A4_A3CliCod
            }
            , new Object[] {
            T001A5_A675SecDescripSinAc, T001A5_A13SecCodigo, T001A5_A329SecDescrip, T001A5_A330SecHabilitada, T001A5_A1984SecRelSec, T001A5_A1985SecRelSecCli, T001A5_A1986SecPadre, T001A5_A2015SecRelRef, T001A5_A2033SecOld, T001A5_A2308SecApoOpc,
            T001A5_A3CliCod
            }
            , new Object[] {
            T001A6_A3CliCod
            }
            , new Object[] {
            T001A7_A675SecDescripSinAc, T001A7_A13SecCodigo, T001A7_A329SecDescrip, T001A7_A330SecHabilitada, T001A7_A1984SecRelSec, T001A7_A1985SecRelSecCli, T001A7_A1986SecPadre, T001A7_A2015SecRelRef, T001A7_A2033SecOld, T001A7_A2308SecApoOpc,
            T001A7_A3CliCod
            }
            , new Object[] {
            T001A8_A3CliCod
            }
            , new Object[] {
            T001A9_A3CliCod, T001A9_A13SecCodigo
            }
            , new Object[] {
            T001A10_A3CliCod, T001A10_A13SecCodigo
            }
            , new Object[] {
            T001A11_A3CliCod, T001A11_A13SecCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001A15_A3CliCod, T001A15_A1EmpCod, T001A15_A31LiqNro, T001A15_A2145LiqArea
            }
            , new Object[] {
            T001A16_A3CliCod, T001A16_A1EmpCod, T001A16_A6LegNumero
            }
            , new Object[] {
            T001A17_A3CliCod, T001A17_A1EmpCod, T001A17_A31LiqNro, T001A17_A6LegNumero
            }
            , new Object[] {
            T001A18_A3CliCod, T001A18_A1EmpCod, T001A18_A6LegNumero
            }
            , new Object[] {
            T001A19_A3CliCod, T001A19_A13SecCodigo
            }
            , new Object[] {
            T001A20_A1242PuestoDescripSinAc, T001A20_A3CliCod, T001A20_A13SecCodigo, T001A20_A1240PuestoCodigo, T001A20_A1241PuestoDescrip, T001A20_A1255PuestoHorasExt, T001A20_A1987PuestoRelSec, T001A20_A1988PuestoRelSecCli, T001A20_A1989PuestoPadre, T001A20_A2016PuestoRelRef,
            T001A20_A2034PuestoOld
            }
            , new Object[] {
            T001A21_A3CliCod, T001A21_A13SecCodigo, T001A21_A1240PuestoCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001A25_A3CliCod, T001A25_A1EmpCod, T001A25_A31LiqNro, T001A25_A2145LiqArea, T001A25_A2146LiqPuesto
            }
            , new Object[] {
            T001A26_A3CliCod, T001A26_A1EmpCod, T001A26_A6LegNumero
            }
            , new Object[] {
            T001A27_A3CliCod, T001A27_A13SecCodigo, T001A27_A1240PuestoCodigo
            }
            , new Object[] {
            T001A28_A3CliCod, T001A28_A1885CliRelSec, T001A28_A1880CliReDTChar
            }
            , new Object[] {
            T001A29_A3CliCod, T001A29_A1885CliRelSec, T001A29_A1880CliReDTChar
            }
            , new Object[] {
            T001A30_A3CliCod
            }
         }
      );
      AV17Pgmname = "Seccion" ;
      Z330SecHabilitada = true ;
      A330SecHabilitada = true ;
      i330SecHabilitada = true ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel1_Backcolorstyle ;
   private byte subGridlevel1_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel1_Allowselection ;
   private byte subGridlevel1_Allowhovering ;
   private byte subGridlevel1_Allowcollapsing ;
   private byte subGridlevel1_Collapsed ;
   private short nRcdDeleted_153 ;
   private short nRcdExists_153 ;
   private short nIsMod_153 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount153 ;
   private short RcdFound153 ;
   private short nBlankRcdUsr153 ;
   private short RcdFound43 ;
   private short nIsDirty_43 ;
   private short nIsDirty_153 ;
   private int wcpOAV11CliCod ;
   private int Z3CliCod ;
   private int Z1984SecRelSec ;
   private int Z1985SecRelSecCli ;
   private int nRC_GXsfl_51 ;
   private int nGXsfl_51_idx=1 ;
   private int Z1987PuestoRelSec ;
   private int Z1988PuestoRelSecCli ;
   private int AV11CliCod ;
   private int A1984SecRelSec ;
   private int A1987PuestoRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtSecCodigo_Enabled ;
   private int edtSecDescrip_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtPuestoCodigo_Enabled ;
   private int edtPuestoDescrip_Enabled ;
   private int fRowAdded ;
   private int A1985SecRelSecCli ;
   private int A1988PuestoRelSecCli ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Dvpanel_unnamedtable1_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defedtPuestoCodigo_Enabled ;
   private int idxLst ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7SecCodigo ;
   private String Z13SecCodigo ;
   private String Z1986SecPadre ;
   private String O13SecCodigo ;
   private String Z1240PuestoCodigo ;
   private String Z1989PuestoPadre ;
   private String O1240PuestoCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7SecCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSecCodigo_Internalname ;
   private String sGXsfl_51_idx="0001" ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String divTableheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String A13SecCodigo ;
   private String edtSecCodigo_Jsonclick ;
   private String edtSecDescrip_Internalname ;
   private String divSecrelsec_cell_Internalname ;
   private String divSecrelsec_cell_Class ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String B13SecCodigo ;
   private String sMode153 ;
   private String edtPuestoCodigo_Internalname ;
   private String edtPuestoDescrip_Internalname ;
   private String sStyleString ;
   private String subGridlevel1_Internalname ;
   private String A1986SecPadre ;
   private String AV17Pgmname ;
   private String A1989PuestoPadre ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_unnamedtable1_Objectcall ;
   private String Dvpanel_unnamedtable1_Class ;
   private String Dvpanel_unnamedtable1_Height ;
   private String hsh ;
   private String sMode43 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A1240PuestoCodigo ;
   private String T1240PuestoCodigo ;
   private String sGXsfl_51_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String ROClassString ;
   private String edtPuestoCodigo_Jsonclick ;
   private String edtPuestoDescrip_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel1_Header ;
   private String gxwrpcisep ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean Z330SecHabilitada ;
   private boolean Z2308SecApoOpc ;
   private boolean Z1255PuestoHorasExt ;
   private boolean O1255PuestoHorasExt ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A2308SecApoOpc ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean bGXsfl_51_Refreshing=false ;
   private boolean A330SecHabilitada ;
   private boolean AV15aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_unnamedtable1_Enabled ;
   private boolean Dvpanel_unnamedtable1_Showheader ;
   private boolean Dvpanel_unnamedtable1_Visible ;
   private boolean A1255PuestoHorasExt ;
   private boolean T1255PuestoHorasExt ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean Gx_longc ;
   private boolean i330SecHabilitada ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean2 ;
   private boolean ZV15aplicadoHay ;
   private boolean GXv_boolean3[] ;
   private String A2033SecOld ;
   private String A2034PuestoOld ;
   private String Z2033SecOld ;
   private String Z2034PuestoOld ;
   private String Z675SecDescripSinAc ;
   private String Z329SecDescrip ;
   private String Z2015SecRelRef ;
   private String O329SecDescrip ;
   private String Z1242PuestoDescripSinAc ;
   private String Z1241PuestoDescrip ;
   private String Z2016PuestoRelRef ;
   private String A329SecDescrip ;
   private String A1241PuestoDescrip ;
   private String B329SecDescrip ;
   private String A675SecDescripSinAc ;
   private String A2015SecRelRef ;
   private String A1242PuestoDescripSinAc ;
   private String A2016PuestoRelRef ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynSecRelSec ;
   private ICheckbox chkSecApoOpc ;
   private ICheckbox chkPuestoHorasExt ;
   private HTMLChoice dynPuestoRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] T001A7_A675SecDescripSinAc ;
   private String[] T001A7_A13SecCodigo ;
   private String[] T001A7_A329SecDescrip ;
   private boolean[] T001A7_A330SecHabilitada ;
   private int[] T001A7_A1984SecRelSec ;
   private int[] T001A7_A1985SecRelSecCli ;
   private String[] T001A7_A1986SecPadre ;
   private String[] T001A7_A2015SecRelRef ;
   private String[] T001A7_A2033SecOld ;
   private boolean[] T001A7_A2308SecApoOpc ;
   private int[] T001A7_A3CliCod ;
   private int[] T001A6_A3CliCod ;
   private int[] T001A8_A3CliCod ;
   private int[] T001A9_A3CliCod ;
   private String[] T001A9_A13SecCodigo ;
   private String[] T001A5_A675SecDescripSinAc ;
   private String[] T001A5_A13SecCodigo ;
   private String[] T001A5_A329SecDescrip ;
   private boolean[] T001A5_A330SecHabilitada ;
   private int[] T001A5_A1984SecRelSec ;
   private int[] T001A5_A1985SecRelSecCli ;
   private String[] T001A5_A1986SecPadre ;
   private String[] T001A5_A2015SecRelRef ;
   private String[] T001A5_A2033SecOld ;
   private boolean[] T001A5_A2308SecApoOpc ;
   private int[] T001A5_A3CliCod ;
   private int[] T001A10_A3CliCod ;
   private String[] T001A10_A13SecCodigo ;
   private int[] T001A11_A3CliCod ;
   private String[] T001A11_A13SecCodigo ;
   private String[] T001A4_A675SecDescripSinAc ;
   private String[] T001A4_A13SecCodigo ;
   private String[] T001A4_A329SecDescrip ;
   private boolean[] T001A4_A330SecHabilitada ;
   private int[] T001A4_A1984SecRelSec ;
   private int[] T001A4_A1985SecRelSecCli ;
   private String[] T001A4_A1986SecPadre ;
   private String[] T001A4_A2015SecRelRef ;
   private String[] T001A4_A2033SecOld ;
   private boolean[] T001A4_A2308SecApoOpc ;
   private int[] T001A4_A3CliCod ;
   private int[] T001A15_A3CliCod ;
   private short[] T001A15_A1EmpCod ;
   private int[] T001A15_A31LiqNro ;
   private String[] T001A15_A2145LiqArea ;
   private int[] T001A16_A3CliCod ;
   private short[] T001A16_A1EmpCod ;
   private int[] T001A16_A6LegNumero ;
   private int[] T001A17_A3CliCod ;
   private short[] T001A17_A1EmpCod ;
   private int[] T001A17_A31LiqNro ;
   private int[] T001A17_A6LegNumero ;
   private int[] T001A18_A3CliCod ;
   private short[] T001A18_A1EmpCod ;
   private int[] T001A18_A6LegNumero ;
   private int[] T001A19_A3CliCod ;
   private String[] T001A19_A13SecCodigo ;
   private String[] T001A20_A1242PuestoDescripSinAc ;
   private int[] T001A20_A3CliCod ;
   private String[] T001A20_A13SecCodigo ;
   private String[] T001A20_A1240PuestoCodigo ;
   private String[] T001A20_A1241PuestoDescrip ;
   private boolean[] T001A20_A1255PuestoHorasExt ;
   private int[] T001A20_A1987PuestoRelSec ;
   private int[] T001A20_A1988PuestoRelSecCli ;
   private String[] T001A20_A1989PuestoPadre ;
   private String[] T001A20_A2016PuestoRelRef ;
   private String[] T001A20_A2034PuestoOld ;
   private int[] T001A21_A3CliCod ;
   private String[] T001A21_A13SecCodigo ;
   private String[] T001A21_A1240PuestoCodigo ;
   private String[] T001A3_A1242PuestoDescripSinAc ;
   private int[] T001A3_A3CliCod ;
   private String[] T001A3_A13SecCodigo ;
   private String[] T001A3_A1240PuestoCodigo ;
   private String[] T001A3_A1241PuestoDescrip ;
   private boolean[] T001A3_A1255PuestoHorasExt ;
   private int[] T001A3_A1987PuestoRelSec ;
   private int[] T001A3_A1988PuestoRelSecCli ;
   private String[] T001A3_A1989PuestoPadre ;
   private String[] T001A3_A2016PuestoRelRef ;
   private String[] T001A3_A2034PuestoOld ;
   private String[] T001A2_A1242PuestoDescripSinAc ;
   private int[] T001A2_A3CliCod ;
   private String[] T001A2_A13SecCodigo ;
   private String[] T001A2_A1240PuestoCodigo ;
   private String[] T001A2_A1241PuestoDescrip ;
   private boolean[] T001A2_A1255PuestoHorasExt ;
   private int[] T001A2_A1987PuestoRelSec ;
   private int[] T001A2_A1988PuestoRelSecCli ;
   private String[] T001A2_A1989PuestoPadre ;
   private String[] T001A2_A2016PuestoRelRef ;
   private String[] T001A2_A2034PuestoOld ;
   private int[] T001A25_A3CliCod ;
   private short[] T001A25_A1EmpCod ;
   private int[] T001A25_A31LiqNro ;
   private String[] T001A25_A2145LiqArea ;
   private String[] T001A25_A2146LiqPuesto ;
   private int[] T001A26_A3CliCod ;
   private short[] T001A26_A1EmpCod ;
   private int[] T001A26_A6LegNumero ;
   private int[] T001A27_A3CliCod ;
   private String[] T001A27_A13SecCodigo ;
   private String[] T001A27_A1240PuestoCodigo ;
   private int[] T001A28_A3CliCod ;
   private int[] T001A28_A1885CliRelSec ;
   private String[] T001A28_A1880CliReDTChar ;
   private int[] T001A29_A3CliCod ;
   private int[] T001A29_A1885CliRelSec ;
   private String[] T001A29_A1880CliReDTChar ;
   private int[] T001A30_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class seccion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001A2", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?  FOR UPDATE OF Puesto NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A3", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A4", "SELECT SecDescripSinAc, SecCodigo, SecDescrip, SecHabilitada, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecApoOpc, CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ?  FOR UPDATE OF Seccion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A5", "SELECT SecDescripSinAc, SecCodigo, SecDescrip, SecHabilitada, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecApoOpc, CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A7", "SELECT TM1.SecDescripSinAc, TM1.SecCodigo, TM1.SecDescrip, TM1.SecHabilitada, TM1.SecRelSec, TM1.SecRelSecCli, TM1.SecPadre, TM1.SecRelRef, TM1.SecOld, TM1.SecApoOpc, TM1.CliCod FROM Seccion TM1 WHERE TM1.CliCod = ? and TM1.SecCodigo = ( ?) ORDER BY TM1.CliCod, TM1.SecCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A8", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A9", "SELECT CliCod, SecCodigo FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A10", "SELECT CliCod, SecCodigo FROM Seccion WHERE ( CliCod > ? or CliCod = ? and SecCodigo > ( ?)) ORDER BY CliCod, SecCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001A11", "SELECT CliCod, SecCodigo FROM Seccion WHERE ( CliCod < ? or CliCod = ? and SecCodigo < ( ?)) ORDER BY CliCod DESC, SecCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001A12", "SAVEPOINT gxupdate;INSERT INTO Seccion(SecDescripSinAc, SecCodigo, SecDescrip, SecHabilitada, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecApoOpc, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001A13", "SAVEPOINT gxupdate;UPDATE Seccion SET SecDescripSinAc=?, SecDescrip=?, SecHabilitada=?, SecRelSec=?, SecRelSecCli=?, SecPadre=?, SecRelRef=?, SecOld=?, SecApoOpc=?  WHERE CliCod = ? AND SecCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001A14", "SAVEPOINT gxupdate;DELETE FROM Seccion  WHERE CliCod = ? AND SecCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001A15", "SELECT CliCod, EmpCod, LiqNro, LiqArea FROM LiquidacionArea WHERE CliCod = ? AND LiqArea = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001A16", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegSecCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001A17", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? AND LiqSecCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001A18", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegSecCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001A19", "SELECT CliCod, SecCodigo FROM Seccion ORDER BY CliCod, SecCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A20", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? and SecCodigo = ( ?) and PuestoCodigo = ( ?) ORDER BY CliCod, SecCodigo, PuestoCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A21", "SELECT CliCod, SecCodigo, PuestoCodigo FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001A22", "SAVEPOINT gxupdate;INSERT INTO Puesto(PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001A23", "SAVEPOINT gxupdate;UPDATE Puesto SET PuestoDescripSinAc=?, PuestoDescrip=?, PuestoHorasExt=?, PuestoRelSec=?, PuestoRelSecCli=?, PuestoPadre=?, PuestoRelRef=?, PuestoOld=?  WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001A24", "SAVEPOINT gxupdate;DELETE FROM Puesto  WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001A25", "SELECT CliCod, EmpCod, LiqNro, LiqArea, LiqPuesto FROM LiquidacionPuesto WHERE CliCod = ? AND LiqArea = ? AND LiqPuesto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001A26", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegSecCodigo = ? AND LegPuesCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001A27", "SELECT CliCod, SecCodigo, PuestoCodigo FROM Puesto WHERE CliCod = ? and SecCodigo = ( ?) ORDER BY CliCod, SecCodigo, PuestoCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A28", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A29", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001A30", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setString(11, (String)parms[10], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 20 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 21 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

