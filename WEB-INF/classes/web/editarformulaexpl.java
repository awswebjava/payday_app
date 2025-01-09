package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.editarformulaexpl", "/web.editarformulaexpl"})
public final  class editarformulaexpl extends GXWebObjectStub
{
   public editarformulaexpl( )
   {
   }

   public editarformulaexpl( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( editarformulaexpl.class ));
   }

   public editarformulaexpl( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new editarformulaexpl_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new editarformulaexpl_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Editar explicación de fórmula";
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

