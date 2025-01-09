package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_sdt_importacion_sdtItem_LegajosItem extends GxUserType
{
   public Sdtimportacion_sdt_importacion_sdtItem_LegajosItem( )
   {
      this(  new ModelContext(Sdtimportacion_sdt_importacion_sdtItem_LegajosItem.class));
   }

   public Sdtimportacion_sdt_importacion_sdtItem_LegajosItem( ModelContext context )
   {
      super( context, "Sdtimportacion_sdt_importacion_sdtItem_LegajosItem");
   }

   public Sdtimportacion_sdt_importacion_sdtItem_LegajosItem( int remoteHandle ,
                                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_sdt_importacion_sdtItem_LegajosItem");
   }

   public Sdtimportacion_sdt_importacion_sdtItem_LegajosItem( StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "netoImportes") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "duplica") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Detalle") )
            {
               if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle == null )
               {
                  gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem>(web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem.class, "importacion_sdt.importacion_sdtItem.LegajosItem.DetalleItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle.readxmlcollection(oReader, "Detalle", "DetalleItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Detalle") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "importacion_sdt.importacion_sdtItem.LegajosItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("netoImportes", GXutil.trim( GXutil.strNoRound( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("duplica", GXutil.booltostr( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle.writexmlcollection(oWriter, "Detalle", sNameSpace1, "DetalleItem", sNameSpace1);
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("LegNumero", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero, false, false);
      AddObjectProperty("netoImportes", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes, false, false);
      AddObjectProperty("duplica", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica, false, false);
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle != null )
      {
         AddObjectProperty("Detalle", gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle, false, false);
      }
   }

   public int getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero( int value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes( java.math.BigDecimal value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes = value ;
   }

   public boolean getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica( boolean value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica = value ;
   }

   public GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle( )
   {
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle == null )
      {
         gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem>(web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem.class, "importacion_sdt.importacion_sdtItem.LegajosItem.DetalleItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle( GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle = value ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_SetNull( )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N = (byte)(1) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle = null ;
   }

   public boolean getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_IsNull( )
   {
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N = (byte)(1) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes = DecimalUtil.ZERO ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N ;
   }

   public web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem Clone( )
   {
      return (web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem struct )
   {
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero(struct.getLegnumero());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes(struct.getNetoimportes());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica(struct.getDuplica());
      GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_aux = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem>(web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem.class, "importacion_sdt.importacion_sdtItem.LegajosItem.DetalleItem", "PayDay", remoteHandle);
      Vector<web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_aux1 = struct.getDetalle();
      if (gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_aux1.size(); i++)
         {
            gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_aux.add(new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem(gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle(gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem getStruct( )
   {
      web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem struct = new web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem ();
      struct.setLegnumero(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero());
      struct.setNetoimportes(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes());
      struct.setDuplica(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica());
      struct.setDetalle(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_N ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Legnumero ;
   protected java.math.BigDecimal gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Netoimportes ;
   protected String sTagName ;
   protected boolean gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Duplica ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle_aux ;
   protected GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_DetalleItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_LegajosItem_Detalle=null ;
}

