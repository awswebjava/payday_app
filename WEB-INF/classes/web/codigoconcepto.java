package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class codigoconcepto extends GXProcedure
{
   public codigoconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( codigoconcepto.class ), "" );
   }

   public codigoconcepto( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             boolean aP1 )
   {
      codigoconcepto.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        boolean aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             boolean aP1 ,
                             String[] aP2 )
   {
      codigoconcepto.this.AV9CliCod = aP0;
      codigoconcepto.this.AV11toUpper = aP1;
      codigoconcepto.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8concepto ;
      new web.codigoopeformula(remoteHandle, context).execute( AV9CliCod, "{concepto}", AV11toUpper, true, GXv_char1) ;
      codigoconcepto.this.AV8concepto = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = codigoconcepto.this.AV8concepto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8concepto = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8concepto ;
   private String GXv_char1[] ;
   private boolean AV11toUpper ;
   private String[] aP2 ;
}

