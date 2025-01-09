package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.workwithplusmasterpageprompt", "/web.wwpbaseobjects.workwithplusmasterpageprompt"})
public final  class workwithplusmasterpageprompt extends GXWebObjectStub
{
   public workwithplusmasterpageprompt( )
   {
   }

   public workwithplusmasterpageprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( workwithplusmasterpageprompt.class ));
   }

   public workwithplusmasterpageprompt( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new workwithplusmasterpageprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new workwithplusmasterpageprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Work With Plus Master Page Prompt";
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

