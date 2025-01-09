package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legoperandogetvalor extends GXProcedure
{
   public legoperandogetvalor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legoperandogetvalor.class ), "" );
   }

   public legoperandogetvalor( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      legoperandogetvalor.this.aP1 = new String[] {""};
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
      legoperandogetvalor.this.AV9OpeLegCodFormula = aP0;
      legoperandogetvalor.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10valor = "" ;
      AV8palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV9OpeLegCodFormula," ")) ;
      if ( AV8palabras.size() > 1 )
      {
         AV10valor = (String)AV8palabras.elementAt(-1+2) ;
      }
      GXv_char1[0] = AV10valor ;
      new web.replacefinal(remoteHandle, context).execute( GXv_char1) ;
      legoperandogetvalor.this.AV10valor = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = legoperandogetvalor.this.AV10valor;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10valor = "" ;
      AV8palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9OpeLegCodFormula ;
   private String AV10valor ;
   private String GXv_char1[] ;
   private String[] aP1 ;
   private GXSimpleCollection<String> AV8palabras ;
}

