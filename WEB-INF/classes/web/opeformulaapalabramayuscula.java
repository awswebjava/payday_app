package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class opeformulaapalabramayuscula extends GXProcedure
{
   public opeformulaapalabramayuscula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( opeformulaapalabramayuscula.class ), "" );
   }

   public opeformulaapalabramayuscula( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String[] aP1 )
   {
      opeformulaapalabramayuscula.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      opeformulaapalabramayuscula.this.AV9OperandoOriginal = aP0;
      opeformulaapalabramayuscula.this.aP1 = aP1;
      opeformulaapalabramayuscula.this.aP2 = aP2;
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
      opeformulaapalabramayuscula.this.AV8Operando = GXv_char1[0] ;
      AV10palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV8Operando," ")) ;
      if ( AV10palabras.size() > 0 )
      {
         AV11primeraPalabra = GXutil.trim( (String)AV10palabras.elementAt(-1+1)) ;
      }
      else
      {
         AV11primeraPalabra = GXutil.trim( AV8Operando) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = opeformulaapalabramayuscula.this.AV8Operando;
      this.aP2[0] = opeformulaapalabramayuscula.this.AV11primeraPalabra;
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
   private String AV9OperandoOriginal ;
   private String AV8Operando ;
   private String[] aP2 ;
   private String[] aP1 ;
   private GXSimpleCollection<String> AV10palabras ;
}

