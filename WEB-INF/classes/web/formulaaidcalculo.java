package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formulaaidcalculo extends GXProcedure
{
   public formulaaidcalculo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formulaaidcalculo.class ), "" );
   }

   public formulaaidcalculo( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              String[] aP3 )
   {
      formulaaidcalculo.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      formulaaidcalculo.this.AV14CliCod = aP0;
      formulaaidcalculo.this.AV8ConFormula = aP1;
      formulaaidcalculo.this.aP2 = aP2;
      formulaaidcalculo.this.aP3 = aP3;
      formulaaidcalculo.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9Operando ;
      GXv_char2[0] = AV11primeraPalabra ;
      GXv_boolean3[0] = AV10palabraUnica ;
      new web.opeformulaapalabramayuscula2(remoteHandle, context).execute( AV8ConFormula, GXv_char1, GXv_char2, GXv_boolean3) ;
      formulaaidcalculo.this.AV9Operando = GXv_char1[0] ;
      formulaaidcalculo.this.AV11primeraPalabra = GXv_char2[0] ;
      formulaaidcalculo.this.AV10palabraUnica = GXv_boolean3[0] ;
      GXv_char2[0] = AV12idOperando ;
      GXv_char1[0] = "" ;
      GXv_char4[0] = "" ;
      GXv_boolean3[0] = false ;
      GXv_boolean5[0] = false ;
      new web.codigoopeformulaiddescyfor(remoteHandle, context).execute( AV14CliCod, AV11primeraPalabra, GXv_char2, GXv_char1, GXv_char4, GXv_boolean3, GXv_boolean5) ;
      formulaaidcalculo.this.AV12idOperando = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV12idOperando)==0) && ( AV10palabraUnica ) )
      {
         AV13resolverDeUna = true ;
      }
      else
      {
         AV13resolverDeUna = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = formulaaidcalculo.this.AV12idOperando;
      this.aP3[0] = formulaaidcalculo.this.AV11primeraPalabra;
      this.aP4[0] = formulaaidcalculo.this.AV13resolverDeUna;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12idOperando = "" ;
      AV11primeraPalabra = "" ;
      AV9Operando = "" ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14CliCod ;
   private String AV12idOperando ;
   private String AV11primeraPalabra ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private String GXv_char4[] ;
   private boolean AV13resolverDeUna ;
   private boolean AV10palabraUnica ;
   private boolean GXv_boolean3[] ;
   private boolean GXv_boolean5[] ;
   private String AV8ConFormula ;
   private String AV9Operando ;
   private boolean[] aP4 ;
   private String[] aP2 ;
   private String[] aP3 ;
}

