package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cliente_release_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action13") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1876CliRelease = localUtil.parseDTimeParm( httpContext.GetPar( "CliRelease")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1876CliRelease", localUtil.ttoc( A1876CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_13_5R251( Gx_mode, AV7CliCod, A1876CliRelease) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action15") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1885CliRelSec = (int)(GXutil.lval( httpContext.GetPar( "CliRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_15_5R251( A3CliCod, A1885CliRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"CLIRELSEC") == 0 )
      {
         AV14CliRelSec = (int)(GXutil.lval( httpContext.GetPar( "CliRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliRelSec), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIRELSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliRelSec), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx4asaclirelsec5R251( AV14CliRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"CLIRELSEC") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asaclirelsec5R251( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A3CliCod) ;
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
            AV14CliRelSec = (int)(GXutil.lval( httpContext.GetPar( "CliRelSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14CliRelSec), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIRELSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliRelSec), "ZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Liberación de actualizaciones", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliRelease_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public cliente_release_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cliente_release_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_release_impl.class ));
   }

   public cliente_release_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkCliReHabilitado = UIFactory.getCheckbox(this);
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
      A1877CliReHabilitado = GXutil.strtobool( GXutil.booltostr( A1877CliReHabilitado)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliRelease_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliRelease_Internalname, httpContext.getMessage( "Fecha/hora de liberación", ""), "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCliRelease_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliRelease_Internalname, localUtil.ttoc( A1876CliRelease, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A1876CliRelease, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliRelease_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtCliRelease_Enabled, 1, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Release.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtCliRelease_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCliRelease_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cliente_Release.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliRelNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliRelNombre_Internalname, httpContext.getMessage( "Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliRelNombre_Internalname, A1973CliRelNombre, GXutil.rtrim( localUtil.format( A1973CliRelNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliRelNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliRelNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cliente_Release.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliReleaseDes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliReleaseDes_Internalname, httpContext.getMessage( "Descripcion", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCliReleaseDes_Internalname, A1879CliReleaseDes, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtCliReleaseDes_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Cliente_Release.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCliReHabilitado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkCliReHabilitado.getInternalname(), httpContext.getMessage( "Habilitado", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkCliReHabilitado.getInternalname(), GXutil.booltostr( A1877CliReHabilitado), "", httpContext.getMessage( "Habilitado", ""), 1, chkCliReHabilitado.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliReObs_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliReObs_Internalname, httpContext.getMessage( "Observaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCliReObs_Internalname, A1878CliReObs, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", (short)(0), 1, edtCliReObs_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Cliente_Release.htm");
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente_Release.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente_Release.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cliente_Release.htm");
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
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Release.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1885CliRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1885CliRelSec), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliRelSec_Jsonclick, 0, "Attribute", "", "", "", "", edtCliRelSec_Visible, edtCliRelSec_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cliente_Release.htm");
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
      e115R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1885CliRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1885CliRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1880CliReDTChar = httpContext.cgiGet( "Z1880CliReDTChar") ;
            Z1876CliRelease = localUtil.ctot( httpContext.cgiGet( "Z1876CliRelease"), 0) ;
            Z1973CliRelNombre = httpContext.cgiGet( "Z1973CliRelNombre") ;
            Z1879CliReleaseDes = httpContext.cgiGet( "Z1879CliReleaseDes") ;
            Z1877CliReHabilitado = GXutil.strtobool( httpContext.cgiGet( "Z1877CliReHabilitado")) ;
            A1880CliReDTChar = httpContext.cgiGet( "Z1880CliReDTChar") ;
            O1876CliRelease = localUtil.ctot( httpContext.cgiGet( "O1876CliRelease"), 0) ;
            O1877CliReHabilitado = GXutil.strtobool( httpContext.cgiGet( "O1877CliReHabilitado")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A1880CliReDTChar = httpContext.cgiGet( "CLIREDTCHAR") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV14CliRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "vCLIRELSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV17errorFechaEs = GXutil.strtobool( httpContext.cgiGet( "vERRORFECHAES")) ;
            AV16auxCliRelease = localUtil.ctot( httpContext.cgiGet( "vAUXCLIRELEASE"), 0) ;
            AV18alguienYaActualizo = GXutil.strtobool( httpContext.cgiGet( "vALGUIENYAACTUALIZO")) ;
            AV20Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( localUtil.vcdtime( httpContext.cgiGet( edtCliRelease_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "CLIRELEASE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliRelease_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
               httpContext.ajax_rsp_assign_attri("", false, "A1876CliRelease", localUtil.ttoc( A1876CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            }
            else
            {
               A1876CliRelease = localUtil.ctot( httpContext.cgiGet( edtCliRelease_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1876CliRelease", localUtil.ttoc( A1876CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            }
            A1973CliRelNombre = httpContext.cgiGet( edtCliRelNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1973CliRelNombre", A1973CliRelNombre);
            A1879CliReleaseDes = httpContext.cgiGet( edtCliReleaseDes_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1879CliReleaseDes", A1879CliReleaseDes);
            A1877CliReHabilitado = GXutil.strtobool( httpContext.cgiGet( chkCliReHabilitado.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
            A1878CliReObs = httpContext.cgiGet( edtCliReObs_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1878CliReObs", A1878CliReObs);
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIRELSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliRelSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1885CliRelSec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
            }
            else
            {
               A1885CliRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtCliRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Cliente_Release");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1885CliRelSec != Z1885CliRelSec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("cliente_release:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1885CliRelSec = (int)(GXutil.lval( httpContext.GetPar( "CliRelSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
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
                  sMode251 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode251 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound251 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5R0( ) ;
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
                        e115R2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125R2 ();
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
         e125R2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5R251( ) ;
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
         disableAttributes5R251( ) ;
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

   public void confirm_5R0( )
   {
      beforeValidate5R251( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5R251( ) ;
         }
         else
         {
            checkExtendedTable5R251( ) ;
            closeExtendedTableCursors5R251( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5R0( )
   {
   }

   public void e115R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Release_Insert", GXv_boolean3) ;
         cliente_release_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Release_Update", GXv_boolean3) ;
         cliente_release_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Release_Delete", GXv_boolean3) ;
         cliente_release_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV20Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliRelSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliRelSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliRelSec_Visible), 5, 0), true);
   }

   public void e125R2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "aftertrn mode ", "")+Gx_mode) ;
      if ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "DLT", "")) == 0 ) || ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) && ( !( GXutil.dateCompare(A1876CliRelease, O1876CliRelease) ) ) || ( GXutil.strcmp(A1879CliReleaseDes, O1879CliReleaseDes) != 0 ) ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "llama &CliCod ", "")+GXutil.trim( GXutil.str( A3CliCod, 6, 0))+httpContext.getMessage( " sec ¿ + ¿ ", "")+GXutil.trim( GXutil.str( A1885CliRelSec, 6, 0))) ;
         new web.actualizacionescliente(remoteHandle, context).execute( Gx_mode, A3CliCod, A1885CliRelSec, A1876CliRelease, A1879CliReleaseDes, A1973CliRelNombre) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm5R251( int GX_JID )
   {
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1880CliReDTChar = T005R3_A1880CliReDTChar[0] ;
            Z1876CliRelease = T005R3_A1876CliRelease[0] ;
            Z1973CliRelNombre = T005R3_A1973CliRelNombre[0] ;
            Z1879CliReleaseDes = T005R3_A1879CliReleaseDes[0] ;
            Z1877CliReHabilitado = T005R3_A1877CliReHabilitado[0] ;
         }
         else
         {
            Z1880CliReDTChar = A1880CliReDTChar ;
            Z1876CliRelease = A1876CliRelease ;
            Z1973CliRelNombre = A1973CliRelNombre ;
            Z1879CliReleaseDes = A1879CliReleaseDes ;
            Z1877CliReHabilitado = A1877CliReHabilitado ;
         }
      }
      if ( GX_JID == -17 )
      {
         Z1880CliReDTChar = A1880CliReDTChar ;
         Z1885CliRelSec = A1885CliRelSec ;
         Z1876CliRelease = A1876CliRelease ;
         Z1973CliRelNombre = A1973CliRelNombre ;
         Z1879CliReleaseDes = A1879CliReleaseDes ;
         Z1877CliReHabilitado = A1877CliReHabilitado ;
         Z1878CliReObs = A1878CliReObs ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      edtCliRelease_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliRelease_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliRelease_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
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
      if ( ! (0==AV14CliRelSec) )
      {
         A1885CliRelSec = AV14CliRelSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
      }
      if ( ! (0==AV14CliRelSec) )
      {
         edtCliRelSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliRelSec_Enabled), 5, 0), true);
      }
      else
      {
         edtCliRelSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliRelSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV14CliRelSec) )
      {
         edtCliRelSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliRelSec_Enabled), 5, 0), true);
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
      if ( isIns( )  && (false==A1877CliReHabilitado) && ( Gx_BScreen == 0 ) )
      {
         A1877CliReHabilitado = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV20Pgmname = "Cliente_Release" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
   }

   public void load5R251( )
   {
      /* Using cursor T005R5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound251 = (short)(1) ;
         A1880CliReDTChar = T005R5_A1880CliReDTChar[0] ;
         A1876CliRelease = T005R5_A1876CliRelease[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1876CliRelease", localUtil.ttoc( A1876CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A1973CliRelNombre = T005R5_A1973CliRelNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1973CliRelNombre", A1973CliRelNombre);
         A1879CliReleaseDes = T005R5_A1879CliReleaseDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1879CliReleaseDes", A1879CliReleaseDes);
         A1877CliReHabilitado = T005R5_A1877CliReHabilitado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
         A1878CliReObs = T005R5_A1878CliReObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1878CliReObs", A1878CliReObs);
         zm5R251( -17) ;
      }
      pr_default.close(3);
      onLoadActions5R251( ) ;
   }

   public void onLoadActions5R251( )
   {
      AV20Pgmname = "Cliente_Release" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      A1880CliReDTChar = GXutil.trim( A1973CliRelNombre) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1880CliReDTChar", A1880CliReDTChar);
   }

   public void checkExtendedTable5R251( )
   {
      nIsDirty_251 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV20Pgmname = "Cliente_Release" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      if ( isIns( )  )
      {
         GXv_boolean3[0] = AV17errorFechaEs ;
         GXv_dtime4[0] = AV16auxCliRelease ;
         new web.errorfecharelease(remoteHandle, context).execute( AV7CliCod, A1876CliRelease, GXv_boolean3, GXv_dtime4) ;
         cliente_release_impl.this.AV17errorFechaEs = GXv_boolean3[0] ;
         cliente_release_impl.this.AV16auxCliRelease = GXv_dtime4[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17errorFechaEs", AV17errorFechaEs);
         httpContext.ajax_rsp_assign_attri("", false, "AV16auxCliRelease", localUtil.ttoc( AV16auxCliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
      if ( isIns( )  && ( AV17errorFechaEs ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No se puede crear un release con fecha anterior a release más reciente \"", "")+GXutil.trim( localUtil.ttoc( AV16auxCliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\"", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor T005R4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T005R6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A1973CliRelNombre, Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Nombre", "")}), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      GXv_boolean3[0] = AV18alguienYaActualizo ;
      new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A1885CliRelSec, GXv_boolean3) ;
      cliente_release_impl.this.AV18alguienYaActualizo = GXv_boolean3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18alguienYaActualizo", AV18alguienYaActualizo);
      if ( isUpd( )  && ( AV18alguienYaActualizo ) && ( !( GXutil.dateCompare(A1876CliRelease, O1876CliRelease) ) || ( A1877CliReHabilitado != O1877CliReHabilitado ) ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No se puede modificar la fecha de release ni el habilitado cuando ya ha sido aplicado por un cliente", ""), 1, "CLIRELEASE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliRelease_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), A1876CliRelease) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha/hora de liberación", ""), "", "", "", "", "", "", "", ""), 1, "CLIRELEASE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliRelease_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_251 = (short)(1) ;
      A1880CliReDTChar = GXutil.trim( A1973CliRelNombre) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1880CliReDTChar", A1880CliReDTChar);
      if ( (GXutil.strcmp("", A1973CliRelNombre)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombre", ""), "", "", "", "", "", "", "", ""), 1, "CLIRELNOMBRE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliRelNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors5R251( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_19( int A3CliCod )
   {
      /* Using cursor T005R7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void getKey5R251( )
   {
      /* Using cursor T005R8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound251 = (short)(1) ;
      }
      else
      {
         RcdFound251 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005R3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5R251( 17) ;
         RcdFound251 = (short)(1) ;
         A1880CliReDTChar = T005R3_A1880CliReDTChar[0] ;
         A1885CliRelSec = T005R3_A1885CliRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
         A1876CliRelease = T005R3_A1876CliRelease[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1876CliRelease", localUtil.ttoc( A1876CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A1973CliRelNombre = T005R3_A1973CliRelNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1973CliRelNombre", A1973CliRelNombre);
         A1879CliReleaseDes = T005R3_A1879CliReleaseDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1879CliReleaseDes", A1879CliReleaseDes);
         A1877CliReHabilitado = T005R3_A1877CliReHabilitado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
         A1878CliReObs = T005R3_A1878CliReObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1878CliReObs", A1878CliReObs);
         A3CliCod = T005R3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         O1876CliRelease = A1876CliRelease ;
         httpContext.ajax_rsp_assign_attri("", false, "A1876CliRelease", localUtil.ttoc( A1876CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         O1877CliReHabilitado = A1877CliReHabilitado ;
         httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
         Z3CliCod = A3CliCod ;
         Z1885CliRelSec = A1885CliRelSec ;
         sMode251 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5R251( ) ;
         if ( AnyError == 1 )
         {
            RcdFound251 = (short)(0) ;
            initializeNonKey5R251( ) ;
         }
         Gx_mode = sMode251 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound251 = (short)(0) ;
         initializeNonKey5R251( ) ;
         sMode251 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode251 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5R251( ) ;
      if ( RcdFound251 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound251 = (short)(0) ;
      /* Using cursor T005R9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T005R9_A3CliCod[0] < A3CliCod ) || ( T005R9_A3CliCod[0] == A3CliCod ) && ( T005R9_A1885CliRelSec[0] < A1885CliRelSec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T005R9_A3CliCod[0] > A3CliCod ) || ( T005R9_A3CliCod[0] == A3CliCod ) && ( T005R9_A1885CliRelSec[0] > A1885CliRelSec ) ) )
         {
            A3CliCod = T005R9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1885CliRelSec = T005R9_A1885CliRelSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
            RcdFound251 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound251 = (short)(0) ;
      /* Using cursor T005R10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005R10_A3CliCod[0] > A3CliCod ) || ( T005R10_A3CliCod[0] == A3CliCod ) && ( T005R10_A1885CliRelSec[0] > A1885CliRelSec ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005R10_A3CliCod[0] < A3CliCod ) || ( T005R10_A3CliCod[0] == A3CliCod ) && ( T005R10_A1885CliRelSec[0] < A1885CliRelSec ) ) )
         {
            A3CliCod = T005R10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1885CliRelSec = T005R10_A1885CliRelSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
            RcdFound251 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5R251( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliRelease_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5R251( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound251 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1885CliRelSec != Z1885CliRelSec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1885CliRelSec = Z1885CliRelSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliRelease_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5R251( ) ;
               GX_FocusControl = edtCliRelease_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1885CliRelSec != Z1885CliRelSec ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliRelease_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5R251( ) ;
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
                  GX_FocusControl = edtCliRelease_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5R251( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1885CliRelSec != Z1885CliRelSec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1885CliRelSec = Z1885CliRelSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliRelease_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5R251( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005R2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cliente_Release"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1880CliReDTChar, T005R2_A1880CliReDTChar[0]) != 0 ) || !( GXutil.dateCompare(Z1876CliRelease, T005R2_A1876CliRelease[0]) ) || ( GXutil.strcmp(Z1973CliRelNombre, T005R2_A1973CliRelNombre[0]) != 0 ) || ( GXutil.strcmp(Z1879CliReleaseDes, T005R2_A1879CliReleaseDes[0]) != 0 ) || ( Z1877CliReHabilitado != T005R2_A1877CliReHabilitado[0] ) )
         {
            if ( GXutil.strcmp(Z1880CliReDTChar, T005R2_A1880CliReDTChar[0]) != 0 )
            {
               GXutil.writeLogln("cliente_release:[seudo value changed for attri]"+"CliReDTChar");
               GXutil.writeLogRaw("Old: ",Z1880CliReDTChar);
               GXutil.writeLogRaw("Current: ",T005R2_A1880CliReDTChar[0]);
            }
            if ( !( GXutil.dateCompare(Z1876CliRelease, T005R2_A1876CliRelease[0]) ) )
            {
               GXutil.writeLogln("cliente_release:[seudo value changed for attri]"+"CliRelease");
               GXutil.writeLogRaw("Old: ",Z1876CliRelease);
               GXutil.writeLogRaw("Current: ",T005R2_A1876CliRelease[0]);
            }
            if ( GXutil.strcmp(Z1973CliRelNombre, T005R2_A1973CliRelNombre[0]) != 0 )
            {
               GXutil.writeLogln("cliente_release:[seudo value changed for attri]"+"CliRelNombre");
               GXutil.writeLogRaw("Old: ",Z1973CliRelNombre);
               GXutil.writeLogRaw("Current: ",T005R2_A1973CliRelNombre[0]);
            }
            if ( GXutil.strcmp(Z1879CliReleaseDes, T005R2_A1879CliReleaseDes[0]) != 0 )
            {
               GXutil.writeLogln("cliente_release:[seudo value changed for attri]"+"CliReleaseDes");
               GXutil.writeLogRaw("Old: ",Z1879CliReleaseDes);
               GXutil.writeLogRaw("Current: ",T005R2_A1879CliReleaseDes[0]);
            }
            if ( Z1877CliReHabilitado != T005R2_A1877CliReHabilitado[0] )
            {
               GXutil.writeLogln("cliente_release:[seudo value changed for attri]"+"CliReHabilitado");
               GXutil.writeLogRaw("Old: ",Z1877CliReHabilitado);
               GXutil.writeLogRaw("Current: ",T005R2_A1877CliReHabilitado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Cliente_Release"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5R251( )
   {
      beforeValidate5R251( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5R251( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5R251( 0) ;
         checkOptimisticConcurrency5R251( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5R251( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5R251( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005R11 */
                  pr_default.execute(9, new Object[] {A1880CliReDTChar, Integer.valueOf(A1885CliRelSec), A1876CliRelease, A1973CliRelNombre, A1879CliReleaseDes, Boolean.valueOf(A1877CliReHabilitado), A1878CliReObs, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Release");
                  if ( (pr_default.getStatus(9) == 1) )
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
                        resetCaption5R0( ) ;
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
            load5R251( ) ;
         }
         endLevel5R251( ) ;
      }
      closeExtendedTableCursors5R251( ) ;
   }

   public void update5R251( )
   {
      beforeValidate5R251( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5R251( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5R251( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5R251( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5R251( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005R12 */
                  pr_default.execute(10, new Object[] {A1880CliReDTChar, A1876CliRelease, A1973CliRelNombre, A1879CliReleaseDes, Boolean.valueOf(A1877CliReHabilitado), A1878CliReObs, Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Release");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cliente_Release"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5R251( ) ;
                  if ( AnyError == 0 )
                  {
                     GXv_int5[0] = A3CliCod ;
                     GXv_int6[0] = A1885CliRelSec ;
                     new web.cliente_releaseupdateredundancy(remoteHandle, context).execute( GXv_int5, GXv_int6) ;
                     cliente_release_impl.this.A3CliCod = GXv_int5[0] ;
                     cliente_release_impl.this.A1885CliRelSec = GXv_int6[0] ;
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
         endLevel5R251( ) ;
      }
      closeExtendedTableCursors5R251( ) ;
   }

   public void deferredUpdate5R251( )
   {
   }

   public void delete( )
   {
      beforeValidate5R251( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5R251( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5R251( ) ;
         afterConfirm5R251( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5R251( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005R13 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Release");
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
      sMode251 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5R251( ) ;
      Gx_mode = sMode251 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5R251( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  )
         {
            GXv_boolean3[0] = AV17errorFechaEs ;
            GXv_dtime4[0] = AV16auxCliRelease ;
            new web.errorfecharelease(remoteHandle, context).execute( AV7CliCod, A1876CliRelease, GXv_boolean3, GXv_dtime4) ;
            cliente_release_impl.this.AV17errorFechaEs = GXv_boolean3[0] ;
            cliente_release_impl.this.AV16auxCliRelease = GXv_dtime4[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17errorFechaEs", AV17errorFechaEs);
            httpContext.ajax_rsp_assign_attri("", false, "AV16auxCliRelease", localUtil.ttoc( AV16auxCliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( isIns( )  && ( AV17errorFechaEs ) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "No se puede crear un release con fecha anterior a release más reciente \"", "")+GXutil.trim( localUtil.ttoc( AV16auxCliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\"", 1, "");
            AnyError = (short)(1) ;
         }
         AV20Pgmname = "Cliente_Release" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Pgmname", AV20Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T005R14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente_Update", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel5R251( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5R251( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "cliente_release");
         if ( AnyError == 0 )
         {
            confirmValues5R0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "cliente_release");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5R251( )
   {
      /* Scan By routine */
      /* Using cursor T005R15 */
      pr_default.execute(13);
      RcdFound251 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound251 = (short)(1) ;
         A3CliCod = T005R15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1885CliRelSec = T005R15_A1885CliRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5R251( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound251 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound251 = (short)(1) ;
         A3CliCod = T005R15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1885CliRelSec = T005R15_A1885CliRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
      }
   }

   public void scanEnd5R251( )
   {
      pr_default.close(13);
   }

   public void afterConfirm5R251( )
   {
      /* After Confirm Rules */
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int7 = A1885CliRelSec ;
         GXv_int6[0] = GXt_int7 ;
         new web.getnextrelease(remoteHandle, context).execute( A3CliCod, GXv_int6) ;
         cliente_release_impl.this.GXt_int7 = GXv_int6[0] ;
         A1885CliRelSec = GXt_int7 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
      }
   }

   public void beforeInsert5R251( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5R251( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5R251( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5R251( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5R251( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5R251( )
   {
      edtCliRelease_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliRelease_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliRelease_Enabled), 5, 0), true);
      edtCliRelNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliRelNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliRelNombre_Enabled), 5, 0), true);
      edtCliReleaseDes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliReleaseDes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliReleaseDes_Enabled), 5, 0), true);
      chkCliReHabilitado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCliReHabilitado.getInternalname(), "Enabled", GXutil.ltrimstr( chkCliReHabilitado.getEnabled(), 5, 0), true);
      edtCliReObs_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliReObs_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliReObs_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliRelSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliRelSec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5R251( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5R0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.cliente_release", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14CliRelSec,6,0))}, new String[] {"Gx_mode","CliCod","CliRelSec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Cliente_Release");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("cliente_release:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1885CliRelSec", GXutil.ltrim( localUtil.ntoc( Z1885CliRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1880CliReDTChar", Z1880CliReDTChar);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1876CliRelease", localUtil.ttoc( Z1876CliRelease, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1973CliRelNombre", Z1973CliRelNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1879CliReleaseDes", Z1879CliReleaseDes);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1877CliReHabilitado", Z1877CliReHabilitado);
      web.GxWebStd.gx_hidden_field( httpContext, "O1876CliRelease", localUtil.ttoc( O1876CliRelease, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1877CliReHabilitado", O1877CliReHabilitado);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIREDTCHAR", A1880CliReDTChar);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIRELSEC", GXutil.ltrim( localUtil.ntoc( AV14CliRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIRELSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14CliRelSec), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vERRORFECHAES", AV17errorFechaEs);
      web.GxWebStd.gx_hidden_field( httpContext, "vAUXCLIRELEASE", localUtil.ttoc( AV16auxCliRelease, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vALGUIENYAACTUALIZO", AV18alguienYaActualizo);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV20Pgmname));
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
      return formatLink("web.cliente_release", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14CliRelSec,6,0))}, new String[] {"Gx_mode","CliCod","CliRelSec"})  ;
   }

   public String getPgmname( )
   {
      return "Cliente_Release" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Liberación de actualizaciones", "") ;
   }

   public void initializeNonKey5R251( )
   {
      AV17errorFechaEs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17errorFechaEs", AV17errorFechaEs);
      AV16auxCliRelease = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "AV16auxCliRelease", localUtil.ttoc( AV16auxCliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      AV18alguienYaActualizo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18alguienYaActualizo", AV18alguienYaActualizo);
      A1880CliReDTChar = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1880CliReDTChar", A1880CliReDTChar);
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A1876CliRelease", localUtil.ttoc( A1876CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A1973CliRelNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1973CliRelNombre", A1973CliRelNombre);
      A1879CliReleaseDes = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1879CliReleaseDes", A1879CliReleaseDes);
      A1878CliReObs = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1878CliReObs", A1878CliReObs);
      A1877CliReHabilitado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
      O1876CliRelease = A1876CliRelease ;
      httpContext.ajax_rsp_assign_attri("", false, "A1876CliRelease", localUtil.ttoc( A1876CliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      O1877CliReHabilitado = A1877CliReHabilitado ;
      httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
      Z1880CliReDTChar = "" ;
      Z1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      Z1973CliRelNombre = "" ;
      Z1879CliReleaseDes = "" ;
      Z1877CliReHabilitado = false ;
   }

   public void initAll5R251( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1885CliRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
      initializeNonKey5R251( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1877CliReHabilitado = i1877CliReHabilitado ;
      httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122019445478", true, true);
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
      httpContext.AddJavascriptSource("cliente_release.js", "?2024122019445478", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCliRelease_Internalname = "CLIRELEASE" ;
      edtCliRelNombre_Internalname = "CLIRELNOMBRE" ;
      edtCliReleaseDes_Internalname = "CLIRELEASEDES" ;
      chkCliReHabilitado.setInternalname( "CLIREHABILITADO" );
      edtCliReObs_Internalname = "CLIREOBS" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliRelSec_Internalname = "CLIRELSEC" ;
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
      Form.setCaption( httpContext.getMessage( "Liberación de actualizaciones", "") );
      edtCliRelSec_Jsonclick = "" ;
      edtCliRelSec_Enabled = 1 ;
      edtCliRelSec_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtCliReObs_Enabled = 1 ;
      chkCliReHabilitado.setEnabled( 1 );
      edtCliReleaseDes_Enabled = 1 ;
      edtCliRelNombre_Jsonclick = "" ;
      edtCliRelNombre_Enabled = 1 ;
      edtCliRelease_Jsonclick = "" ;
      edtCliRelease_Enabled = 1 ;
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

   public void gx4asaclirelsec5R251( int AV14CliRelSec )
   {
      if ( ! (0==AV14CliRelSec) )
      {
         A1885CliRelSec = AV14CliRelSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1885CliRelSec, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx5asaclirelsec5R251( int A3CliCod )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int7 = A1885CliRelSec ;
         GXv_int6[0] = GXt_int7 ;
         new web.getnextrelease(remoteHandle, context).execute( A3CliCod, GXv_int6) ;
         cliente_release_impl.this.GXt_int7 = GXv_int6[0] ;
         A1885CliRelSec = GXt_int7 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1885CliRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1885CliRelSec), 6, 0));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1885CliRelSec, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_13_5R251( String Gx_mode ,
                            int AV7CliCod ,
                            java.util.Date A1876CliRelease )
   {
      if ( isIns( )  )
      {
         GXv_boolean3[0] = AV17errorFechaEs ;
         GXv_dtime4[0] = AV16auxCliRelease ;
         new web.errorfecharelease(remoteHandle, context).execute( AV7CliCod, A1876CliRelease, GXv_boolean3, GXv_dtime4) ;
         AV17errorFechaEs = GXv_boolean3[0] ;
         AV16auxCliRelease = GXv_dtime4[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17errorFechaEs", AV17errorFechaEs);
         httpContext.ajax_rsp_assign_attri("", false, "AV16auxCliRelease", localUtil.ttoc( AV16auxCliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV17errorFechaEs))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( localUtil.ttoc( AV16auxCliRelease, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_15_5R251( int A3CliCod ,
                            int A1885CliRelSec )
   {
      GXv_boolean3[0] = AV18alguienYaActualizo ;
      new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A1885CliRelSec, GXv_boolean3) ;
      AV18alguienYaActualizo = GXv_boolean3[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18alguienYaActualizo", AV18alguienYaActualizo);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV18alguienYaActualizo))+"\"") ;
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
      chkCliReHabilitado.setName( "CLIREHABILITADO" );
      chkCliReHabilitado.setWebtags( "" );
      chkCliReHabilitado.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCliReHabilitado.getInternalname(), "TitleCaption", chkCliReHabilitado.getCaption(), true);
      chkCliReHabilitado.setCheckedValue( "false" );
      if ( isIns( ) && (false==A1877CliReHabilitado) )
      {
         A1877CliReHabilitado = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1877CliReHabilitado", A1877CliReHabilitado);
      }
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
      /* Using cursor T005R16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Clirelsec( )
   {
      GXv_boolean3[0] = AV18alguienYaActualizo ;
      new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A1885CliRelSec, GXv_boolean3) ;
      cliente_release_impl.this.AV18alguienYaActualizo = GXv_boolean3[0] ;
      AV18alguienYaActualizo = this.AV18alguienYaActualizo ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV18alguienYaActualizo", AV18alguienYaActualizo);
   }

   public void valid_Clirelease( )
   {
      if ( GXutil.dateCompare(GXutil.nullDate(), A1876CliRelease) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha/hora de liberación", ""), "", "", "", "", "", "", "", ""), 1, "CLIRELEASE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliRelease_Internalname ;
      }
      if ( isIns( )  )
      {
         GXv_boolean3[0] = AV17errorFechaEs ;
         GXv_dtime4[0] = AV16auxCliRelease ;
         new web.errorfecharelease(remoteHandle, context).execute( AV7CliCod, A1876CliRelease, GXv_boolean3, GXv_dtime4) ;
         cliente_release_impl.this.AV17errorFechaEs = GXv_boolean3[0] ;
         AV17errorFechaEs = this.AV17errorFechaEs ;
         cliente_release_impl.this.AV16auxCliRelease = GXv_dtime4[0] ;
         AV16auxCliRelease = this.AV16auxCliRelease ;
      }
      if ( isIns( )  && ( AV17errorFechaEs ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "No se puede crear un release con fecha anterior a release más reciente \"", "")+GXutil.trim( localUtil.ttoc( AV16auxCliRelease, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\"", 1, "CLIRELEASE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliRelease_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV17errorFechaEs", AV17errorFechaEs);
      httpContext.ajax_rsp_assign_attri("", false, "AV16auxCliRelease", localUtil.ttoc( AV16auxCliRelease, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
   }

   public void valid_Clirelnombre( )
   {
      /* Using cursor T005R17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A1973CliRelNombre, Integer.valueOf(A3CliCod), Integer.valueOf(A1885CliRelSec)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {httpContext.getMessage( "Cli Cod", "")+","+httpContext.getMessage( "Nombre", "")}), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(15);
      A1880CliReDTChar = GXutil.trim( A1973CliRelNombre) ;
      if ( (GXutil.strcmp("", A1973CliRelNombre)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombre", ""), "", "", "", "", "", "", "", ""), 1, "CLIRELNOMBRE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliRelNombre_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1880CliReDTChar", A1880CliReDTChar);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14CliRelSec',fld:'vCLIRELSEC',pic:'ZZZZZ9',hsh:true},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV14CliRelSec',fld:'vCLIRELSEC',pic:'ZZZZZ9',hsh:true},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e125R2',iparms:[{av:'AV20Pgmname',fld:'vPGMNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1876CliRelease'},{av:'A1876CliRelease',fld:'CLIRELEASE',pic:'99/99/99 99:99'},{av:'A1879CliReleaseDes',fld:'CLIRELEASEDES',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1885CliRelSec',fld:'CLIRELSEC',pic:'ZZZZZ9'},{av:'A1973CliRelNombre',fld:'CLIRELNOMBRE',pic:''},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]}");
      setEventMetadata("VALID_CLIRELEASE","{handler:'valid_Clirelease',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A1876CliRelease',fld:'CLIRELEASE',pic:'99/99/99 99:99'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV16auxCliRelease',fld:'vAUXCLIRELEASE',pic:'99/99/99 99:99'},{av:'AV17errorFechaEs',fld:'vERRORFECHAES',pic:''},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]");
      setEventMetadata("VALID_CLIRELEASE",",oparms:[{av:'AV17errorFechaEs',fld:'vERRORFECHAES',pic:''},{av:'AV16auxCliRelease',fld:'vAUXCLIRELEASE',pic:'99/99/99 99:99'},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]}");
      setEventMetadata("VALID_CLIRELNOMBRE","{handler:'valid_Clirelnombre',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1973CliRelNombre',fld:'CLIRELNOMBRE',pic:''},{av:'A1885CliRelSec',fld:'CLIRELSEC',pic:'ZZZZZ9'},{av:'A1880CliReDTChar',fld:'CLIREDTCHAR',pic:''},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]");
      setEventMetadata("VALID_CLIRELNOMBRE",",oparms:[{av:'A1880CliReDTChar',fld:'CLIREDTCHAR',pic:''},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]}");
      setEventMetadata("VALID_CLIREHABILITADO","{handler:'valid_Clirehabilitado',iparms:[{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]");
      setEventMetadata("VALID_CLIREHABILITADO",",oparms:[{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]}");
      setEventMetadata("VALID_CLIRELSEC","{handler:'valid_Clirelsec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1885CliRelSec',fld:'CLIRELSEC',pic:'ZZZZZ9'},{av:'AV18alguienYaActualizo',fld:'vALGUIENYAACTUALIZO',pic:''},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]");
      setEventMetadata("VALID_CLIRELSEC",",oparms:[{av:'AV18alguienYaActualizo',fld:'vALGUIENYAACTUALIZO',pic:''},{av:'A1877CliReHabilitado',fld:'CLIREHABILITADO',pic:''}]}");
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
      Z1880CliReDTChar = "" ;
      Z1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      Z1973CliRelNombre = "" ;
      Z1879CliReleaseDes = "" ;
      O1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1973CliRelNombre = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1879CliReleaseDes = "" ;
      A1878CliReObs = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1880CliReDTChar = "" ;
      AV16auxCliRelease = GXutil.resetTime( GXutil.nullDate() );
      AV20Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode251 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      O1879CliReleaseDes = "" ;
      Z1878CliReObs = "" ;
      T005R5_A1880CliReDTChar = new String[] {""} ;
      T005R5_A1885CliRelSec = new int[1] ;
      T005R5_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      T005R5_A1973CliRelNombre = new String[] {""} ;
      T005R5_A1879CliReleaseDes = new String[] {""} ;
      T005R5_A1877CliReHabilitado = new boolean[] {false} ;
      T005R5_A1878CliReObs = new String[] {""} ;
      T005R5_A3CliCod = new int[1] ;
      T005R4_A3CliCod = new int[1] ;
      T005R6_A3CliCod = new int[1] ;
      T005R7_A3CliCod = new int[1] ;
      T005R8_A3CliCod = new int[1] ;
      T005R8_A1885CliRelSec = new int[1] ;
      T005R3_A1880CliReDTChar = new String[] {""} ;
      T005R3_A1885CliRelSec = new int[1] ;
      T005R3_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      T005R3_A1973CliRelNombre = new String[] {""} ;
      T005R3_A1879CliReleaseDes = new String[] {""} ;
      T005R3_A1877CliReHabilitado = new boolean[] {false} ;
      T005R3_A1878CliReObs = new String[] {""} ;
      T005R3_A3CliCod = new int[1] ;
      T005R9_A3CliCod = new int[1] ;
      T005R9_A1885CliRelSec = new int[1] ;
      T005R10_A3CliCod = new int[1] ;
      T005R10_A1885CliRelSec = new int[1] ;
      T005R2_A1880CliReDTChar = new String[] {""} ;
      T005R2_A1885CliRelSec = new int[1] ;
      T005R2_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      T005R2_A1973CliRelNombre = new String[] {""} ;
      T005R2_A1879CliReleaseDes = new String[] {""} ;
      T005R2_A1877CliReHabilitado = new boolean[] {false} ;
      T005R2_A1878CliReObs = new String[] {""} ;
      T005R2_A3CliCod = new int[1] ;
      GXv_int5 = new int[1] ;
      T005R14_A3CliCod = new int[1] ;
      T005R14_A1881CliUpdCliCod = new int[1] ;
      T005R14_A1887CliUpdRelSec = new int[1] ;
      T005R15_A3CliCod = new int[1] ;
      T005R15_A1885CliRelSec = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int6 = new int[1] ;
      T005R16_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_dtime4 = new java.util.Date[1] ;
      ZV16auxCliRelease = GXutil.resetTime( GXutil.nullDate() );
      T005R17_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente_release__default(),
         new Object[] {
             new Object[] {
            T005R2_A1880CliReDTChar, T005R2_A1885CliRelSec, T005R2_A1876CliRelease, T005R2_A1973CliRelNombre, T005R2_A1879CliReleaseDes, T005R2_A1877CliReHabilitado, T005R2_A1878CliReObs, T005R2_A3CliCod
            }
            , new Object[] {
            T005R3_A1880CliReDTChar, T005R3_A1885CliRelSec, T005R3_A1876CliRelease, T005R3_A1973CliRelNombre, T005R3_A1879CliReleaseDes, T005R3_A1877CliReHabilitado, T005R3_A1878CliReObs, T005R3_A3CliCod
            }
            , new Object[] {
            T005R4_A3CliCod
            }
            , new Object[] {
            T005R5_A1880CliReDTChar, T005R5_A1885CliRelSec, T005R5_A1876CliRelease, T005R5_A1973CliRelNombre, T005R5_A1879CliReleaseDes, T005R5_A1877CliReHabilitado, T005R5_A1878CliReObs, T005R5_A3CliCod
            }
            , new Object[] {
            T005R6_A3CliCod
            }
            , new Object[] {
            T005R7_A3CliCod
            }
            , new Object[] {
            T005R8_A3CliCod, T005R8_A1885CliRelSec
            }
            , new Object[] {
            T005R9_A3CliCod, T005R9_A1885CliRelSec
            }
            , new Object[] {
            T005R10_A3CliCod, T005R10_A1885CliRelSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005R14_A3CliCod, T005R14_A1881CliUpdCliCod, T005R14_A1887CliUpdRelSec
            }
            , new Object[] {
            T005R15_A3CliCod, T005R15_A1885CliRelSec
            }
            , new Object[] {
            T005R16_A3CliCod
            }
            , new Object[] {
            T005R17_A3CliCod
            }
         }
      );
      AV20Pgmname = "Cliente_Release" ;
      Z1877CliReHabilitado = false ;
      O1877CliReHabilitado = false ;
      A1877CliReHabilitado = false ;
      i1877CliReHabilitado = false ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound251 ;
   private short nIsDirty_251 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV14CliRelSec ;
   private int Z3CliCod ;
   private int Z1885CliRelSec ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int A1885CliRelSec ;
   private int AV14CliRelSec ;
   private int trnEnded ;
   private int edtCliRelease_Enabled ;
   private int edtCliRelNombre_Enabled ;
   private int edtCliReleaseDes_Enabled ;
   private int edtCliReObs_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliRelSec_Visible ;
   private int edtCliRelSec_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int GXv_int5[] ;
   private int idxLst ;
   private int GXt_int7 ;
   private int GXv_int6[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliRelease_Internalname ;
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
   private String edtCliRelease_Jsonclick ;
   private String edtCliRelNombre_Internalname ;
   private String edtCliRelNombre_Jsonclick ;
   private String edtCliReleaseDes_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtCliReObs_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliRelSec_Internalname ;
   private String edtCliRelSec_Jsonclick ;
   private String AV20Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode251 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z1876CliRelease ;
   private java.util.Date O1876CliRelease ;
   private java.util.Date A1876CliRelease ;
   private java.util.Date AV16auxCliRelease ;
   private java.util.Date GXv_dtime4[] ;
   private java.util.Date ZV16auxCliRelease ;
   private boolean Z1877CliReHabilitado ;
   private boolean O1877CliReHabilitado ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A1877CliReHabilitado ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV17errorFechaEs ;
   private boolean AV18alguienYaActualizo ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean i1877CliReHabilitado ;
   private boolean ZV18alguienYaActualizo ;
   private boolean GXv_boolean3[] ;
   private boolean ZV17errorFechaEs ;
   private String A1878CliReObs ;
   private String Z1878CliReObs ;
   private String Z1880CliReDTChar ;
   private String Z1973CliRelNombre ;
   private String Z1879CliReleaseDes ;
   private String A1973CliRelNombre ;
   private String A1879CliReleaseDes ;
   private String A1880CliReDTChar ;
   private String O1879CliReleaseDes ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkCliReHabilitado ;
   private IDataStoreProvider pr_default ;
   private String[] T005R5_A1880CliReDTChar ;
   private int[] T005R5_A1885CliRelSec ;
   private java.util.Date[] T005R5_A1876CliRelease ;
   private String[] T005R5_A1973CliRelNombre ;
   private String[] T005R5_A1879CliReleaseDes ;
   private boolean[] T005R5_A1877CliReHabilitado ;
   private String[] T005R5_A1878CliReObs ;
   private int[] T005R5_A3CliCod ;
   private int[] T005R4_A3CliCod ;
   private int[] T005R6_A3CliCod ;
   private int[] T005R7_A3CliCod ;
   private int[] T005R8_A3CliCod ;
   private int[] T005R8_A1885CliRelSec ;
   private String[] T005R3_A1880CliReDTChar ;
   private int[] T005R3_A1885CliRelSec ;
   private java.util.Date[] T005R3_A1876CliRelease ;
   private String[] T005R3_A1973CliRelNombre ;
   private String[] T005R3_A1879CliReleaseDes ;
   private boolean[] T005R3_A1877CliReHabilitado ;
   private String[] T005R3_A1878CliReObs ;
   private int[] T005R3_A3CliCod ;
   private int[] T005R9_A3CliCod ;
   private int[] T005R9_A1885CliRelSec ;
   private int[] T005R10_A3CliCod ;
   private int[] T005R10_A1885CliRelSec ;
   private String[] T005R2_A1880CliReDTChar ;
   private int[] T005R2_A1885CliRelSec ;
   private java.util.Date[] T005R2_A1876CliRelease ;
   private String[] T005R2_A1973CliRelNombre ;
   private String[] T005R2_A1879CliReleaseDes ;
   private boolean[] T005R2_A1877CliReHabilitado ;
   private String[] T005R2_A1878CliReObs ;
   private int[] T005R2_A3CliCod ;
   private int[] T005R14_A3CliCod ;
   private int[] T005R14_A1881CliUpdCliCod ;
   private int[] T005R14_A1887CliUpdRelSec ;
   private int[] T005R15_A3CliCod ;
   private int[] T005R15_A1885CliRelSec ;
   private int[] T005R16_A3CliCod ;
   private int[] T005R17_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class cliente_release__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005R2", "SELECT CliReDTChar, CliRelSec, CliRelease, CliRelNombre, CliReleaseDes, CliReHabilitado, CliReObs, CliCod FROM Cliente_Release WHERE CliCod = ? AND CliRelSec = ?  FOR UPDATE OF Cliente_Release NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R3", "SELECT CliReDTChar, CliRelSec, CliRelease, CliRelNombre, CliReleaseDes, CliReHabilitado, CliReObs, CliCod FROM Cliente_Release WHERE CliCod = ? AND CliRelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R4", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R5", "SELECT TM1.CliReDTChar, TM1.CliRelSec, TM1.CliRelease, TM1.CliRelNombre, TM1.CliReleaseDes, TM1.CliReHabilitado, TM1.CliReObs, TM1.CliCod FROM Cliente_Release TM1 WHERE TM1.CliCod = ? and TM1.CliRelSec = ? ORDER BY TM1.CliCod, TM1.CliRelSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R6", "SELECT CliCod FROM Cliente_Release WHERE (CliCod = ? AND CliRelNombre = ?) AND (Not ( CliCod = ? and CliRelSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R7", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R8", "SELECT CliCod, CliRelSec FROM Cliente_Release WHERE CliCod = ? AND CliRelSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R9", "SELECT CliCod, CliRelSec FROM Cliente_Release WHERE ( CliCod > ? or CliCod = ? and CliRelSec > ?) ORDER BY CliCod, CliRelSec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005R10", "SELECT CliCod, CliRelSec FROM Cliente_Release WHERE ( CliCod < ? or CliCod = ? and CliRelSec < ?) ORDER BY CliCod DESC, CliRelSec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005R11", "SAVEPOINT gxupdate;INSERT INTO Cliente_Release(CliReDTChar, CliRelSec, CliRelease, CliRelNombre, CliReleaseDes, CliReHabilitado, CliReObs, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005R12", "SAVEPOINT gxupdate;UPDATE Cliente_Release SET CliReDTChar=?, CliRelease=?, CliRelNombre=?, CliReleaseDes=?, CliReHabilitado=?, CliReObs=?  WHERE CliCod = ? AND CliRelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005R13", "SAVEPOINT gxupdate;DELETE FROM Cliente_Release  WHERE CliCod = ? AND CliRelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005R14", "SELECT CliCod, CliUpdCliCod, CliUpdRelSec FROM Cliente_Update WHERE CliUpdCliCod = ? AND CliUpdRelSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005R15", "SELECT CliCod, CliRelSec FROM Cliente_Release ORDER BY CliCod, CliRelSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R16", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005R17", "SELECT CliCod FROM Cliente_Release WHERE (CliCod = ? AND CliRelNombre = ?) AND (Not ( CliCod = ? and CliRelSec = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 500, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setNLongVarchar(7, (String)parms[6], false);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 500, false);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

