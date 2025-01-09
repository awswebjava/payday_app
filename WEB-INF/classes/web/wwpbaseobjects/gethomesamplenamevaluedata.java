package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.gethomesamplenamevaluedata", "/web.wwpbaseobjects.gethomesamplenamevaluedata"})
public final  class gethomesamplenamevaluedata extends GXWebObjectStub
{
   public gethomesamplenamevaluedata( )
   {
   }

   public gethomesamplenamevaluedata( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gethomesamplenamevaluedata.class ));
   }

   public gethomesamplenamevaluedata( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gethomesamplenamevaluedata_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gethomesamplenamevaluedata_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Get Home Sample Name Value Data";
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

