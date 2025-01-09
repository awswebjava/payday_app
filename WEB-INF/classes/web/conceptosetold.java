package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptosetold extends GXProcedure
{
   public conceptosetold( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptosetold.class ), "" );
   }

   public conceptosetold( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( byte aP0 ,
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
                             String aP11 )
   {
      conceptosetold.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( byte aP0 ,
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
                        String aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( byte aP0 ,
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
                             String aP11 ,
                             String[] aP12 )
   {
      conceptosetold.this.AV11ConBaseLic = aP0;
      conceptosetold.this.AV20ConBaseLicProm = aP1;
      conceptosetold.this.AV12ConBaseFer = aP2;
      conceptosetold.this.AV13ConBaseFerProm = aP3;
      conceptosetold.this.AV14ConBaseHorExt = aP4;
      conceptosetold.this.AV15ConBaseHorExtProm = aP5;
      conceptosetold.this.AV19ConBasePres = aP6;
      conceptosetold.this.AV16ConBaseAnt = aP7;
      conceptosetold.this.AV17ConBaseOSDif = aP8;
      conceptosetold.this.AV23ConBaseAus = aP9;
      conceptosetold.this.AV22ConBaseAusProm = aP10;
      conceptosetold.this.AV18ConDescrip = aP11;
      conceptosetold.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&ConCodigo \"", "")+AV8ConCodigo+"\"") ;
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbaselic( AV11ConBaseLic );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbaselicprom( AV20ConBaseLicProm );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbasefer( AV12ConBaseFer );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbaseferprom( AV13ConBaseFerProm );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbasehorext( AV14ConBaseHorExt );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbasehorextprom( AV15ConBaseHorExtProm );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbasepres( AV19ConBasePres );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbaseant( AV16ConBaseAnt );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbaseosdif( AV17ConBaseOSDif );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Condescrip( GXutil.trim( AV18ConDescrip) );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbaseaus( AV23ConBaseAus );
      AV10concepto_old.setgxTv_Sdtconcepto_old_Conbaseausprom( AV22ConBaseAusProm );
      AV21ConOldValues = AV10concepto_old.toJSonString(false, true) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = conceptosetold.this.AV21ConOldValues;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21ConOldValues = "" ;
      AV26Pgmname = "" ;
      AV8ConCodigo = "" ;
      AV10concepto_old = new web.Sdtconcepto_old(remoteHandle, context);
      AV26Pgmname = "ConceptoSetOld" ;
      /* GeneXus formulas. */
      AV26Pgmname = "ConceptoSetOld" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11ConBaseLic ;
   private byte AV20ConBaseLicProm ;
   private byte AV12ConBaseFer ;
   private byte AV13ConBaseFerProm ;
   private byte AV14ConBaseHorExt ;
   private byte AV15ConBaseHorExtProm ;
   private byte AV19ConBasePres ;
   private byte AV16ConBaseAnt ;
   private byte AV17ConBaseOSDif ;
   private byte AV23ConBaseAus ;
   private byte AV22ConBaseAusProm ;
   private short Gx_err ;
   private String AV26Pgmname ;
   private String AV8ConCodigo ;
   private String AV21ConOldValues ;
   private String AV18ConDescrip ;
   private web.Sdtconcepto_old AV10concepto_old ;
   private String[] aP12 ;
}

