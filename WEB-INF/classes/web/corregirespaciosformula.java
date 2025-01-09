package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class corregirespaciosformula extends GXProcedure
{
   public corregirespaciosformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( corregirespaciosformula.class ), "" );
   }

   public corregirespaciosformula( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      corregirespaciosformula.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      corregirespaciosformula.this.AV9CliCod = aP0;
      corregirespaciosformula.this.AV8ConFormula = aP1[0];
      this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV8ConFormula ;
      new web.wwpbaseobjects.removerespaciosdobles(remoteHandle, context).execute( GXv_char1) ;
      corregirespaciosformula.this.AV8ConFormula = GXv_char1[0] ;
      GXv_char1[0] = AV8ConFormula ;
      new web.wwpbaseobjects.removerespacioscorchetes(remoteHandle, context).execute( GXv_char1) ;
      corregirespaciosformula.this.AV8ConFormula = GXv_char1[0] ;
      GXv_char1[0] = AV10SiPalabra ;
      new web.palabraformulaif(remoteHandle, context).execute( AV9CliCod, GXv_char1) ;
      corregirespaciosformula.this.AV10SiPalabra = GXv_char1[0] ;
      AV8ConFormula = GXutil.strReplace( AV8ConFormula, GXutil.trim( AV10SiPalabra)+" (", GXutil.trim( AV10SiPalabra)+"(") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = corregirespaciosformula.this.AV8ConFormula;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10SiPalabra = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV10SiPalabra ;
   private String GXv_char1[] ;
   private String AV8ConFormula ;
   private String[] aP1 ;
}

