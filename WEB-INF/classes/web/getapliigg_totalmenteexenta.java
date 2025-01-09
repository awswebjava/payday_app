package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliigg_totalmenteexenta extends GXProcedure
{
   public getapliigg_totalmenteexenta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliigg_totalmenteexenta.class ), "" );
   }

   public getapliigg_totalmenteexenta( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      getapliigg_totalmenteexenta.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      getapliigg_totalmenteexenta.this.AV9CliCod = aP0;
      getapliigg_totalmenteexenta.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&totalmenteExentoAplIIGG ", "")+GXutil.trim( GXutil.str( AV8totalmenteExentoAplIIGG, 4, 0))+httpContext.getMessage( " &clicod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))) ;
      GXt_int1 = AV8totalmenteExentoAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg(remoteHandle, context).execute( AV9CliCod, AV10AplIIGGTrat, AV11TipoTope, DecimalUtil.doubleToDec(1), "", "", "", GXv_int2) ;
      getapliigg_totalmenteexenta.this.GXt_int1 = GXv_int2[0] ;
      AV8totalmenteExentoAplIIGG = GXt_int1 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getapliigg_totalmenteexenta.this.AV8totalmenteExentoAplIIGG;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Pgmname = "" ;
      GXv_int2 = new short[1] ;
      AV14Pgmname = "getAplIIGG_TotalmenteExenta" ;
      /* GeneXus formulas. */
      AV14Pgmname = "getAplIIGG_TotalmenteExenta" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10AplIIGGTrat ;
   private byte AV11TipoTope ;
   private short AV8totalmenteExentoAplIIGG ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private String AV14Pgmname ;
   private short[] aP1 ;
}

