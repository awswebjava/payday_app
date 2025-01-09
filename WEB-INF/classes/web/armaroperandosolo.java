package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class armaroperandosolo extends GXProcedure
{
   public armaroperandosolo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( armaroperandosolo.class ), "" );
   }

   public armaroperandosolo( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.SdtSDTOperandosFormula> executeUdp( int aP0 ,
                                                                   String aP1 )
   {
      armaroperandosolo.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<web.SdtSDTOperandosFormula>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXBaseCollection<web.SdtSDTOperandosFormula>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXBaseCollection<web.SdtSDTOperandosFormula>[] aP2 )
   {
      armaroperandosolo.this.AV11CliCod = aP0;
      armaroperandosolo.this.AV9palabra = aP1;
      armaroperandosolo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8SDTOperandosFormula = (web.SdtSDTOperandosFormula)new web.SdtSDTOperandosFormula(remoteHandle, context);
      AV8SDTOperandosFormula.setgxTv_SdtSDTOperandosFormula_Operandooriginal( AV9palabra );
      AV10sdtOperandos.add(AV8SDTOperandosFormula, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = armaroperandosolo.this.AV10sdtOperandos;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10sdtOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      AV8SDTOperandosFormula = new web.SdtSDTOperandosFormula(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private String AV9palabra ;
   private GXBaseCollection<web.SdtSDTOperandosFormula>[] aP2 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV10sdtOperandos ;
   private web.SdtSDTOperandosFormula AV8SDTOperandosFormula ;
}

