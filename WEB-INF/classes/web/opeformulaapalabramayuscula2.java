package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class opeformulaapalabramayuscula2 extends GXProcedure
{
   public opeformulaapalabramayuscula2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( opeformulaapalabramayuscula2.class ), "" );
   }

   public opeformulaapalabramayuscula2( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 ,
                              String[] aP2 )
   {
      opeformulaapalabramayuscula2.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             boolean[] aP3 )
   {
      opeformulaapalabramayuscula2.this.AV9OperandoOriginal = aP0;
      opeformulaapalabramayuscula2.this.aP1 = aP1;
      opeformulaapalabramayuscula2.this.aP2 = aP2;
      opeformulaapalabramayuscula2.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Operando = GXutil.upper( GXutil.trim( AV9OperandoOriginal)) ;
      GXv_char1[0] = AV8Operando ;
      new web.removercorchetes(remoteHandle, context).execute( GXv_char1) ;
      opeformulaapalabramayuscula2.this.AV8Operando = GXv_char1[0] ;
      AV10palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV8Operando," ")) ;
      if ( AV10palabras.size() > 0 )
      {
         AV11primeraPalabra = GXutil.trim( (String)AV10palabras.elementAt(-1+1)) ;
         if ( AV10palabras.size() == 1 )
         {
            AV12palabraUnica = true ;
         }
      }
      else
      {
         AV11primeraPalabra = GXutil.trim( AV8Operando) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = opeformulaapalabramayuscula2.this.AV8Operando;
      this.aP2[0] = opeformulaapalabramayuscula2.this.AV11primeraPalabra;
      this.aP3[0] = opeformulaapalabramayuscula2.this.AV12palabraUnica;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Operando = "" ;
      AV11primeraPalabra = "" ;
      GXv_char1 = new String[1] ;
      AV10palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV11primeraPalabra ;
   private String GXv_char1[] ;
   private boolean AV12palabraUnica ;
   private String AV9OperandoOriginal ;
   private String AV8Operando ;
   private boolean[] aP3 ;
   private String[] aP1 ;
   private String[] aP2 ;
   private GXSimpleCollection<String> AV10palabras ;
}

