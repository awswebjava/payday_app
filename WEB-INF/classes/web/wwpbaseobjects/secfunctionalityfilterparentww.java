package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secfunctionalityfilterparentww", "/web.wwpbaseobjects.secfunctionalityfilterparentww"})
public final  class secfunctionalityfilterparentww extends GXWebObjectStub
{
   public secfunctionalityfilterparentww( )
   {
   }

   public secfunctionalityfilterparentww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secfunctionalityfilterparentww.class ));
   }

   public secfunctionalityfilterparentww( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secfunctionalityfilterparentww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secfunctionalityfilterparentww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Functionality";
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

