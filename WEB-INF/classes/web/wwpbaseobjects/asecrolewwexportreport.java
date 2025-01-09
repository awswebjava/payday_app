package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.asecrolewwexportreport", "/web.wwpbaseobjects.asecrolewwexportreport"})
public final  class asecrolewwexportreport extends GXWebObjectStub
{
   public asecrolewwexportreport( )
   {
   }

   public asecrolewwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( asecrolewwexportreport.class ));
   }

   public asecrolewwexportreport( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new asecrolewwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new asecrolewwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec Role WWExport Report";
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

}

