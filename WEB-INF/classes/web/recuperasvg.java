package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class recuperasvg extends GXProcedure
{
   public recuperasvg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recuperasvg.class ), "" );
   }

   public recuperasvg( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      recuperasvg.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      recuperasvg.this.AV8que = aP0;
      recuperasvg.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV8que, httpContext.getMessage( "ver", "")) == 0 )
      {
         AV9svg = httpContext.getMessage( "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"19\" height=\"15\" viewBox=\"0 0 19 15\" fill=\"none\"><path d=\"M12.2777 7.27027C12.2777 7.98297 11.9935 8.66649 11.4876 9.17045C10.9817 9.67441 10.2955 9.95753 9.58012 9.95753C8.86468 9.95753 8.17855 9.67441 7.67266 9.17045C7.16677 8.66649 6.88257 7.98297 6.88257 7.27027C6.88257 6.55756 7.16677 5.87405 7.67266 5.37009C8.17855 4.86613 8.86468 4.58301 9.58012 4.58301C10.2955 4.58301 10.9817 4.86613 11.4876 5.37009C11.9935 5.87405 12.2777 6.55756 12.2777 7.27027Z\" stroke=\"var(--colors_grayAction)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M1 7.27027C2.14556 3.6362 5.55436 1 9.58 1C13.6065 1 17.0144 3.6362 18.16 7.27027C17.0144 10.9043 13.6065 13.5405 9.58 13.5405C5.55436 13.5405 2.14556 10.9043 1 7.27027Z\" stroke=\"var(--colors_grayAction)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      }
      else if ( GXutil.strcmp(AV8que, httpContext.getMessage( "modificar", "")) == 0 )
      {
         AV9svg = httpContext.getMessage( "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"17\" viewBox=\"0 0 16 17\" fill=\"none\"><path d=\"M7.72137 3.18457C8.04653 5.27138 9.74011 6.86674 11.8421 7.07844\" stroke=\"var(--colors_grayAction)\" stroke-width=\"1.7\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M8.75777 2.08808L2.55027 8.65853C2.31588 8.90804 2.08906 9.39953 2.04369 9.73977L1.76394 12.1895C1.66564 13.0741 2.30076 13.6789 3.17783 13.5278L5.61244 13.1119C5.95268 13.0515 6.42902 12.8019 6.6634 12.5448L12.871 5.97439C13.9446 4.84025 14.4285 3.54734 12.7575 1.9671C11.0941 0.401992 9.83148 0.953945 8.75777 2.08808Z\" stroke=\"var(--colors_grayAction)\" stroke-width=\"1.7\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M1 16H14.6096\" stroke=\"var(--colors_grayAction)\" stroke-width=\"1.7\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      }
      else if ( GXutil.strcmp(AV8que, httpContext.getMessage( "eliminar", "")) == 0 )
      {
         AV9svg = httpContext.getMessage( "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"18\" viewBox=\"0 0 16 18\" fill=\"none\"><path d=\"M14.1813 4.50159L13.4194 15.1307C13.3878 15.5724 13.1894 15.9858 12.8641 16.2876C12.5388 16.5894 12.1108 16.7572 11.6663 16.7572H4.39373C3.94921 16.7572 3.52119 16.5894 3.1959 16.2876C2.8706 15.9858 2.67219 15.5724 2.64063 15.1307L1.87875 4.50159M6.2725 8.00319V13.2556M9.7875 8.00319V13.2556M10.6663 4.50159V1.8754C10.6663 1.64323 10.5737 1.42057 10.4089 1.2564C10.2441 1.09223 10.0206 1 9.7875 1H6.2725C6.03944 1 5.81593 1.09223 5.65113 1.2564C5.48633 1.42057 5.39375 1.64323 5.39375 1.8754V4.50159M1 4.50159H15.06\" stroke=\"var(--colors_grayActionDelete)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = recuperasvg.this.AV9svg;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9svg = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8que ;
   private String AV9svg ;
   private String[] aP1 ;
}

