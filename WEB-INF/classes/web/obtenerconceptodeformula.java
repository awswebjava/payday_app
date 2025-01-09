package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtenerconceptodeformula extends GXProcedure
{
   public obtenerconceptodeformula( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtenerconceptodeformula.class ), "" );
   }

   public obtenerconceptodeformula( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      obtenerconceptodeformula.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      obtenerconceptodeformula.this.AV8CliCod = aP0;
      obtenerconceptodeformula.this.AV13ConCodigo = aP1;
      obtenerconceptodeformula.this.AV11varchar = aP2;
      obtenerconceptodeformula.this.AV12idOperando = aP3;
      obtenerconceptodeformula.this.aP4 = aP4;
      obtenerconceptodeformula.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19ConOpeId = GXutil.trim( AV12idOperando) ;
      GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem1[0] = AV16cal_par_valores ;
      GXv_char2[0] = AV14error ;
      new web.devuelveparametrosgrabados(remoteHandle, context).execute( AV8CliCod, AV13ConCodigo, AV19ConOpeId, AV11varchar, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem1, GXv_char2) ;
      AV16cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem1[0] ;
      obtenerconceptodeformula.this.AV14error = GXv_char2[0] ;
      if ( (GXutil.strcmp("", AV14error)==0) )
      {
         AV22GXV1 = 1 ;
         while ( AV22GXV1 <= AV16cal_par_valores.size() )
         {
            AV17item = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV16cal_par_valores.elementAt(-1+AV22GXV1));
            if ( GXutil.strcmp(AV17item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid(), "Concepto") == 0 )
            {
               AV18ConCeptoPar = AV17item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value() ;
            }
            AV22GXV1 = (int)(AV22GXV1+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = obtenerconceptodeformula.this.AV18ConCeptoPar;
      this.aP5[0] = obtenerconceptodeformula.this.AV14error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18ConCeptoPar = "" ;
      AV14error = "" ;
      AV19ConOpeId = "" ;
      AV16cal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem1 = new GXBaseCollection[1] ;
      GXv_char2 = new String[1] ;
      AV17item = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV22GXV1 ;
   private String AV13ConCodigo ;
   private String AV12idOperando ;
   private String AV18ConCeptoPar ;
   private String AV19ConOpeId ;
   private String GXv_char2[] ;
   private String AV11varchar ;
   private String AV14error ;
   private String[] aP5 ;
   private String[] aP4 ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV16cal_par_valores ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem1[] ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV17item ;
}

