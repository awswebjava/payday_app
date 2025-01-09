package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class escalasalarial_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action24") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1891CatSalRelSec = (int)(GXutil.lval( httpContext.GetPar( "CatSalRelSec"))) ;
         n1891CatSalRelSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_24_4P206( Gx_mode, AV7CliCod, A1891CatSalRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CATCODIGO") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
         AV9CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CliConvenio", AV9CliConvenio);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlacatcodigo4P206( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CATSALRELSEC") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlacatsalrelsec4P206( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asaclicod4P206( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_27") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = httpContext.GetPar( "CatCodigo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_27( A3CliCod, A1564CliPaiConve, A1565CliConvenio, A8CatCodigo) ;
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
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
            AV9CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CliConvenio", AV9CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
            AV10CatCodigo = httpContext.GetPar( "CatCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CatCodigo", AV10CatCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10CatCodigo, ""))));
            AV11CatVigencia = localUtil.parseDateParm( httpContext.GetPar( "CatVigencia")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11CatVigencia", localUtil.format(AV11CatVigencia, "99/99/9999"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATVIGENCIA", getSecureSignedToken( "", AV11CatVigencia));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Escala Salarial", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynCatCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public escalasalarial_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public escalasalarial_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escalasalarial_impl.class ));
   }

   public escalasalarial_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynCatCodigo = new HTMLChoice();
      dynCatSalRelSec = new HTMLChoice();
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
      if ( dynCatCodigo.getItemCount() > 0 )
      {
         A8CatCodigo = dynCatCodigo.getValidValue(A8CatCodigo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCatCodigo.setValue( GXutil.rtrim( A8CatCodigo) );
         httpContext.ajax_rsp_assign_prop("", false, dynCatCodigo.getInternalname(), "Values", dynCatCodigo.ToJavascriptSource(), true);
      }
      if ( dynCatSalRelSec.getItemCount() > 0 )
      {
         A1891CatSalRelSec = (int)(GXutil.lval( dynCatSalRelSec.getValidValue(GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0))))) ;
         n1891CatSalRelSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCatSalRelSec.setValue( GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Values", dynCatSalRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCatCodigo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCatCodigo.getInternalname(), httpContext.getMessage( "Categoria", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCatCodigo, dynCatCodigo.getInternalname(), GXutil.rtrim( A8CatCodigo), 1, dynCatCodigo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynCatCodigo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_EscalaSalarial.htm");
      dynCatCodigo.setValue( GXutil.rtrim( A8CatCodigo) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatCodigo.getInternalname(), "Values", dynCatCodigo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatVigencia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatVigencia_Internalname, httpContext.getMessage( "Vigencia desde", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCatVigencia_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCatVigencia_Internalname, localUtil.format(A907CatVigencia, "99/99/9999"), localUtil.format( A907CatVigencia, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCatVigencia_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtCatVigencia_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_EscalaSalarial.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtCatVigencia_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCatVigencia_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_EscalaSalarial.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEscBasico_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEscBasico_Internalname, httpContext.getMessage( "Básico", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEscBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEscBasico_Enabled!=0) ? localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEscBasico_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEscBasico_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_EscalaSalarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEscAdicional_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEscAdicional_Internalname, httpContext.getMessage( "Adicional", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEscAdicional_Internalname, GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEscAdicional_Enabled!=0) ? localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEscAdicional_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEscAdicional_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_EscalaSalarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divCatsalrelsec_cell_Internalname, 1, 0, "px", 0, "px", divCatsalrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynCatSalRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCatSalRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCatSalRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCatSalRelSec, dynCatSalRelSec.getInternalname(), GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0)), 1, dynCatSalRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynCatSalRelSec.getVisible(), dynCatSalRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_EscalaSalarial.htm");
      dynCatSalRelSec.setValue( GXutil.trim( GXutil.str( A1891CatSalRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Values", dynCatSalRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EscalaSalarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EscalaSalarial.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EscalaSalarial.htm");
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
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EscalaSalarial.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_EscalaSalarial.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EscalaSalarial.htm");
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
      e114P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z8CatCodigo = httpContext.cgiGet( "Z8CatCodigo") ;
            Z907CatVigencia = localUtil.ctod( httpContext.cgiGet( "Z907CatVigencia"), 0) ;
            Z122CatBasico = localUtil.ctond( httpContext.cgiGet( "Z122CatBasico")) ;
            n122CatBasico = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A122CatBasico)==0) ? true : false) ;
            Z731CatValorHora = localUtil.ctond( httpContext.cgiGet( "Z731CatValorHora")) ;
            n731CatValorHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A731CatValorHora)==0) ? true : false) ;
            Z908CatAdicional = localUtil.ctond( httpContext.cgiGet( "Z908CatAdicional")) ;
            n908CatAdicional = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A908CatAdicional)==0) ? true : false) ;
            Z909CatAdiHora = localUtil.ctond( httpContext.cgiGet( "Z909CatAdiHora")) ;
            n909CatAdiHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A909CatAdiHora)==0) ? true : false) ;
            Z1891CatSalRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1891CatSalRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1891CatSalRelSec = ((0==A1891CatSalRelSec) ? true : false) ;
            Z1892EscBasico = localUtil.ctond( httpContext.cgiGet( "Z1892EscBasico")) ;
            Z1893EscAdicional = localUtil.ctond( httpContext.cgiGet( "Z1893EscAdicional")) ;
            Z2042CatSalRelRef = httpContext.cgiGet( "Z2042CatSalRelRef") ;
            A122CatBasico = localUtil.ctond( httpContext.cgiGet( "Z122CatBasico")) ;
            n122CatBasico = false ;
            n122CatBasico = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A122CatBasico)==0) ? true : false) ;
            A731CatValorHora = localUtil.ctond( httpContext.cgiGet( "Z731CatValorHora")) ;
            n731CatValorHora = false ;
            n731CatValorHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A731CatValorHora)==0) ? true : false) ;
            A908CatAdicional = localUtil.ctond( httpContext.cgiGet( "Z908CatAdicional")) ;
            n908CatAdicional = false ;
            n908CatAdicional = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A908CatAdicional)==0) ? true : false) ;
            A909CatAdiHora = localUtil.ctond( httpContext.cgiGet( "Z909CatAdiHora")) ;
            n909CatAdiHora = false ;
            n909CatAdiHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A909CatAdiHora)==0) ? true : false) ;
            A2042CatSalRelRef = httpContext.cgiGet( "Z2042CatSalRelRef") ;
            O1893EscAdicional = localUtil.ctond( httpContext.cgiGet( "O1893EscAdicional")) ;
            O1892EscBasico = localUtil.ctond( httpContext.cgiGet( "O1892EscBasico")) ;
            O907CatVigencia = localUtil.ctod( httpContext.cgiGet( "O907CatVigencia"), 0) ;
            O8CatCodigo = httpContext.cgiGet( "O8CatCodigo") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10CatCodigo = httpContext.cgiGet( "vCATCODIGO") ;
            AV11CatVigencia = localUtil.ctod( httpContext.cgiGet( "vCATVIGENCIA"), 0) ;
            AV25Essistemaconceptosdefault = GXutil.strtobool( httpContext.cgiGet( "vESSISTEMACONCEPTOSDEFAULT")) ;
            AV23ClienteConveniador = GXutil.strtobool( httpContext.cgiGet( "vCLIENTECONVENIADOR")) ;
            AV24aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A122CatBasico = localUtil.ctond( httpContext.cgiGet( "CATBASICO")) ;
            n122CatBasico = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A122CatBasico)==0) ? true : false) ;
            A731CatValorHora = localUtil.ctond( httpContext.cgiGet( "CATVALORHORA")) ;
            n731CatValorHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A731CatValorHora)==0) ? true : false) ;
            A908CatAdicional = localUtil.ctond( httpContext.cgiGet( "CATADICIONAL")) ;
            n908CatAdicional = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A908CatAdicional)==0) ? true : false) ;
            A909CatAdiHora = localUtil.ctond( httpContext.cgiGet( "CATADIHORA")) ;
            n909CatAdiHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A909CatAdiHora)==0) ? true : false) ;
            A2042CatSalRelRef = httpContext.cgiGet( "CATSALRELREF") ;
            A2043CatSalOld = httpContext.cgiGet( "CATSALOLD") ;
            AV26Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            dynCatCodigo.setValue( httpContext.cgiGet( dynCatCodigo.getInternalname()) );
            A8CatCodigo = httpContext.cgiGet( dynCatCodigo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            if ( localUtil.vcdate( httpContext.cgiGet( edtCatVigencia_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "CATVIGENCIA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCatVigencia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A907CatVigencia = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
            }
            else
            {
               A907CatVigencia = localUtil.ctod( httpContext.cgiGet( edtCatVigencia_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
            }
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ESCBASICO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEscBasico_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1892EscBasico = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
            }
            else
            {
               A1892EscBasico = localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
            }
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ESCADICIONAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEscAdicional_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1893EscAdicional = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
            }
            else
            {
               A1893EscAdicional = localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
            }
            dynCatSalRelSec.setValue( httpContext.cgiGet( dynCatSalRelSec.getInternalname()) );
            A1891CatSalRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynCatSalRelSec.getInternalname()))) ;
            n1891CatSalRelSec = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
            n1891CatSalRelSec = ((0==A1891CatSalRelSec) ? true : false) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIPAICONVE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliPaiConve_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1564CliPaiConve = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            else
            {
               A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"EscalaSalarial");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CatBasico", localUtil.format( A122CatBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("CatValorHora", localUtil.format( A731CatValorHora, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("CatAdicional", localUtil.format( A908CatAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("CatAdiHora", localUtil.format( A909CatAdiHora, "ZZ,ZZZ,ZZZ,ZZ9.99"));
            forbiddenHiddens.add("CatSalRelRef", GXutil.rtrim( localUtil.format( A2042CatSalRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(Z907CatVigencia)) ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("escalasalarial:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A8CatCodigo = httpContext.GetPar( "CatCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
               A907CatVigencia = localUtil.parseDateParm( httpContext.GetPar( "CatVigencia")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
               getEqualNoModal( ) ;
               gxacatcodigo_html4P206( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode206 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  gxacatcodigo_html4P206( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
                  Gx_mode = sMode206 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound206 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4P0( ) ;
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
                        e114P2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124P2 ();
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
         e124P2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4P206( ) ;
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
         disableAttributes4P206( ) ;
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

   public void confirm_4P0( )
   {
      beforeValidate4P206( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4P206( ) ;
         }
         else
         {
            checkExtendedTable4P206( ) ;
            closeExtendedTableCursors4P206( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4P0( )
   {
   }

   public void e114P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEscalaSalarial_Insert", GXv_boolean3) ;
         escalasalarial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEscalaSalarial_Update", GXv_boolean3) ;
         escalasalarial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEscalaSalarial_Delete", GXv_boolean3) ;
         escalasalarial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
      GXt_boolean2 = AV25Essistemaconceptosdefault ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean3) ;
      escalasalarial_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV25Essistemaconceptosdefault = GXt_boolean2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Essistemaconceptosdefault", AV25Essistemaconceptosdefault);
      GXv_boolean3[0] = AV23ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      escalasalarial_impl.this.AV23ClienteConveniador = GXv_boolean3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ClienteConveniador", AV23ClienteConveniador);
   }

   public void e124P2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      dynCatSalRelSec.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatSalRelSec.getVisible(), 5, 0), true);
      divCatsalrelsec_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
   }

   public void zm4P206( int GX_JID )
   {
      if ( ( GX_JID == 26 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z122CatBasico = T004P3_A122CatBasico[0] ;
            Z731CatValorHora = T004P3_A731CatValorHora[0] ;
            Z908CatAdicional = T004P3_A908CatAdicional[0] ;
            Z909CatAdiHora = T004P3_A909CatAdiHora[0] ;
            Z1891CatSalRelSec = T004P3_A1891CatSalRelSec[0] ;
            Z1892EscBasico = T004P3_A1892EscBasico[0] ;
            Z1893EscAdicional = T004P3_A1893EscAdicional[0] ;
            Z2042CatSalRelRef = T004P3_A2042CatSalRelRef[0] ;
         }
         else
         {
            Z122CatBasico = A122CatBasico ;
            Z731CatValorHora = A731CatValorHora ;
            Z908CatAdicional = A908CatAdicional ;
            Z909CatAdiHora = A909CatAdiHora ;
            Z1891CatSalRelSec = A1891CatSalRelSec ;
            Z1892EscBasico = A1892EscBasico ;
            Z1893EscAdicional = A1893EscAdicional ;
            Z2042CatSalRelRef = A2042CatSalRelRef ;
         }
      }
      if ( GX_JID == -26 )
      {
         Z907CatVigencia = A907CatVigencia ;
         Z122CatBasico = A122CatBasico ;
         Z731CatValorHora = A731CatValorHora ;
         Z908CatAdicional = A908CatAdicional ;
         Z909CatAdiHora = A909CatAdiHora ;
         Z1891CatSalRelSec = A1891CatSalRelSec ;
         Z1892EscBasico = A1892EscBasico ;
         Z1893EscAdicional = A1893EscAdicional ;
         Z2042CatSalRelRef = A2042CatSalRelRef ;
         Z2043CatSalOld = A2043CatSalOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxacatsalrelsec_html4P206( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            escalasalarial_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         A1564CliPaiConve = AV8CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      else
      {
         edtCliPaiConve_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      gxacatcodigo_html4P206( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConvenio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10CatCodigo)==0) )
      {
         A8CatCodigo = AV10CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
      if ( ! (GXutil.strcmp("", AV10CatCodigo)==0) )
      {
         dynCatCodigo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynCatCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatCodigo.getEnabled(), 5, 0), true);
      }
      else
      {
         dynCatCodigo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynCatCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatCodigo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10CatCodigo)==0) )
      {
         dynCatCodigo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynCatCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatCodigo.getEnabled(), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11CatVigencia)) )
      {
         A907CatVigencia = AV11CatVigencia ;
         httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11CatVigencia)) )
      {
         edtCatVigencia_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), true);
      }
      else
      {
         edtCatVigencia_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11CatVigencia)) )
      {
         edtCatVigencia_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), true);
      }
      dynCatSalRelSec.setVisible( ((AV25Essistemaconceptosdefault)||(AV23ClienteConveniador) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynCatSalRelSec.getVisible(), 5, 0), true);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV26Pgmname = "EscalaSalarial" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      }
   }

   public void load4P206( )
   {
      /* Using cursor T004P5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A122CatBasico = T004P5_A122CatBasico[0] ;
         n122CatBasico = T004P5_n122CatBasico[0] ;
         A731CatValorHora = T004P5_A731CatValorHora[0] ;
         n731CatValorHora = T004P5_n731CatValorHora[0] ;
         A908CatAdicional = T004P5_A908CatAdicional[0] ;
         n908CatAdicional = T004P5_n908CatAdicional[0] ;
         A909CatAdiHora = T004P5_A909CatAdiHora[0] ;
         n909CatAdiHora = T004P5_n909CatAdiHora[0] ;
         A1891CatSalRelSec = T004P5_A1891CatSalRelSec[0] ;
         n1891CatSalRelSec = T004P5_n1891CatSalRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
         A1892EscBasico = T004P5_A1892EscBasico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
         A1893EscAdicional = T004P5_A1893EscAdicional[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
         A2042CatSalRelRef = T004P5_A2042CatSalRelRef[0] ;
         A2043CatSalOld = T004P5_A2043CatSalOld[0] ;
         zm4P206( -26) ;
      }
      pr_default.close(3);
      onLoadActions4P206( ) ;
   }

   public void onLoadActions4P206( )
   {
      AV26Pgmname = "EscalaSalarial" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      if ( ! ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) ) )
      {
         divCatsalrelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
      }
      else
      {
         if ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) && ! ( ( GXutil.strcmp(A8CatCodigo, O8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) )
         {
            divCatsalrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) && ( ( GXutil.strcmp(A8CatCodigo, O8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) )
            {
               divCatsalrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
            }
         }
      }
   }

   public void checkExtendedTable4P206( )
   {
      nIsDirty_206 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV26Pgmname = "EscalaSalarial" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1891CatSalRelSec, GXv_boolean3) ;
         escalasalarial_impl.this.AV24aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
      }
      /* Using cursor T004P4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CATCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( (GXutil.strcmp("", A8CatCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Categoria", ""), "", "", "", "", "", "", "", ""), 1, "CATCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) ) )
      {
         divCatsalrelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
      }
      else
      {
         if ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) && ! ( ( GXutil.strcmp(A8CatCodigo, O8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) )
         {
            divCatsalrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) && ( ( GXutil.strcmp(A8CatCodigo, O8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) )
            {
               divCatsalrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
            }
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A907CatVigencia)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Vigencia desde", ""), "", "", "", "", "", "", "", ""), 1, "CATVIGENCIA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatVigencia_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ( GXutil.strcmp(A8CatCodigo, O8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) && (0==A1891CatSalRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CATCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A1892EscBasico)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Básico", ""), "", "", "", "", "", "", "", ""), 1, "ESCBASICO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEscBasico_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors4P206( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_27( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio ,
                          String A8CatCodigo )
   {
      /* Using cursor T004P6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CATCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey4P206( )
   {
      /* Using cursor T004P7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound206 = (short)(1) ;
      }
      else
      {
         RcdFound206 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004P3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4P206( 26) ;
         RcdFound206 = (short)(1) ;
         A907CatVigencia = T004P3_A907CatVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
         A122CatBasico = T004P3_A122CatBasico[0] ;
         n122CatBasico = T004P3_n122CatBasico[0] ;
         A731CatValorHora = T004P3_A731CatValorHora[0] ;
         n731CatValorHora = T004P3_n731CatValorHora[0] ;
         A908CatAdicional = T004P3_A908CatAdicional[0] ;
         n908CatAdicional = T004P3_n908CatAdicional[0] ;
         A909CatAdiHora = T004P3_A909CatAdiHora[0] ;
         n909CatAdiHora = T004P3_n909CatAdiHora[0] ;
         A1891CatSalRelSec = T004P3_A1891CatSalRelSec[0] ;
         n1891CatSalRelSec = T004P3_n1891CatSalRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
         A1892EscBasico = T004P3_A1892EscBasico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
         A1893EscAdicional = T004P3_A1893EscAdicional[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
         A2042CatSalRelRef = T004P3_A2042CatSalRelRef[0] ;
         A2043CatSalOld = T004P3_A2043CatSalOld[0] ;
         A3CliCod = T004P3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004P3_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004P3_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = T004P3_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         O1893EscAdicional = A1893EscAdicional ;
         httpContext.ajax_rsp_assign_attri("", false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
         O1892EscBasico = A1892EscBasico ;
         httpContext.ajax_rsp_assign_attri("", false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
         O907CatVigencia = A907CatVigencia ;
         httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
         O8CatCodigo = A8CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4P206( ) ;
         if ( AnyError == 1 )
         {
            RcdFound206 = (short)(0) ;
            initializeNonKey4P206( ) ;
         }
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound206 = (short)(0) ;
         initializeNonKey4P206( ) ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4P206( ) ;
      if ( RcdFound206 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound206 = (short)(0) ;
      /* Using cursor T004P8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A8CatCodigo, A8CatCodigo, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A907CatVigencia});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004P8_A3CliCod[0] < A3CliCod ) || ( T004P8_A3CliCod[0] == A3CliCod ) && ( T004P8_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004P8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004P8_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T004P8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004P8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004P8_A8CatCodigo[0], A8CatCodigo) < 0 ) || ( GXutil.strcmp(T004P8_A8CatCodigo[0], A8CatCodigo) == 0 ) && ( GXutil.strcmp(T004P8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004P8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004P8_A907CatVigencia[0]).before( GXutil.resetTime( A907CatVigencia )) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004P8_A3CliCod[0] > A3CliCod ) || ( T004P8_A3CliCod[0] == A3CliCod ) && ( T004P8_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004P8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004P8_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T004P8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004P8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004P8_A8CatCodigo[0], A8CatCodigo) > 0 ) || ( GXutil.strcmp(T004P8_A8CatCodigo[0], A8CatCodigo) == 0 ) && ( GXutil.strcmp(T004P8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004P8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004P8_A907CatVigencia[0]).after( GXutil.resetTime( A907CatVigencia )) ) )
         {
            A3CliCod = T004P8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004P8_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004P8_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A8CatCodigo = T004P8_A8CatCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            A907CatVigencia = T004P8_A907CatVigencia[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
            RcdFound206 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound206 = (short)(0) ;
      /* Using cursor T004P9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A8CatCodigo, A8CatCodigo, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A907CatVigencia});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004P9_A3CliCod[0] > A3CliCod ) || ( T004P9_A3CliCod[0] == A3CliCod ) && ( T004P9_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T004P9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004P9_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T004P9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004P9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004P9_A8CatCodigo[0], A8CatCodigo) > 0 ) || ( GXutil.strcmp(T004P9_A8CatCodigo[0], A8CatCodigo) == 0 ) && ( GXutil.strcmp(T004P9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004P9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004P9_A907CatVigencia[0]).after( GXutil.resetTime( A907CatVigencia )) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004P9_A3CliCod[0] < A3CliCod ) || ( T004P9_A3CliCod[0] == A3CliCod ) && ( T004P9_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T004P9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004P9_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T004P9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004P9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004P9_A8CatCodigo[0], A8CatCodigo) < 0 ) || ( GXutil.strcmp(T004P9_A8CatCodigo[0], A8CatCodigo) == 0 ) && ( GXutil.strcmp(T004P9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T004P9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T004P9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T004P9_A907CatVigencia[0]).before( GXutil.resetTime( A907CatVigencia )) ) )
         {
            A3CliCod = T004P9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T004P9_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T004P9_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A8CatCodigo = T004P9_A8CatCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            A907CatVigencia = T004P9_A907CatVigencia[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
            RcdFound206 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4P206( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynCatCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4P206( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound206 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(Z907CatVigencia)) ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A8CatCodigo = Z8CatCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
               A907CatVigencia = Z907CatVigencia ;
               httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynCatCodigo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4P206( ) ;
               GX_FocusControl = dynCatCodigo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(Z907CatVigencia)) ) )
            {
               /* Insert record */
               GX_FocusControl = dynCatCodigo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4P206( ) ;
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
                  GX_FocusControl = dynCatCodigo.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4P206( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(Z907CatVigencia)) ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = Z8CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         A907CatVigencia = Z907CatVigencia ;
         httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynCatCodigo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4P206( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004P2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z122CatBasico, T004P2_A122CatBasico[0]) != 0 ) || ( DecimalUtil.compareTo(Z731CatValorHora, T004P2_A731CatValorHora[0]) != 0 ) || ( DecimalUtil.compareTo(Z908CatAdicional, T004P2_A908CatAdicional[0]) != 0 ) || ( DecimalUtil.compareTo(Z909CatAdiHora, T004P2_A909CatAdiHora[0]) != 0 ) || ( Z1891CatSalRelSec != T004P2_A1891CatSalRelSec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1892EscBasico, T004P2_A1892EscBasico[0]) != 0 ) || ( DecimalUtil.compareTo(Z1893EscAdicional, T004P2_A1893EscAdicional[0]) != 0 ) || ( GXutil.strcmp(Z2042CatSalRelRef, T004P2_A2042CatSalRelRef[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z122CatBasico, T004P2_A122CatBasico[0]) != 0 )
            {
               GXutil.writeLogln("escalasalarial:[seudo value changed for attri]"+"CatBasico");
               GXutil.writeLogRaw("Old: ",Z122CatBasico);
               GXutil.writeLogRaw("Current: ",T004P2_A122CatBasico[0]);
            }
            if ( DecimalUtil.compareTo(Z731CatValorHora, T004P2_A731CatValorHora[0]) != 0 )
            {
               GXutil.writeLogln("escalasalarial:[seudo value changed for attri]"+"CatValorHora");
               GXutil.writeLogRaw("Old: ",Z731CatValorHora);
               GXutil.writeLogRaw("Current: ",T004P2_A731CatValorHora[0]);
            }
            if ( DecimalUtil.compareTo(Z908CatAdicional, T004P2_A908CatAdicional[0]) != 0 )
            {
               GXutil.writeLogln("escalasalarial:[seudo value changed for attri]"+"CatAdicional");
               GXutil.writeLogRaw("Old: ",Z908CatAdicional);
               GXutil.writeLogRaw("Current: ",T004P2_A908CatAdicional[0]);
            }
            if ( DecimalUtil.compareTo(Z909CatAdiHora, T004P2_A909CatAdiHora[0]) != 0 )
            {
               GXutil.writeLogln("escalasalarial:[seudo value changed for attri]"+"CatAdiHora");
               GXutil.writeLogRaw("Old: ",Z909CatAdiHora);
               GXutil.writeLogRaw("Current: ",T004P2_A909CatAdiHora[0]);
            }
            if ( Z1891CatSalRelSec != T004P2_A1891CatSalRelSec[0] )
            {
               GXutil.writeLogln("escalasalarial:[seudo value changed for attri]"+"CatSalRelSec");
               GXutil.writeLogRaw("Old: ",Z1891CatSalRelSec);
               GXutil.writeLogRaw("Current: ",T004P2_A1891CatSalRelSec[0]);
            }
            if ( DecimalUtil.compareTo(Z1892EscBasico, T004P2_A1892EscBasico[0]) != 0 )
            {
               GXutil.writeLogln("escalasalarial:[seudo value changed for attri]"+"EscBasico");
               GXutil.writeLogRaw("Old: ",Z1892EscBasico);
               GXutil.writeLogRaw("Current: ",T004P2_A1892EscBasico[0]);
            }
            if ( DecimalUtil.compareTo(Z1893EscAdicional, T004P2_A1893EscAdicional[0]) != 0 )
            {
               GXutil.writeLogln("escalasalarial:[seudo value changed for attri]"+"EscAdicional");
               GXutil.writeLogRaw("Old: ",Z1893EscAdicional);
               GXutil.writeLogRaw("Current: ",T004P2_A1893EscAdicional[0]);
            }
            if ( GXutil.strcmp(Z2042CatSalRelRef, T004P2_A2042CatSalRelRef[0]) != 0 )
            {
               GXutil.writeLogln("escalasalarial:[seudo value changed for attri]"+"CatSalRelRef");
               GXutil.writeLogRaw("Old: ",Z2042CatSalRelRef);
               GXutil.writeLogRaw("Current: ",T004P2_A2042CatSalRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoriavalores1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4P206( )
   {
      beforeValidate4P206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4P206( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4P206( 0) ;
         checkOptimisticConcurrency4P206( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4P206( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4P206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004P10 */
                  pr_default.execute(8, new Object[] {A907CatVigencia, Boolean.valueOf(n122CatBasico), A122CatBasico, Boolean.valueOf(n731CatValorHora), A731CatValorHora, Boolean.valueOf(n908CatAdicional), A908CatAdicional, Boolean.valueOf(n909CatAdiHora), A909CatAdiHora, Boolean.valueOf(n1891CatSalRelSec), Integer.valueOf(A1891CatSalRelSec), A1892EscBasico, A1893EscAdicional, A2042CatSalRelRef, A2043CatSalOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                  if ( (pr_default.getStatus(8) == 1) )
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
                        resetCaption4P0( ) ;
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
            load4P206( ) ;
         }
         endLevel4P206( ) ;
      }
      closeExtendedTableCursors4P206( ) ;
   }

   public void update4P206( )
   {
      beforeValidate4P206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4P206( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4P206( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4P206( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4P206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004P11 */
                  pr_default.execute(9, new Object[] {Boolean.valueOf(n122CatBasico), A122CatBasico, Boolean.valueOf(n731CatValorHora), A731CatValorHora, Boolean.valueOf(n908CatAdicional), A908CatAdicional, Boolean.valueOf(n909CatAdiHora), A909CatAdiHora, Boolean.valueOf(n1891CatSalRelSec), Integer.valueOf(A1891CatSalRelSec), A1892EscBasico, A1893EscAdicional, A2042CatSalRelRef, A2043CatSalOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4P206( ) ;
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
         endLevel4P206( ) ;
      }
      closeExtendedTableCursors4P206( ) ;
   }

   public void deferredUpdate4P206( )
   {
   }

   public void delete( )
   {
      beforeValidate4P206( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4P206( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4P206( ) ;
         afterConfirm4P206( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4P206( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004P12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
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
      sMode206 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4P206( ) ;
      Gx_mode = sMode206 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4P206( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV24aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1891CatSalRelSec, GXv_boolean3) ;
            escalasalarial_impl.this.AV24aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
         }
         AV26Pgmname = "EscalaSalarial" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         if ( ! ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) ) )
         {
            divCatsalrelsec_cell_Class = httpContext.getMessage( "Invisible", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
         }
         else
         {
            if ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) && ! ( ( GXutil.strcmp(A8CatCodigo, O8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) )
            {
               divCatsalrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
            }
            else
            {
               if ( ( AV25Essistemaconceptosdefault ) || ( AV23ClienteConveniador ) && ( ( GXutil.strcmp(A8CatCodigo, O8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) )
               {
                  divCatsalrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
                  httpContext.ajax_rsp_assign_prop("", false, divCatsalrelsec_cell_Internalname, "Class", divCatsalrelsec_cell_Class, true);
               }
            }
         }
      }
   }

   public void endLevel4P206( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4P206( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "escalasalarial");
         if ( AnyError == 0 )
         {
            confirmValues4P0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "escalasalarial");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4P206( )
   {
      /* Scan By routine */
      /* Using cursor T004P13 */
      pr_default.execute(11);
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A3CliCod = T004P13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004P13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004P13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = T004P13_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         A907CatVigencia = T004P13_A907CatVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4P206( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A3CliCod = T004P13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004P13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004P13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = T004P13_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         A907CatVigencia = T004P13_A907CatVigencia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
      }
   }

   public void scanEnd4P206( )
   {
      pr_default.close(11);
   }

   public void afterConfirm4P206( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV24aplicadoHay ) && ! (0==A1891CatSalRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "CatSalRelSec", 1, "CATSALRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatSalRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert4P206( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4P206( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4P206( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4P206( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4P206( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4P206( )
   {
      dynCatCodigo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCatCodigo.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatCodigo.getEnabled(), 5, 0), true);
      edtCatVigencia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), true);
      edtEscBasico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEscBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscBasico_Enabled), 5, 0), true);
      edtEscAdicional_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEscAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscAdicional_Enabled), 5, 0), true);
      dynCatSalRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCatSalRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynCatSalRelSec.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4P206( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4P0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.escalasalarial", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10CatCodigo)),GXutil.URLEncode(GXutil.formatDateParm(AV11CatVigencia))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CatCodigo","CatVigencia"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"EscalaSalarial");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CatBasico", localUtil.format( A122CatBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("CatValorHora", localUtil.format( A731CatValorHora, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("CatAdicional", localUtil.format( A908CatAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("CatAdiHora", localUtil.format( A909CatAdiHora, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("CatSalRelRef", GXutil.rtrim( localUtil.format( A2042CatSalRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("escalasalarial:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z907CatVigencia", localUtil.dtoc( Z907CatVigencia, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z122CatBasico", GXutil.ltrim( localUtil.ntoc( Z122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z731CatValorHora", GXutil.ltrim( localUtil.ntoc( Z731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z908CatAdicional", GXutil.ltrim( localUtil.ntoc( Z908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z909CatAdiHora", GXutil.ltrim( localUtil.ntoc( Z909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1891CatSalRelSec", GXutil.ltrim( localUtil.ntoc( Z1891CatSalRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1892EscBasico", GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1893EscAdicional", GXutil.ltrim( localUtil.ntoc( Z1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2042CatSalRelRef", Z2042CatSalRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1893EscAdicional", GXutil.ltrim( localUtil.ntoc( O1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1892EscBasico", GXutil.ltrim( localUtil.ntoc( O1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O907CatVigencia", localUtil.dtoc( O907CatVigencia, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "O8CatCodigo", GXutil.rtrim( O8CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCATCODIGO", GXutil.rtrim( AV10CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10CatCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCATVIGENCIA", localUtil.dtoc( AV11CatVigencia, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATVIGENCIA", getSecureSignedToken( "", AV11CatVigencia));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESSISTEMACONCEPTOSDEFAULT", AV25Essistemaconceptosdefault);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV23ClienteConveniador);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV24aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CATBASICO", GXutil.ltrim( localUtil.ntoc( A122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATVALORHORA", GXutil.ltrim( localUtil.ntoc( A731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATADICIONAL", GXutil.ltrim( localUtil.ntoc( A908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATADIHORA", GXutil.ltrim( localUtil.ntoc( A909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATSALRELREF", A2042CatSalRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CATSALOLD", A2043CatSalOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
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
      return formatLink("web.escalasalarial", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10CatCodigo)),GXutil.URLEncode(GXutil.formatDateParm(AV11CatVigencia))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CatCodigo","CatVigencia"})  ;
   }

   public String getPgmname( )
   {
      return "EscalaSalarial" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Escala Salarial", "") ;
   }

   public void initializeNonKey4P206( )
   {
      AV24aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
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
      A1891CatSalRelSec = 0 ;
      n1891CatSalRelSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1891CatSalRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1891CatSalRelSec), 6, 0));
      n1891CatSalRelSec = ((0==A1891CatSalRelSec) ? true : false) ;
      A1892EscBasico = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
      A1893EscAdicional = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
      A2042CatSalRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2042CatSalRelRef", A2042CatSalRelRef);
      A2043CatSalOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2043CatSalOld", A2043CatSalOld);
      O1893EscAdicional = A1893EscAdicional ;
      httpContext.ajax_rsp_assign_attri("", false, "A1893EscAdicional", GXutil.ltrimstr( A1893EscAdicional, 14, 2));
      O1892EscBasico = A1892EscBasico ;
      httpContext.ajax_rsp_assign_attri("", false, "A1892EscBasico", GXutil.ltrimstr( A1892EscBasico, 14, 2));
      Z122CatBasico = DecimalUtil.ZERO ;
      Z731CatValorHora = DecimalUtil.ZERO ;
      Z908CatAdicional = DecimalUtil.ZERO ;
      Z909CatAdiHora = DecimalUtil.ZERO ;
      Z1891CatSalRelSec = 0 ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      Z1893EscAdicional = DecimalUtil.ZERO ;
      Z2042CatSalRelRef = "" ;
   }

   public void initAll4P206( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A8CatCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      A907CatVigencia = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A907CatVigencia", localUtil.format(A907CatVigencia, "99/99/9999"));
      initializeNonKey4P206( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713381597", true, true);
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
      httpContext.AddJavascriptSource("escalasalarial.js", "?20251713381597", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynCatCodigo.setInternalname( "CATCODIGO" );
      edtCatVigencia_Internalname = "CATVIGENCIA" ;
      edtEscBasico_Internalname = "ESCBASICO" ;
      edtEscAdicional_Internalname = "ESCADICIONAL" ;
      dynCatSalRelSec.setInternalname( "CATSALRELSEC" );
      divCatsalrelsec_cell_Internalname = "CATSALRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
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
      Form.setCaption( httpContext.getMessage( "Escala Salarial", "") );
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynCatSalRelSec.setJsonclick( "" );
      dynCatSalRelSec.setEnabled( 1 );
      dynCatSalRelSec.setVisible( 1 );
      divCatsalrelsec_cell_Class = "col-xs-12" ;
      edtEscAdicional_Jsonclick = "" ;
      edtEscAdicional_Enabled = 1 ;
      edtEscBasico_Jsonclick = "" ;
      edtEscBasico_Enabled = 1 ;
      edtCatVigencia_Jsonclick = "" ;
      edtCatVigencia_Enabled = 1 ;
      dynCatCodigo.setJsonclick( "" );
      dynCatCodigo.setEnabled( 1 );
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

   public void gxdlacatcodigo4P206( int AV7CliCod ,
                                    short AV8CliPaiConve ,
                                    String AV9CliConvenio )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacatcodigo_data4P206( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
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

   public void gxacatcodigo_html4P206( int AV7CliCod ,
                                       short AV8CliPaiConve ,
                                       String AV9CliConvenio )
   {
      String gxdynajaxvalue;
      gxdlacatcodigo_data4P206( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCatCodigo.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynCatCodigo.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacatcodigo_data4P206( int AV7CliCod ,
                                            short AV8CliPaiConve ,
                                            String AV9CliConvenio )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T004P14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8CliPaiConve), AV9CliConvenio});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T004P14_A8CatCodigo[0]));
         gxdynajaxctrldescr.add(T004P14_A123CatDescrip[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gxdlacatsalrelsec4P206( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacatsalrelsec_data4P206( AV7CliCod) ;
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

   public void gxacatsalrelsec_html4P206( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlacatsalrelsec_data4P206( AV7CliCod) ;
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

   protected void gxdlacatsalrelsec_data4P206( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T004P15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(13) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T004P15_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T004P15_A1880CliReDTChar[0]);
         pr_default.readNext(13);
      }
      pr_default.close(13);
   }

   public void gx1asaclicod4P206( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            escalasalarial_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void xc_24_4P206( String Gx_mode ,
                            int AV7CliCod ,
                            int A1891CatSalRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1891CatSalRelSec, GXv_boolean3) ;
         AV24aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV24aplicadoHay))+"\"") ;
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
      dynCatCodigo.setName( "CATCODIGO" );
      dynCatCodigo.setWebtags( "" );
      dynCatSalRelSec.setName( "CATSALRELSEC" );
      dynCatSalRelSec.setWebtags( "" );
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

   public void valid_Cliconvenio( )
   {
      A8CatCodigo = dynCatCodigo.getValue() ;
      n1891CatSalRelSec = false ;
      A1891CatSalRelSec = (int)(GXutil.lval( dynCatSalRelSec.getValue())) ;
      n1891CatSalRelSec = false ;
      /* Using cursor T004P16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CATCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      if ( dynCatCodigo.getItemCount() > 0 )
      {
         A8CatCodigo = dynCatCodigo.getValidValue(A8CatCodigo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCatCodigo.setValue( GXutil.rtrim( A8CatCodigo) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Catsalrelsec( )
   {
      A8CatCodigo = dynCatCodigo.getValue() ;
      n1891CatSalRelSec = false ;
      A1891CatSalRelSec = (int)(GXutil.lval( dynCatSalRelSec.getValue())) ;
      n1891CatSalRelSec = false ;
      if ( ( ( GXutil.strcmp(A8CatCodigo, O8CatCodigo) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A907CatVigencia), GXutil.resetTime(O907CatVigencia)) ) || ( DecimalUtil.compareTo(A1892EscBasico, O1892EscBasico) != 0 ) || ( DecimalUtil.compareTo(A1893EscAdicional, O1893EscAdicional) != 0 ) ) && (0==A1891CatSalRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CATSALRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCatSalRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV24aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1891CatSalRelSec, GXv_boolean3) ;
         escalasalarial_impl.this.AV24aplicadoHay = GXv_boolean3[0] ;
         AV24aplicadoHay = this.AV24aplicadoHay ;
      }
      O1893EscAdicional = A1893EscAdicional ;
      O1892EscBasico = A1892EscBasico ;
      O907CatVigencia = A907CatVigencia ;
      O8CatCodigo = A8CatCodigo ;
      dynload_actions( ) ;
      if ( dynCatCodigo.getItemCount() > 0 )
      {
         A8CatCodigo = dynCatCodigo.getValidValue(A8CatCodigo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCatCodigo.setValue( GXutil.rtrim( A8CatCodigo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV24aplicadoHay", AV24aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10CatCodigo',fld:'vCATCODIGO',pic:'',hsh:true},{av:'AV11CatVigencia',fld:'vCATVIGENCIA',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10CatCodigo',fld:'vCATCODIGO',pic:'',hsh:true},{av:'AV11CatVigencia',fld:'vCATVIGENCIA',pic:'',hsh:true},{av:'A122CatBasico',fld:'CATBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A731CatValorHora',fld:'CATVALORHORA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A908CatAdicional',fld:'CATADICIONAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A909CatAdiHora',fld:'CATADIHORA',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A2042CatSalRelRef',fld:'CATSALRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e124P2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("VALID_CATCODIGO","{handler:'valid_Catcodigo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("VALID_CATCODIGO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("VALID_CATVIGENCIA","{handler:'valid_Catvigencia',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("VALID_CATVIGENCIA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("VALID_ESCBASICO","{handler:'valid_Escbasico',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("VALID_ESCBASICO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("VALID_ESCADICIONAL","{handler:'valid_Escadicional',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("VALID_ESCADICIONAL",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("VALID_CATSALRELSEC","{handler:'valid_Catsalrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1893EscAdicional'},{av:'O1892EscBasico'},{av:'O907CatVigencia'},{av:'O8CatCodigo'},{av:'A907CatVigencia',fld:'CATVIGENCIA',pic:''},{av:'A1892EscBasico',fld:'ESCBASICO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A1893EscAdicional',fld:'ESCADICIONAL',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV24aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("VALID_CATSALRELSEC",",oparms:[{av:'AV24aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynCatSalRelSec'},{av:'A1891CatSalRelSec',fld:'CATSALRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCatCodigo'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]}");
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
      return "";
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
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      wcpOAV10CatCodigo = "" ;
      wcpOAV11CatVigencia = GXutil.nullDate() ;
      Z1565CliConvenio = "" ;
      Z8CatCodigo = "" ;
      Z907CatVigencia = GXutil.nullDate() ;
      Z122CatBasico = DecimalUtil.ZERO ;
      Z731CatValorHora = DecimalUtil.ZERO ;
      Z908CatAdicional = DecimalUtil.ZERO ;
      Z909CatAdiHora = DecimalUtil.ZERO ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      Z1893EscAdicional = DecimalUtil.ZERO ;
      Z2042CatSalRelRef = "" ;
      O1893EscAdicional = DecimalUtil.ZERO ;
      O1892EscBasico = DecimalUtil.ZERO ;
      O907CatVigencia = GXutil.nullDate() ;
      O8CatCodigo = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV9CliConvenio = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      AV10CatCodigo = "" ;
      AV11CatVigencia = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A122CatBasico = DecimalUtil.ZERO ;
      A731CatValorHora = DecimalUtil.ZERO ;
      A908CatAdicional = DecimalUtil.ZERO ;
      A909CatAdiHora = DecimalUtil.ZERO ;
      A2042CatSalRelRef = "" ;
      A2043CatSalOld = "" ;
      AV26Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode206 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      Z2043CatSalOld = "" ;
      T004P5_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T004P5_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P5_n122CatBasico = new boolean[] {false} ;
      T004P5_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P5_n731CatValorHora = new boolean[] {false} ;
      T004P5_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P5_n908CatAdicional = new boolean[] {false} ;
      T004P5_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P5_n909CatAdiHora = new boolean[] {false} ;
      T004P5_A1891CatSalRelSec = new int[1] ;
      T004P5_n1891CatSalRelSec = new boolean[] {false} ;
      T004P5_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P5_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P5_A2042CatSalRelRef = new String[] {""} ;
      T004P5_A2043CatSalOld = new String[] {""} ;
      T004P5_A3CliCod = new int[1] ;
      T004P5_A1564CliPaiConve = new short[1] ;
      T004P5_A1565CliConvenio = new String[] {""} ;
      T004P5_A8CatCodigo = new String[] {""} ;
      T004P4_A3CliCod = new int[1] ;
      T004P6_A3CliCod = new int[1] ;
      T004P7_A3CliCod = new int[1] ;
      T004P7_A1564CliPaiConve = new short[1] ;
      T004P7_A1565CliConvenio = new String[] {""} ;
      T004P7_A8CatCodigo = new String[] {""} ;
      T004P7_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T004P3_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T004P3_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P3_n122CatBasico = new boolean[] {false} ;
      T004P3_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P3_n731CatValorHora = new boolean[] {false} ;
      T004P3_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P3_n908CatAdicional = new boolean[] {false} ;
      T004P3_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P3_n909CatAdiHora = new boolean[] {false} ;
      T004P3_A1891CatSalRelSec = new int[1] ;
      T004P3_n1891CatSalRelSec = new boolean[] {false} ;
      T004P3_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P3_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P3_A2042CatSalRelRef = new String[] {""} ;
      T004P3_A2043CatSalOld = new String[] {""} ;
      T004P3_A3CliCod = new int[1] ;
      T004P3_A1564CliPaiConve = new short[1] ;
      T004P3_A1565CliConvenio = new String[] {""} ;
      T004P3_A8CatCodigo = new String[] {""} ;
      T004P8_A3CliCod = new int[1] ;
      T004P8_A1564CliPaiConve = new short[1] ;
      T004P8_A1565CliConvenio = new String[] {""} ;
      T004P8_A8CatCodigo = new String[] {""} ;
      T004P8_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T004P9_A3CliCod = new int[1] ;
      T004P9_A1564CliPaiConve = new short[1] ;
      T004P9_A1565CliConvenio = new String[] {""} ;
      T004P9_A8CatCodigo = new String[] {""} ;
      T004P9_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T004P2_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T004P2_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P2_n122CatBasico = new boolean[] {false} ;
      T004P2_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P2_n731CatValorHora = new boolean[] {false} ;
      T004P2_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P2_n908CatAdicional = new boolean[] {false} ;
      T004P2_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P2_n909CatAdiHora = new boolean[] {false} ;
      T004P2_A1891CatSalRelSec = new int[1] ;
      T004P2_n1891CatSalRelSec = new boolean[] {false} ;
      T004P2_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P2_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004P2_A2042CatSalRelRef = new String[] {""} ;
      T004P2_A2043CatSalOld = new String[] {""} ;
      T004P2_A3CliCod = new int[1] ;
      T004P2_A1564CliPaiConve = new short[1] ;
      T004P2_A1565CliConvenio = new String[] {""} ;
      T004P2_A8CatCodigo = new String[] {""} ;
      T004P13_A3CliCod = new int[1] ;
      T004P13_A1564CliPaiConve = new short[1] ;
      T004P13_A1565CliConvenio = new String[] {""} ;
      T004P13_A8CatCodigo = new String[] {""} ;
      T004P13_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T004P14_A3CliCod = new int[1] ;
      T004P14_A1564CliPaiConve = new short[1] ;
      T004P14_A1565CliConvenio = new String[] {""} ;
      T004P14_A8CatCodigo = new String[] {""} ;
      T004P14_A123CatDescrip = new String[] {""} ;
      T004P15_A3CliCod = new int[1] ;
      T004P15_A1885CliRelSec = new int[1] ;
      T004P15_A1880CliReDTChar = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T004P16_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.escalasalarial__default(),
         new Object[] {
             new Object[] {
            T004P2_A907CatVigencia, T004P2_A122CatBasico, T004P2_n122CatBasico, T004P2_A731CatValorHora, T004P2_n731CatValorHora, T004P2_A908CatAdicional, T004P2_n908CatAdicional, T004P2_A909CatAdiHora, T004P2_n909CatAdiHora, T004P2_A1891CatSalRelSec,
            T004P2_n1891CatSalRelSec, T004P2_A1892EscBasico, T004P2_A1893EscAdicional, T004P2_A2042CatSalRelRef, T004P2_A2043CatSalOld, T004P2_A3CliCod, T004P2_A1564CliPaiConve, T004P2_A1565CliConvenio, T004P2_A8CatCodigo
            }
            , new Object[] {
            T004P3_A907CatVigencia, T004P3_A122CatBasico, T004P3_n122CatBasico, T004P3_A731CatValorHora, T004P3_n731CatValorHora, T004P3_A908CatAdicional, T004P3_n908CatAdicional, T004P3_A909CatAdiHora, T004P3_n909CatAdiHora, T004P3_A1891CatSalRelSec,
            T004P3_n1891CatSalRelSec, T004P3_A1892EscBasico, T004P3_A1893EscAdicional, T004P3_A2042CatSalRelRef, T004P3_A2043CatSalOld, T004P3_A3CliCod, T004P3_A1564CliPaiConve, T004P3_A1565CliConvenio, T004P3_A8CatCodigo
            }
            , new Object[] {
            T004P4_A3CliCod
            }
            , new Object[] {
            T004P5_A907CatVigencia, T004P5_A122CatBasico, T004P5_n122CatBasico, T004P5_A731CatValorHora, T004P5_n731CatValorHora, T004P5_A908CatAdicional, T004P5_n908CatAdicional, T004P5_A909CatAdiHora, T004P5_n909CatAdiHora, T004P5_A1891CatSalRelSec,
            T004P5_n1891CatSalRelSec, T004P5_A1892EscBasico, T004P5_A1893EscAdicional, T004P5_A2042CatSalRelRef, T004P5_A2043CatSalOld, T004P5_A3CliCod, T004P5_A1564CliPaiConve, T004P5_A1565CliConvenio, T004P5_A8CatCodigo
            }
            , new Object[] {
            T004P6_A3CliCod
            }
            , new Object[] {
            T004P7_A3CliCod, T004P7_A1564CliPaiConve, T004P7_A1565CliConvenio, T004P7_A8CatCodigo, T004P7_A907CatVigencia
            }
            , new Object[] {
            T004P8_A3CliCod, T004P8_A1564CliPaiConve, T004P8_A1565CliConvenio, T004P8_A8CatCodigo, T004P8_A907CatVigencia
            }
            , new Object[] {
            T004P9_A3CliCod, T004P9_A1564CliPaiConve, T004P9_A1565CliConvenio, T004P9_A8CatCodigo, T004P9_A907CatVigencia
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004P13_A3CliCod, T004P13_A1564CliPaiConve, T004P13_A1565CliConvenio, T004P13_A8CatCodigo, T004P13_A907CatVigencia
            }
            , new Object[] {
            T004P14_A3CliCod, T004P14_A1564CliPaiConve, T004P14_A1565CliConvenio, T004P14_A8CatCodigo, T004P14_A123CatDescrip
            }
            , new Object[] {
            T004P15_A3CliCod, T004P15_A1885CliRelSec, T004P15_A1880CliReDTChar
            }
            , new Object[] {
            T004P16_A3CliCod
            }
         }
      );
      AV26Pgmname = "EscalaSalarial" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short A1564CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound206 ;
   private short nIsDirty_206 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1891CatSalRelSec ;
   private int AV7CliCod ;
   private int A1891CatSalRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtCatVigencia_Enabled ;
   private int edtEscBasico_Enabled ;
   private int edtEscAdicional_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int edtCliConvenio_Visible ;
   private int edtCliConvenio_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private java.math.BigDecimal Z122CatBasico ;
   private java.math.BigDecimal Z731CatValorHora ;
   private java.math.BigDecimal Z908CatAdicional ;
   private java.math.BigDecimal Z909CatAdiHora ;
   private java.math.BigDecimal Z1892EscBasico ;
   private java.math.BigDecimal Z1893EscAdicional ;
   private java.math.BigDecimal O1893EscAdicional ;
   private java.math.BigDecimal O1892EscBasico ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private java.math.BigDecimal A122CatBasico ;
   private java.math.BigDecimal A731CatValorHora ;
   private java.math.BigDecimal A908CatAdicional ;
   private java.math.BigDecimal A909CatAdiHora ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String wcpOAV10CatCodigo ;
   private String Z1565CliConvenio ;
   private String Z8CatCodigo ;
   private String O8CatCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV9CliConvenio ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String AV10CatCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
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
   private String edtCatVigencia_Internalname ;
   private String edtCatVigencia_Jsonclick ;
   private String edtEscBasico_Internalname ;
   private String edtEscBasico_Jsonclick ;
   private String edtEscAdicional_Internalname ;
   private String edtEscAdicional_Jsonclick ;
   private String divCatsalrelsec_cell_Internalname ;
   private String divCatsalrelsec_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Internalname ;
   private String edtCliConvenio_Jsonclick ;
   private String AV26Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode206 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private java.util.Date wcpOAV11CatVigencia ;
   private java.util.Date Z907CatVigencia ;
   private java.util.Date O907CatVigencia ;
   private java.util.Date AV11CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1891CatSalRelSec ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n122CatBasico ;
   private boolean n731CatValorHora ;
   private boolean n908CatAdicional ;
   private boolean n909CatAdiHora ;
   private boolean AV25Essistemaconceptosdefault ;
   private boolean AV23ClienteConveniador ;
   private boolean AV24aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean3[] ;
   private boolean ZV24aplicadoHay ;
   private String A2043CatSalOld ;
   private String Z2043CatSalOld ;
   private String Z2042CatSalRelRef ;
   private String A2042CatSalRelRef ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynCatCodigo ;
   private HTMLChoice dynCatSalRelSec ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] T004P5_A907CatVigencia ;
   private java.math.BigDecimal[] T004P5_A122CatBasico ;
   private boolean[] T004P5_n122CatBasico ;
   private java.math.BigDecimal[] T004P5_A731CatValorHora ;
   private boolean[] T004P5_n731CatValorHora ;
   private java.math.BigDecimal[] T004P5_A908CatAdicional ;
   private boolean[] T004P5_n908CatAdicional ;
   private java.math.BigDecimal[] T004P5_A909CatAdiHora ;
   private boolean[] T004P5_n909CatAdiHora ;
   private int[] T004P5_A1891CatSalRelSec ;
   private boolean[] T004P5_n1891CatSalRelSec ;
   private java.math.BigDecimal[] T004P5_A1892EscBasico ;
   private java.math.BigDecimal[] T004P5_A1893EscAdicional ;
   private String[] T004P5_A2042CatSalRelRef ;
   private String[] T004P5_A2043CatSalOld ;
   private int[] T004P5_A3CliCod ;
   private short[] T004P5_A1564CliPaiConve ;
   private String[] T004P5_A1565CliConvenio ;
   private String[] T004P5_A8CatCodigo ;
   private int[] T004P4_A3CliCod ;
   private int[] T004P6_A3CliCod ;
   private int[] T004P7_A3CliCod ;
   private short[] T004P7_A1564CliPaiConve ;
   private String[] T004P7_A1565CliConvenio ;
   private String[] T004P7_A8CatCodigo ;
   private java.util.Date[] T004P7_A907CatVigencia ;
   private java.util.Date[] T004P3_A907CatVigencia ;
   private java.math.BigDecimal[] T004P3_A122CatBasico ;
   private boolean[] T004P3_n122CatBasico ;
   private java.math.BigDecimal[] T004P3_A731CatValorHora ;
   private boolean[] T004P3_n731CatValorHora ;
   private java.math.BigDecimal[] T004P3_A908CatAdicional ;
   private boolean[] T004P3_n908CatAdicional ;
   private java.math.BigDecimal[] T004P3_A909CatAdiHora ;
   private boolean[] T004P3_n909CatAdiHora ;
   private int[] T004P3_A1891CatSalRelSec ;
   private boolean[] T004P3_n1891CatSalRelSec ;
   private java.math.BigDecimal[] T004P3_A1892EscBasico ;
   private java.math.BigDecimal[] T004P3_A1893EscAdicional ;
   private String[] T004P3_A2042CatSalRelRef ;
   private String[] T004P3_A2043CatSalOld ;
   private int[] T004P3_A3CliCod ;
   private short[] T004P3_A1564CliPaiConve ;
   private String[] T004P3_A1565CliConvenio ;
   private String[] T004P3_A8CatCodigo ;
   private int[] T004P8_A3CliCod ;
   private short[] T004P8_A1564CliPaiConve ;
   private String[] T004P8_A1565CliConvenio ;
   private String[] T004P8_A8CatCodigo ;
   private java.util.Date[] T004P8_A907CatVigencia ;
   private int[] T004P9_A3CliCod ;
   private short[] T004P9_A1564CliPaiConve ;
   private String[] T004P9_A1565CliConvenio ;
   private String[] T004P9_A8CatCodigo ;
   private java.util.Date[] T004P9_A907CatVigencia ;
   private java.util.Date[] T004P2_A907CatVigencia ;
   private java.math.BigDecimal[] T004P2_A122CatBasico ;
   private boolean[] T004P2_n122CatBasico ;
   private java.math.BigDecimal[] T004P2_A731CatValorHora ;
   private boolean[] T004P2_n731CatValorHora ;
   private java.math.BigDecimal[] T004P2_A908CatAdicional ;
   private boolean[] T004P2_n908CatAdicional ;
   private java.math.BigDecimal[] T004P2_A909CatAdiHora ;
   private boolean[] T004P2_n909CatAdiHora ;
   private int[] T004P2_A1891CatSalRelSec ;
   private boolean[] T004P2_n1891CatSalRelSec ;
   private java.math.BigDecimal[] T004P2_A1892EscBasico ;
   private java.math.BigDecimal[] T004P2_A1893EscAdicional ;
   private String[] T004P2_A2042CatSalRelRef ;
   private String[] T004P2_A2043CatSalOld ;
   private int[] T004P2_A3CliCod ;
   private short[] T004P2_A1564CliPaiConve ;
   private String[] T004P2_A1565CliConvenio ;
   private String[] T004P2_A8CatCodigo ;
   private int[] T004P13_A3CliCod ;
   private short[] T004P13_A1564CliPaiConve ;
   private String[] T004P13_A1565CliConvenio ;
   private String[] T004P13_A8CatCodigo ;
   private java.util.Date[] T004P13_A907CatVigencia ;
   private int[] T004P14_A3CliCod ;
   private short[] T004P14_A1564CliPaiConve ;
   private String[] T004P14_A1565CliConvenio ;
   private String[] T004P14_A8CatCodigo ;
   private String[] T004P14_A123CatDescrip ;
   private int[] T004P15_A3CliCod ;
   private int[] T004P15_A1885CliRelSec ;
   private String[] T004P15_A1880CliReDTChar ;
   private int[] T004P16_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
}

final  class escalasalarial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004P2", "SELECT CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, CatSalRelSec, EscBasico, EscAdicional, CatSalRelRef, CatSalOld, CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?  FOR UPDATE OF Categoriavalores1 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P3", "SELECT CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, CatSalRelSec, EscBasico, EscAdicional, CatSalRelRef, CatSalOld, CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P4", "SELECT CliCod FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P5", "SELECT TM1.CatVigencia, TM1.CatBasico, TM1.CatValorHora, TM1.CatAdicional, TM1.CatAdiHora, TM1.CatSalRelSec, TM1.EscBasico, TM1.EscAdicional, TM1.CatSalRelRef, TM1.CatSalOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CatCodigo FROM Categoriavalores1 TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CatCodigo = ( ?) and TM1.CatVigencia = ? ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CatCodigo, TM1.CatVigencia ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P6", "SELECT CliCod FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P7", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P8", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatCodigo > ( ?) or CatCodigo = ( ?) and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatVigencia > ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004P9", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatCodigo < ( ?) or CatCodigo = ( ?) and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatVigencia < ?) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, CatCodigo DESC, CatVigencia DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004P10", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, CatSalRelSec, EscBasico, EscAdicional, CatSalRelRef, CatSalOld, CliCod, CliPaiConve, CliConvenio, CatCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004P11", "SAVEPOINT gxupdate;UPDATE Categoriavalores1 SET CatBasico=?, CatValorHora=?, CatAdicional=?, CatAdiHora=?, CatSalRelSec=?, EscBasico=?, EscAdicional=?, CatSalRelRef=?, CatSalOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004P12", "SAVEPOINT gxupdate;DELETE FROM Categoriavalores1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004P13", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P14", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatDescrip FROM Categoria1 WHERE (CliCod = ?) AND (CliPaiConve = ?) AND (CliConvenio = ( ?)) ORDER BY CatDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P15", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004P16", "SELECT CliCod FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[15])[0] = rslt.getInt(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((String[]) buf[18])[0] = rslt.getString(14, 40);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[15])[0] = rslt.getInt(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((String[]) buf[18])[0] = rslt.getString(14, 40);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[15])[0] = rslt.getInt(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((String[]) buf[18])[0] = rslt.getString(14, 40);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 14 :
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
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
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 6 :
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
               stmt.setString(11, (String)parms[10], 40);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setDate(15, (java.util.Date)parms[14]);
               return;
            case 7 :
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
               stmt.setString(11, (String)parms[10], 40);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setDate(15, (java.util.Date)parms[14]);
               return;
            case 8 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(2, (java.math.BigDecimal)parms[2], 2);
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
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(6, ((Number) parms[10]).intValue());
               }
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[12], 2);
               stmt.setVarchar(9, (String)parms[13], 40, false);
               stmt.setNLongVarchar(10, (String)parms[14], false);
               stmt.setInt(11, ((Number) parms[15]).intValue());
               stmt.setShort(12, ((Number) parms[16]).shortValue());
               stmt.setString(13, (String)parms[17], 20);
               stmt.setString(14, (String)parms[18], 40);
               return;
            case 9 :
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
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(5, ((Number) parms[9]).intValue());
               }
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[11], 2);
               stmt.setVarchar(8, (String)parms[12], 40, false);
               stmt.setNLongVarchar(9, (String)parms[13], false);
               stmt.setInt(10, ((Number) parms[14]).intValue());
               stmt.setShort(11, ((Number) parms[15]).shortValue());
               stmt.setString(12, (String)parms[16], 20);
               stmt.setString(13, (String)parms[17], 40);
               stmt.setDate(14, (java.util.Date)parms[18]);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
   }

}

