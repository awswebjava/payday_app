package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class parsearerrorprincipal extends GXProcedure
{
   public parsearerrorprincipal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parsearerrorprincipal.class ), "" );
   }

   public parsearerrorprincipal( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      parsearerrorprincipal.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      parsearerrorprincipal.this.AV8error = aP0[0];
      this.aP0 = aP0;
      parsearerrorprincipal.this.AV9principalError = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV10error_palabra ;
      new web.getcoderrprin(remoteHandle, context).execute( GXv_char1) ;
      parsearerrorprincipal.this.AV10error_palabra = GXv_char1[0] ;
      if ( GXutil.strSearch( AV8error, AV10error_palabra, 1) != 0 )
      {
         AV8error = GXutil.strReplace( AV8error, AV10error_palabra, "") ;
         if ( GXutil.strSearch( AV9principalError, AV8error, 1) == 0 )
         {
            if ( ! (GXutil.strcmp("", AV9principalError)==0) )
            {
               AV9principalError += httpContext.getMessage( ". <BR>", "") ;
            }
            AV9principalError += GXutil.trim( AV8error) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = parsearerrorprincipal.this.AV8error;
      this.aP1[0] = parsearerrorprincipal.this.AV9principalError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10error_palabra = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10error_palabra ;
   private String GXv_char1[] ;
   private String AV8error ;
   private String AV9principalError ;
   private String[] aP1 ;
   private String[] aP0 ;
}

