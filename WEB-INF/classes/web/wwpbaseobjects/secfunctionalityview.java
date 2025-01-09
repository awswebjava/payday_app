package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secfunctionalityview", "/web.wwpbaseobjects.secfunctionalityview"})
public final  class secfunctionalityview extends GXWebObjectStub
{
   public secfunctionalityview( )
   {
   }

   public secfunctionalityview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secfunctionalityview.class ));
   }

   public secfunctionalityview( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secfunctionalityview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secfunctionalityview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sec Functionality View";
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

