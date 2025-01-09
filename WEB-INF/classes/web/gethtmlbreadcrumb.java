package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethtmlbreadcrumb extends GXProcedure
{
   public gethtmlbreadcrumb( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethtmlbreadcrumb.class ), "" );
   }

   public gethtmlbreadcrumb( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      gethtmlbreadcrumb.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      gethtmlbreadcrumb.this.AV12MenuOpcCod = aP0;
      gethtmlbreadcrumb.this.aP1 = aP1;
      gethtmlbreadcrumb.this.aP2 = aP2;
      gethtmlbreadcrumb.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1[0] = AV9sdt_breadCrumb ;
      GXv_char2[0] = AV16primeroMenuOpcCod ;
      GXv_char3[0] = AV17headTitle ;
      new web.getbreadcrumb(remoteHandle, context).execute( AV12MenuOpcCod, (byte)(0), (byte)(0), 0, GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1, GXv_char2, GXv_char3) ;
      AV9sdt_breadCrumb = GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1[0] ;
      gethtmlbreadcrumb.this.AV16primeroMenuOpcCod = GXv_char2[0] ;
      gethtmlbreadcrumb.this.AV17headTitle = GXv_char3[0] ;
      if ( AV9sdt_breadCrumb.size() == 1 )
      {
         AV8html = httpContext.getMessage( "<span class=\"TextBlockTitleWWP ML5\" id=\"TEXTBLOCKTITLE\">", "") + GXutil.trim( GXutil.trim( ((web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)AV9sdt_breadCrumb.elementAt(-1+1)).getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo())) + httpContext.getMessage( "</span>", "") ;
      }
      else
      {
         AV8html = httpContext.getMessage( "<ul class=\"Breadcrumb\">", "") ;
         AV11b = (short)(0) ;
         AV20GXV1 = 1 ;
         while ( AV20GXV1 <= AV9sdt_breadCrumb.size() )
         {
            AV10itemBreadCrumb = (web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)((web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)AV9sdt_breadCrumb.elementAt(-1+AV20GXV1));
            AV11b = (short)(AV11b+1) ;
            AV8html += httpContext.getMessage( "<li>", "") ;
            if ( ! (GXutil.strcmp("", AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url())==0) )
            {
               AV8html += httpContext.getMessage( "<a href=\"", "") + GXutil.trim( AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url()) + "\">" ;
            }
            AV8html += GXutil.trim( AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo()) ;
            if ( ! (GXutil.strcmp("", AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url())==0) )
            {
               AV8html += httpContext.getMessage( "</a>", "") ;
            }
            AV8html += httpContext.getMessage( "</li>", "") ;
            AV20GXV1 = (int)(AV20GXV1+1) ;
         }
         AV8html += httpContext.getMessage( "</ul>", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gethtmlbreadcrumb.this.AV8html;
      this.aP2[0] = gethtmlbreadcrumb.this.AV16primeroMenuOpcCod;
      this.aP3[0] = gethtmlbreadcrumb.this.AV17headTitle;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8html = "" ;
      AV16primeroMenuOpcCod = "" ;
      AV17headTitle = "" ;
      AV9sdt_breadCrumb = new GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem>(web.Sdtsdt_breadCrumb_sdt_breadCrumbItem.class, "sdt_breadCrumbItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1 = new GXBaseCollection[1] ;
      GXv_char2 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV10itemBreadCrumb = new web.Sdtsdt_breadCrumb_sdt_breadCrumbItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11b ;
   private short Gx_err ;
   private int AV20GXV1 ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String AV8html ;
   private String AV12MenuOpcCod ;
   private String AV16primeroMenuOpcCod ;
   private String AV17headTitle ;
   private String[] aP3 ;
   private String[] aP1 ;
   private String[] aP2 ;
   private GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem> AV9sdt_breadCrumb ;
   private GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem> GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1[] ;
   private web.Sdtsdt_breadCrumb_sdt_breadCrumbItem AV10itemBreadCrumb ;
}

