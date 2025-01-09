package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sacarpuntosycomas extends GXProcedure
{
   public sacarpuntosycomas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sacarpuntosycomas.class ), "" );
   }

   public sacarpuntosycomas( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( java.math.BigDecimal aP0 )
   {
      sacarpuntosycomas.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             String[] aP1 )
   {
      sacarpuntosycomas.this.AV9Importes = aP0;
      sacarpuntosycomas.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ImporteSTR = GXutil.trim( GXutil.str( AV9Importes, 14, 2)) ;
      AV8ImporteSTR = GXutil.strReplace( AV8ImporteSTR, ",", "") ;
      AV8ImporteSTR = GXutil.strReplace( AV8ImporteSTR, ".", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = sacarpuntosycomas.this.AV8ImporteSTR;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ImporteSTR = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.math.BigDecimal AV9Importes ;
   private String AV8ImporteSTR ;
   private String[] aP1 ;
}

