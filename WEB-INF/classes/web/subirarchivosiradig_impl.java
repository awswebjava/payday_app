package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class subirarchivosiradig_impl extends GXDataArea
{
   public subirarchivosiradig_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public subirarchivosiradig_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( subirarchivosiradig_impl.class ));
   }

   public subirarchivosiradig_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "TrnMode") ;
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
            AV10TrnMode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10TrnMode", AV10TrnMode);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10TrnMode, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV15CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15CliCod), 6, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
               AV16EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16EmpCod), "ZZZ9")));
               AV20ArchSiradigFec = localUtil.parseDTimeParm( httpContext.GetPar( "ArchSiradigFec")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20ArchSiradigFec", localUtil.ttoc( AV20ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARCHSIRADIGFEC", getSecureSignedToken( "", localUtil.format( AV20ArchSiradigFec, "99/99/99 99:99")));
               AV22LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV22LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22LegNumero), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22LegNumero), "ZZZZZZZ9")));
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
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

   public byte executeStartEvent( )
   {
      pa2V2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2V2( ) ;
      }
      return gxajaxcallmode ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
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
      httpContext.AddJavascriptSource("UserControls/A3LUploadFileRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.subirarchivosiradig", new String[] {GXutil.URLEncode(GXutil.rtrim(AV10TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV15CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateTimeParm(AV20ArchSiradigFec)),GXutil.URLEncode(GXutil.ltrimstr(AV22LegNumero,8,0))}, new String[] {"TrnMode","CliCod","EmpCod","ArchSiradigFec","LegNumero"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV26Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22LegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARCHSIRADIGFEC", getSecureSignedToken( "", localUtil.format( AV20ArchSiradigFec, "99/99/99 99:99")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Archivo_siradig", AV7archivo_siradig);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Archivo_siradig", AV7archivo_siradig);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV10TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV15CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV16EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16EmpCod), "ZZZ9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV12CheckRequiredFieldsResult);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV26Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV22LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22LegNumero), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMESSAGES", AV9Messages);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMESSAGES", AV9Messages);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vARCHSIRADIGFEC", localUtil.ttoc( AV20ArchSiradigFec, 10, 8, 0, 0, "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARCHSIRADIGFEC", getSecureSignedToken( "", localUtil.format( AV20ArchSiradigFec, "99/99/99 99:99")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vARCHIVO_SIRADIG", AV7archivo_siradig);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vARCHIVO_SIRADIG", AV7archivo_siradig);
      }
      GXCCtlgxBlob = "ARCHIVO_SIRADIG_ARCHSIRADIGFILE" + "_gxBlob" ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile());
      web.GxWebStd.gx_hidden_field( httpContext, "A3LUPLOADFILE1_Caption", GXutil.rtrim( A3luploadfile1_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LUPLOADFILE1_Class", GXutil.rtrim( A3luploadfile1_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LUPLOADFILE1_Id_btn", GXutil.rtrim( A3luploadfile1_Id_btn));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LUPLOADFILE1_Idnombrearchivo", GXutil.rtrim( A3luploadfile1_Idnombrearchivo));
      web.GxWebStd.gx_hidden_field( httpContext, "A3LUPLOADFILE1_Id_file", GXutil.rtrim( A3luploadfile1_Id_file));
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

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we2V2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2V2( ) ;
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
      return formatLink("web.subirarchivosiradig", new String[] {GXutil.URLEncode(GXutil.rtrim(AV10TrnMode)),GXutil.URLEncode(GXutil.ltrimstr(AV15CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16EmpCod,4,0)),GXutil.URLEncode(GXutil.formatDateTimeParm(AV20ArchSiradigFec)),GXutil.URLEncode(GXutil.ltrimstr(AV22LegNumero,8,0))}, new String[] {"TrnMode","CliCod","EmpCod","ArchSiradigFec","LegNumero"})  ;
   }

   public String getPgmname( )
   {
      return "SubirArchivoSiradig" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Subir Archivo Siradig", "") ;
   }

   public void wb2V0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
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
         wb_table1_9_2V2( true) ;
      }
      else
      {
         wb_table1_9_2V2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_2V2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start2V2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Subir Archivo Siradig", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2V0( ) ;
   }

   public void ws2V2( )
   {
      start2V2( ) ;
      evt2V2( ) ;
   }

   public void evt2V2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
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
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e112V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e122V2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                                 /* Execute user event: Enter */
                                 e132V2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e142V2 ();
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
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
   }

   public void we2V2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa2V2( )
   {
      if ( nDonePA == 0 )
      {
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
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavArchivo_siradig_archsiradigfile_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2V2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV26Pgmname = "SubirArchivoSiradig" ;
      Gx_err = (short)(0) ;
   }

   public void rf2V2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e122V2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e142V2 ();
         wb2V0( ) ;
      }
   }

   public void send_integrity_lvl_hashes2V2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vTRNMODE", GXutil.rtrim( AV10TrnMode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10TrnMode, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV15CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV16EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV26Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV22LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22LegNumero), "ZZZZZZZ9")));
   }

   public void before_start_formulas( )
   {
      AV26Pgmname = "SubirArchivoSiradig" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2V0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e112V2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vARCHIVO_SIRADIG"), AV7archivo_siradig);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Archivo_siradig"), AV7archivo_siradig);
         /* Read saved values. */
         A3luploadfile1_Caption = httpContext.cgiGet( "A3LUPLOADFILE1_Caption") ;
         A3luploadfile1_Class = httpContext.cgiGet( "A3LUPLOADFILE1_Class") ;
         A3luploadfile1_Id_btn = httpContext.cgiGet( "A3LUPLOADFILE1_Id_btn") ;
         A3luploadfile1_Idnombrearchivo = httpContext.cgiGet( "A3LUPLOADFILE1_Idnombrearchivo") ;
         A3luploadfile1_Id_file = httpContext.cgiGet( "A3LUPLOADFILE1_Id_file") ;
         Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         /* Read variables values. */
         AV7archivo_siradig.setgxTv_Sdtarchivo_siradig_Archsiradigfile_SetBlob(httpContext.cgiGet( edtavArchivo_siradig_archsiradigfile_Internalname), httpContext.cgiGetFileName( edtavArchivo_siradig_archsiradigfile_Internalname), httpContext.cgiGetFileType( edtavArchivo_siradig_archsiradigfile_Internalname));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         if ( (GXutil.strcmp("", AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile())==0) )
         {
            GXCCtlgxBlob = "ARCHIVO_SIRADIG_ARCHSIRADIGFILE" + "_gxBlob" ;
            AV7archivo_siradig.setgxTv_Sdtarchivo_siradig_Archsiradigfile( httpContext.cgiGet( GXCCtlgxBlob) );
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e112V2 ();
      if (returnInSub) return;
   }

   public void e112V2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV21websession.remove(AV26Pgmname);
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      AV11LoadSuccess = true ;
      if ( ( ( GXutil.strcmp(AV10TrnMode, "DSP") == 0 ) ) || ( ( GXutil.strcmp(AV10TrnMode, "INS") == 0 ) && new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).executeUdp( "WWSubirArchivoSiradig_Insert") ) || ( ( GXutil.strcmp(AV10TrnMode, "UPD") == 0 ) && new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).executeUdp( "WWSubirArchivoSiradig_Update") ) || ( ( GXutil.strcmp(AV10TrnMode, "DLT") == 0 ) && new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).executeUdp( "WWSubirArchivoSiradig_Delete") ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         if ( GXutil.strcmp(AV10TrnMode, "INS") != 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV7archivo_siradig.Load(AV15CliCod, AV16EmpCod, AV20ArchSiradigFec);
            AV11LoadSuccess = AV7archivo_siradig.Success() ;
            if ( ! AV11LoadSuccess )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV9Messages = AV7archivo_siradig.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
            if ( ( GXutil.strcmp(AV10TrnMode, "DSP") == 0 ) || ( GXutil.strcmp(AV10TrnMode, "DLT") == 0 ) )
            {
               edtavArchivo_siradig_archsiradigfile_Enabled = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavArchivo_siradig_archsiradigfile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavArchivo_siradig_archsiradigfile_Enabled), 5, 0), true);
            }
         }
      }
      else
      {
         AV11LoadSuccess = false ;
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV11LoadSuccess )
      {
         if ( GXutil.strcmp(AV10TrnMode, "DLT") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "GXM_confdelete", ""));
         }
      }
      A3luploadfile1_Id_btn = httpContext.getMessage( "boton_subir", "") ;
      ucA3luploadfile1.sendProperty(context, "", false, A3luploadfile1_Internalname, "id_btn", A3luploadfile1_Id_btn);
      A3luploadfile1_Class = httpContext.getMessage( "Button", "") ;
      ucA3luploadfile1.sendProperty(context, "", false, A3luploadfile1_Internalname, "class", A3luploadfile1_Class);
      A3luploadfile1_Caption = httpContext.getMessage( "Seleccionar Archivo", "") ;
      ucA3luploadfile1.sendProperty(context, "", false, A3luploadfile1_Internalname, "caption", A3luploadfile1_Caption);
      A3luploadfile1_Id_file = edtavArchivo_siradig_archsiradigfile_Internalname ;
      ucA3luploadfile1.sendProperty(context, "", false, A3luploadfile1_Internalname, "id_file", A3luploadfile1_Id_file);
      A3luploadfile1_Idnombrearchivo = lblNombrearchivo_Internalname ;
      ucA3luploadfile1.sendProperty(context, "", false, A3luploadfile1_Internalname, "idNombreArchivo", A3luploadfile1_Idnombrearchivo);
   }

   public void e122V2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e132V2 ();
      if (returnInSub) return;
   }

   public void e132V2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV7archivo_siradig.setgxTv_Sdtarchivo_siradig_Clicod( AV15CliCod );
      AV7archivo_siradig.setgxTv_Sdtarchivo_siradig_Empcod( AV16EmpCod );
      if ( GXutil.strcmp(AV10TrnMode, "DSP") != 0 )
      {
         if ( GXutil.strcmp(AV10TrnMode, "DLT") != 0 )
         {
            /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
            S132 ();
            if (returnInSub) return;
         }
         if ( ( GXutil.strcmp(AV10TrnMode, "DLT") == 0 ) || AV12CheckRequiredFieldsResult )
         {
            if ( GXutil.strcmp(AV10TrnMode, "DLT") == 0 )
            {
               AV7archivo_siradig.Delete();
            }
            else
            {
               AV7archivo_siradig.Save();
            }
            if ( AV7archivo_siradig.Success() )
            {
               /* Execute user subroutine: 'AFTER_TRN' */
               S142 ();
               if (returnInSub) return;
            }
            else
            {
               AV9Messages = AV7archivo_siradig.GetMessages() ;
               /* Execute user subroutine: 'SHOW MESSAGES' */
               S112 ();
               if (returnInSub) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7archivo_siradig", AV7archivo_siradig);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV9Messages", AV9Messages);
   }

   public void S122( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV10TrnMode, "DSP") != 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'SHOW MESSAGES' Routine */
      returnInSub = false ;
      AV28GXV2 = 1 ;
      while ( AV28GXV2 <= AV9Messages.size() )
      {
         AV8Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV9Messages.elementAt(-1+AV28GXV2));
         httpContext.GX_msglist.addItem(AV8Message.getgxTv_SdtMessages_Message_Description());
         AV28GXV2 = (int)(AV28GXV2+1) ;
      }
   }

   public void S142( )
   {
      /* 'AFTER_TRN' Routine */
      returnInSub = false ;
      AV21websession.remove(AV26Pgmname);
      GXv_objcol_svchar1[0] = AV17errores ;
      GXv_int2[0] = AV18altas ;
      new web.procesouploadsiradig_v_1_18(remoteHandle, context).execute( AV15CliCod, AV16EmpCod, AV22LegNumero, AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfec(), GXv_objcol_svchar1, GXv_int2) ;
      AV17errores = GXv_objcol_svchar1[0] ;
      subirarchivosiradig_impl.this.AV18altas = GXv_int2[0] ;
      if ( AV17errores.size() == 0 )
      {
         if ( AV18altas == 0 )
         {
            AV21websession.setValue(GXutil.trim( AV26Pgmname), httpContext.getMessage( "No se dió de alta ningún registro", ""));
         }
         else
         {
            if ( AV18altas > 1 )
            {
               AV21websession.setValue(GXutil.trim( AV26Pgmname), httpContext.getMessage( "Se dieron de alta ", "")+GXutil.trim( GXutil.str( AV18altas, 4, 0))+httpContext.getMessage( " registros", ""));
            }
            else
            {
               AV21websession.setValue(GXutil.trim( AV26Pgmname), httpContext.getMessage( "Se dieron de alta ", "")+GXutil.trim( GXutil.str( AV18altas, 4, 0))+httpContext.getMessage( " registro", ""));
            }
         }
         Application.commitDataStores(context, remoteHandle, pr_default, "subirarchivosiradig");
         httpContext.setWebReturnParms(new Object[] {Integer.valueOf(AV22LegNumero)});
         httpContext.setWebReturnParmsMetadata(new Object[] {"AV22LegNumero"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         AV19e = (short)(1) ;
         while ( AV19e <= AV17errores.size() )
         {
            new web.alert(remoteHandle, context).execute( "error", (String)AV17errores.elementAt(-1+AV19e)) ;
            AV19e = (short)(AV19e+1) ;
         }
         GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
         AV7archivo_siradig.setgxTv_Sdtarchivo_siradig_Archsiradigfec( GXt_dtime3 );
      }
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV12CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12CheckRequiredFieldsResult", AV12CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile())==0) )
      {
         AV12CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12CheckRequiredFieldsResult", AV12CheckRequiredFieldsResult);
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe seleccionar Archivo", "")) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e142V2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_9_2V2( boolean wbgen )
   {
      if ( wbgen )
      {
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
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucA3luploadfile1.setProperty("caption", A3luploadfile1_Caption);
         ucA3luploadfile1.render(context, "a3luploadfile", A3luploadfile1_Internalname, "A3LUPLOADFILE1Container");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblNombrearchivo_Internalname, httpContext.getMessage( "Nombre Archivo", ""), "", "", lblNombrearchivo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_SubirArchivoSiradig.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavArchivo_siradig_archsiradigfile_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         ClassString = "Invi" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
         edtavArchivo_siradig_archsiradigfile_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavArchivo_siradig_archsiradigfile_Internalname, "Filetype", edtavArchivo_siradig_archsiradigfile_Filetype, true);
         if ( ! (GXutil.strcmp("", AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile())==0) )
         {
            gxblobfileaux.setSource( AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile() );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtavArchivo_siradig_archsiradigfile_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtavArchivo_siradig_archsiradigfile_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               AV7archivo_siradig.setgxTv_Sdtarchivo_siradig_Archsiradigfile( gxblobfileaux.getURI() );
               edtavArchivo_siradig_archsiradigfile_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop("", false, edtavArchivo_siradig_archsiradigfile_Internalname, "Filetype", edtavArchivo_siradig_archsiradigfile_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop("", false, edtavArchivo_siradig_archsiradigfile_Internalname, "URL", httpContext.getResourceRelative(AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile()), true);
         }
         web.GxWebStd.gx_blob_field( httpContext, edtavArchivo_siradig_archsiradigfile_Internalname, GXutil.rtrim( AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile()), httpContext.getResourceRelative(AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile()), ((GXutil.strcmp("", edtavArchivo_siradig_archsiradigfile_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtavArchivo_siradig_archsiradigfile_Filetype)==0) ? AV7archivo_siradig.getgxTv_Sdtarchivo_siradig_Archsiradigfile() : edtavArchivo_siradig_archsiradigfile_Filetype)) : edtavArchivo_siradig_archsiradigfile_Contenttype), false, "", edtavArchivo_siradig_archsiradigfile_Parameters, 0, edtavArchivo_siradig_archsiradigfile_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtavArchivo_siradig_archsiradigfile_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "", "", "HLP_SubirArchivoSiradig.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SubirArchivoSiradig.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SubirArchivoSiradig.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_2V2e( true) ;
      }
      else
      {
         wb_table1_9_2V2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10TrnMode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10TrnMode", AV10TrnMode);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10TrnMode, ""))));
      AV15CliCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15CliCod), "ZZZZZ9")));
      AV16EmpCod = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16EmpCod), "ZZZ9")));
      AV20ArchSiradigFec = (java.util.Date)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ArchSiradigFec", localUtil.ttoc( AV20ArchSiradigFec, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARCHSIRADIGFEC", getSecureSignedToken( "", localUtil.format( AV20ArchSiradigFec, "99/99/99 99:99")));
      AV22LegNumero = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22LegNumero), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV22LegNumero), "ZZZZZZZ9")));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa2V2( ) ;
      ws2V2( ) ;
      we2V2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024122020403593", true, true);
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
      httpContext.AddJavascriptSource("subirarchivosiradig.js", "?2024122020403593", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LUploadFileRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      A3luploadfile1_Internalname = "A3LUPLOADFILE1" ;
      lblNombrearchivo_Internalname = "NOMBREARCHIVO" ;
      edtavArchivo_siradig_archsiradigfile_Internalname = "ARCHIVO_SIRADIG_ARCHSIRADIGFILE" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      bttBtnenter_Visible = 1 ;
      edtavArchivo_siradig_archsiradigfile_Jsonclick = "" ;
      edtavArchivo_siradig_archsiradigfile_Parameters = "" ;
      edtavArchivo_siradig_archsiradigfile_Contenttype = "" ;
      edtavArchivo_siradig_archsiradigfile_Filetype = "" ;
      edtavArchivo_siradig_archsiradigfile_Enabled = 1 ;
      edtavArchivo_siradig_archsiradigfile_Enabled = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "Archivo", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      A3luploadfile1_Id_file = "" ;
      A3luploadfile1_Idnombrearchivo = "" ;
      A3luploadfile1_Id_btn = "" ;
      A3luploadfile1_Class = "" ;
      A3luploadfile1_Caption = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Subir Archivo Siradig", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV26Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20ArchSiradigFec',fld:'vARCHSIRADIGFEC',pic:'99/99/99 99:99',hsh:true},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNENTER',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e132V2',iparms:[{av:'AV15CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV7archivo_siradig',fld:'vARCHIVO_SIRADIG',pic:''},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV10TrnMode',fld:'vTRNMODE',pic:'',hsh:true},{av:'AV12CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV26Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV22LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'AV9Messages',fld:'vMESSAGES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7archivo_siradig',fld:'vARCHIVO_SIRADIG',pic:''},{av:'AV9Messages',fld:'vMESSAGES',pic:''},{av:'AV12CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV10TrnMode = "" ;
      wcpOAV20ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV10TrnMode = "" ;
      AV20ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV26Pgmname = "" ;
      GXKey = "" ;
      AV7archivo_siradig = new web.Sdtarchivo_siradig(remoteHandle);
      AV9Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXCCtlgxBlob = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV21websession = httpContext.getWebSession();
      Gx_mode = "" ;
      ucA3luploadfile1 = new com.genexus.webpanels.GXUserControl();
      AV8Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV17errores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar1 = new GXSimpleCollection[1] ;
      GXv_int2 = new short[1] ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblNombrearchivo_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.subirarchivosiradig__default(),
         new Object[] {
         }
      );
      AV26Pgmname = "SubirArchivoSiradig" ;
      /* GeneXus formulas. */
      AV26Pgmname = "SubirArchivoSiradig" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOAV16EmpCod ;
   private short AV16EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV18altas ;
   private short GXv_int2[] ;
   private short AV19e ;
   private int wcpOAV15CliCod ;
   private int wcpOAV22LegNumero ;
   private int AV15CliCod ;
   private int AV22LegNumero ;
   private int edtavArchivo_siradig_archsiradigfile_Enabled ;
   private int bttBtnenter_Visible ;
   private int AV28GXV2 ;
   private int idxLst ;
   private String wcpOAV10TrnMode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV10TrnMode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV26Pgmname ;
   private String GXKey ;
   private String GXCCtlgxBlob ;
   private String A3luploadfile1_Caption ;
   private String A3luploadfile1_Class ;
   private String A3luploadfile1_Id_btn ;
   private String A3luploadfile1_Idnombrearchivo ;
   private String A3luploadfile1_Id_file ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavArchivo_siradig_archsiradigfile_Internalname ;
   private String Gx_mode ;
   private String A3luploadfile1_Internalname ;
   private String lblNombrearchivo_Internalname ;
   private String bttBtnenter_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String lblNombrearchivo_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String edtavArchivo_siradig_archsiradigfile_Filetype ;
   private String edtavArchivo_siradig_archsiradigfile_Contenttype ;
   private String edtavArchivo_siradig_archsiradigfile_Parameters ;
   private String edtavArchivo_siradig_archsiradigfile_Jsonclick ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private java.util.Date wcpOAV20ArchSiradigFec ;
   private java.util.Date AV20ArchSiradigFec ;
   private java.util.Date GXt_dtime3 ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV12CheckRequiredFieldsResult ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV11LoadSuccess ;
   private boolean Cond_result ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucA3luploadfile1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private IDataStoreProvider pr_default ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV21websession ;
   private GXSimpleCollection<String> AV17errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar1[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV9Messages ;
   private com.genexus.SdtMessages_Message AV8Message ;
   private web.Sdtarchivo_siradig AV7archivo_siradig ;
}

final  class subirarchivosiradig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

