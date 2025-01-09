package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secfunctionality", "/web.wwpbaseobjects.secfunctionality"})
public final  class secfunctionality extends GXWebObjectStub
{
   public secfunctionality( )
   {
   }

   public secfunctionality( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secfunctionality.class ));
   }

   public secfunctionality( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secfunctionality_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secfunctionality_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Functionality";
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

