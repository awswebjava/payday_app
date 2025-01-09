package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legoperandogetvalores extends GXProcedure
{
   public legoperandogetvalores( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legoperandogetvalores.class ), "" );
   }

   public legoperandogetvalores( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      legoperandogetvalores.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      legoperandogetvalores.this.AV9OpeLegCodFormula = aP0;
      legoperandogetvalores.this.aP1 = aP1;
      legoperandogetvalores.this.aP2 = aP2;
      legoperandogetvalores.this.aP3 = aP3;
      legoperandogetvalores.this.aP4 = aP4;
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
         if ( AV8palabras.size() > 2 )
         {
            AV11valor2 = (String)AV8palabras.elementAt(-1+3) ;
            if ( AV8palabras.size() > 3 )
            {
               AV12valor3 = (String)AV8palabras.elementAt(-1+4) ;
               if ( AV8palabras.size() > 4 )
               {
                  AV13valor4 = (String)AV8palabras.elementAt(-1+5) ;
               }
            }
         }
      }
      GXv_char1[0] = AV10valor ;
      new web.replacefinal(remoteHandle, context).execute( GXv_char1) ;
      legoperandogetvalores.this.AV10valor = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = legoperandogetvalores.this.AV10valor;
      this.aP2[0] = legoperandogetvalores.this.AV11valor2;
      this.aP3[0] = legoperandogetvalores.this.AV12valor3;
      this.aP4[0] = legoperandogetvalores.this.AV13valor4;
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
      AV11valor2 = "" ;
      AV12valor3 = "" ;
      AV13valor4 = "" ;
      AV8palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9OpeLegCodFormula ;
   private String AV10valor ;
   private String AV11valor2 ;
   private String AV12valor3 ;
   private String AV13valor4 ;
   private String GXv_char1[] ;
   private String[] aP4 ;
   private String[] aP1 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private GXSimpleCollection<String> AV8palabras ;
}

