package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class determinaesbasicoporafip extends GXProcedure
{
   public determinaesbasicoporafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( determinaesbasicoporafip.class ), "" );
   }

   public determinaesbasicoporafip( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( String aP0 ,
                           byte aP1 ,
                           byte aP2 ,
                           byte aP3 ,
                           byte aP4 ,
                           byte aP5 ,
                           byte aP6 ,
                           byte aP7 ,
                           byte aP8 ,
                           byte aP9 ,
                           byte aP10 ,
                           byte aP11 ,
                           byte aP12 ,
                           byte aP13 ,
                           byte aP14 ,
                           byte aP15 )
   {
      determinaesbasicoporafip.this.aP16 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( String aP0 ,
                        byte aP1 ,
                        byte aP2 ,
                        byte aP3 ,
                        byte aP4 ,
                        byte aP5 ,
                        byte aP6 ,
                        byte aP7 ,
                        byte aP8 ,
                        byte aP9 ,
                        byte aP10 ,
                        byte aP11 ,
                        byte aP12 ,
                        byte aP13 ,
                        byte aP14 ,
                        byte aP15 ,
                        byte[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( String aP0 ,
                             byte aP1 ,
                             byte aP2 ,
                             byte aP3 ,
                             byte aP4 ,
                             byte aP5 ,
                             byte aP6 ,
                             byte aP7 ,
                             byte aP8 ,
                             byte aP9 ,
                             byte aP10 ,
                             byte aP11 ,
                             byte aP12 ,
                             byte aP13 ,
                             byte aP14 ,
                             byte aP15 ,
                             byte[] aP16 )
   {
      determinaesbasicoporafip.this.AV8TipoConCod = aP0;
      determinaesbasicoporafip.this.AV23ConSIPAApo = aP1;
      determinaesbasicoporafip.this.AV24ConSIPACont = aP2;
      determinaesbasicoporafip.this.AV13ConINSSJyPApo = aP3;
      determinaesbasicoporafip.this.AV14ConINSSJyPCont = aP4;
      determinaesbasicoporafip.this.AV17ConObraSocApo = aP5;
      determinaesbasicoporafip.this.AV18ConObraSocCont = aP6;
      determinaesbasicoporafip.this.AV11ConFonSolRedApo = aP7;
      determinaesbasicoporafip.this.AV12ConFonSolRedCont = aP8;
      determinaesbasicoporafip.this.AV21ConRenateaApo = aP9;
      determinaesbasicoporafip.this.AV22ConRenateaCont = aP10;
      determinaesbasicoporafip.this.AV9ConAsigFamCont = aP11;
      determinaesbasicoporafip.this.AV10ConFonNacEmpCont = aP12;
      determinaesbasicoporafip.this.AV15ConLeyRieTrabCont = aP13;
      determinaesbasicoporafip.this.AV19ConRegDifApo = aP14;
      determinaesbasicoporafip.this.AV20ConRegEspApo = aP15;
      determinaesbasicoporafip.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16ConLiqBasica = (byte)(1) ;
      if ( GXutil.strcmp(AV8TipoConCod, "NRE_ARG") == 0 )
      {
         if ( ( AV23ConSIPAApo == 1 ) || ( AV24ConSIPACont == 1 ) || ( AV13ConINSSJyPApo == 1 ) || ( AV14ConINSSJyPCont == 1 ) || ( AV17ConObraSocApo == 1 ) || ( AV18ConObraSocCont == 1 ) || ( AV11ConFonSolRedApo == 1 ) || ( AV12ConFonSolRedCont == 1 ) || ( AV21ConRenateaApo == 1 ) || ( AV22ConRenateaCont == 1 ) || ( AV9ConAsigFamCont == 1 ) || ( AV10ConFonNacEmpCont == 1 ) || ( AV15ConLeyRieTrabCont == 1 ) || ( AV19ConRegDifApo == 1 ) || ( AV20ConRegEspApo == 1 ) )
         {
            AV16ConLiqBasica = (byte)(0) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP16[0] = determinaesbasicoporafip.this.AV16ConLiqBasica;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV23ConSIPAApo ;
   private byte AV24ConSIPACont ;
   private byte AV13ConINSSJyPApo ;
   private byte AV14ConINSSJyPCont ;
   private byte AV17ConObraSocApo ;
   private byte AV18ConObraSocCont ;
   private byte AV11ConFonSolRedApo ;
   private byte AV12ConFonSolRedCont ;
   private byte AV21ConRenateaApo ;
   private byte AV22ConRenateaCont ;
   private byte AV9ConAsigFamCont ;
   private byte AV10ConFonNacEmpCont ;
   private byte AV15ConLeyRieTrabCont ;
   private byte AV19ConRegDifApo ;
   private byte AV20ConRegEspApo ;
   private byte AV16ConLiqBasica ;
   private short Gx_err ;
   private String AV8TipoConCod ;
   private byte[] aP16 ;
}

