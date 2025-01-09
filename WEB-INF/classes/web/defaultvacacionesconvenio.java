package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultvacacionesconvenio extends GXProcedure
{
   public defaultvacacionesconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultvacacionesconvenio.class ), "" );
   }

   public defaultvacacionesconvenio( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> executeUdp( short[] aP0 ,
                                                                                           byte[] aP1 ,
                                                                                           byte[] aP2 )
   {
      defaultvacacionesconvenio.this.aP3 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short[] aP0 ,
                        byte[] aP1 ,
                        byte[] aP2 ,
                        GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short[] aP0 ,
                             byte[] aP1 ,
                             byte[] aP2 ,
                             GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>[] aP3 )
   {
      defaultvacacionesconvenio.this.aP0 = aP0;
      defaultvacacionesconvenio.this.aP1 = aP1;
      defaultvacacionesconvenio.this.aP2 = aP2;
      defaultvacacionesconvenio.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ConveInterDiasJor = (short)(20) ;
      AV12ConveMinMesesVac = (byte)(6) ;
      AV14item = (web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)new web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem(remoteHandle, context);
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti( (byte)(0) );
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti( (byte)(5) );
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias( (byte)(14) );
      AV13sdt_conveVacaciones.add(AV14item, 0);
      AV14item = (web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)new web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem(remoteHandle, context);
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti( (byte)(6) );
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti( (byte)(9) );
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias( (byte)(21) );
      AV13sdt_conveVacaciones.add(AV14item, 0);
      AV14item = (web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)new web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem(remoteHandle, context);
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti( (byte)(10) );
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti( (byte)(19) );
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias( (byte)(28) );
      AV13sdt_conveVacaciones.add(AV14item, 0);
      AV14item = (web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)new web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem(remoteHandle, context);
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti( (byte)(20) );
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti( (byte)(99) );
      AV14item.setgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias( (byte)(35) );
      AV13sdt_conveVacaciones.add(AV14item, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = defaultvacacionesconvenio.this.AV9ConveInterDiasJor;
      this.aP1[0] = defaultvacacionesconvenio.this.AV10ConveDiasAcuVac;
      this.aP2[0] = defaultvacacionesconvenio.this.AV12ConveMinMesesVac;
      this.aP3[0] = defaultvacacionesconvenio.this.AV13sdt_conveVacaciones;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13sdt_conveVacaciones = new GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>(web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem.class, "sdt_conveVacacionesItem", "PayDay", remoteHandle);
      AV14item = new web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10ConveDiasAcuVac ;
   private byte AV12ConveMinMesesVac ;
   private short AV9ConveInterDiasJor ;
   private short Gx_err ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>[] aP3 ;
   private short[] aP0 ;
   private byte[] aP1 ;
   private byte[] aP2 ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> AV13sdt_conveVacaciones ;
   private web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem AV14item ;
}

