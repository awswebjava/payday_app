package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelvenromes extends GXProcedure
{
   public devuelvenromes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelvenromes.class ), "" );
   }

   public devuelvenromes( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( String aP0 )
   {
      devuelvenromes.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             byte[] aP1 )
   {
      devuelvenromes.this.AV8mesNombre = aP0;
      devuelvenromes.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3), 1, 3)), httpContext.getMessage( "ENE", "")) == 0 )
      {
         AV9mesNro = (byte)(1) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "FEB", "")) == 0 )
      {
         AV9mesNro = (byte)(2) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "MAR", "")) == 0 )
      {
         AV9mesNro = (byte)(3) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "ABR", "")) == 0 )
      {
         AV9mesNro = (byte)(4) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "MAY", "")) == 0 )
      {
         AV9mesNro = (byte)(5) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "JUN", "")) == 0 )
      {
         AV9mesNro = (byte)(6) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "JUL", "")) == 0 )
      {
         AV9mesNro = (byte)(7) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "AGO", "")) == 0 )
      {
         AV9mesNro = (byte)(8) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "SEP", "")) == 0 )
      {
         AV9mesNro = (byte)(9) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "OCT", "")) == 0 )
      {
         AV9mesNro = (byte)(10) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "NOV", "")) == 0 )
      {
         AV9mesNro = (byte)(11) ;
      }
      else if ( GXutil.strcmp(GXutil.trim( GXutil.substring( GXutil.upper( AV8mesNombre), 1, 3)), httpContext.getMessage( "DIC", "")) == 0 )
      {
         AV9mesNro = (byte)(12) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = devuelvenromes.this.AV9mesNro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9mesNro ;
   private short Gx_err ;
   private String AV8mesNombre ;
   private byte[] aP1 ;
}

