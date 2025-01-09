package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class svg_emp_masterpage extends GXProcedure
{
   public svg_emp_masterpage( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( svg_emp_masterpage.class ), "" );
   }

   public svg_emp_masterpage( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      svg_emp_masterpage.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      svg_emp_masterpage.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8svg = httpContext.getMessage( "<svg width=\"30\" height=\"30\" viewBox=\"0 0 30 30\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M2.8125 26.25H27.1875M4.6875 3.75V26.25M17.8125 3.75V26.25M25.3125 9.375V26.25M8.4375 8.4375H9.375M8.4375 12.1875H9.375M8.4375 15.9375H9.375M13.125 8.4375H14.0625M13.125 12.1875H14.0625M13.125 15.9375H14.0625M8.4375 26.25V22.0312C8.4375 21.2546 9.0671 20.625 9.84375 20.625H12.6562C13.4329 20.625 14.0625 21.2546 14.0625 22.0312V26.25M3.75 3.75H18.75M17.8125 9.375H26.25M21.5625 14.0625H21.5719V14.0719H21.5625V14.0625ZM21.5625 17.8125H21.5719V17.8219H21.5625V17.8125ZM21.5625 21.5625H21.5719V21.5719H21.5625V21.5625Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = svg_emp_masterpage.this.AV8svg;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8svg = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8svg ;
   private String[] aP0 ;
}

