package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class agregarguionescuil extends GXProcedure
{
   public agregarguionescuil( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( agregarguionescuil.class ), "" );
   }

   public agregarguionescuil( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      agregarguionescuil.this.aP1 = new String[] {""};
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
      agregarguionescuil.this.AV10LegCUILChar = aP0;
      agregarguionescuil.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8CuilGuiones = GXutil.substring( AV10LegCUILChar, 1, 2) + "-" + GXutil.substring( AV10LegCUILChar, 3, 8) + "-" + GXutil.substring( AV10LegCUILChar, 11, 1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = agregarguionescuil.this.AV8CuilGuiones;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CuilGuiones = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10LegCUILChar ;
   private String AV8CuilGuiones ;
   private String[] aP1 ;
}

