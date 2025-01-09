package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliigg_sac extends GXProcedure
{
   public getapliigg_sac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliigg_sac.class ), "" );
   }

   public getapliigg_sac( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      getapliigg_sac.this.aP1 = new short[] {0};
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
      getapliigg_sac.this.AV9CliCod = aP0;
      getapliigg_sac.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV8totalmenteExentoAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg(remoteHandle, context).execute( AV9CliCod, (byte)(2), AV11TipoTope, DecimalUtil.doubleToDec(1), "", "", "", GXv_int2) ;
      getapliigg_sac.this.GXt_int1 = GXv_int2[0] ;
      AV8totalmenteExentoAplIIGG = GXt_int1 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getapliigg_sac.this.AV8totalmenteExentoAplIIGG;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11TipoTope ;
   private short AV8totalmenteExentoAplIIGG ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private short[] aP1 ;
}

