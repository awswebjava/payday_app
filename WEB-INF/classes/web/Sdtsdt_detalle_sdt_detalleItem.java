package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_detalle_sdt_detalleItem extends GxUserType
{
   public Sdtsdt_detalle_sdt_detalleItem( )
   {
      this(  new ModelContext(Sdtsdt_detalle_sdt_detalleItem.class));
   }

   public Sdtsdt_detalle_sdt_detalleItem( ModelContext context )
   {
      super( context, "Sdtsdt_detalle_sdt_detalleItem");
   }

   public Sdtsdt_detalle_sdt_detalleItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_detalle_sdt_detalleItem");
   }

   public Sdtsdt_detalle_sdt_detalleItem( StructSdtsdt_detalle_sdt_detalleItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "concodigo") )
            {
               gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDImpCalcu") )
            {
               gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "encontrado") )
            {
               gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
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
         sName = "sdt_detalle.sdt_detalleItem" ;
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
      oWriter.writeElement("concodigo", gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDImpCalcu", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("encontrado", GXutil.booltostr( gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("concodigo", gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo, false, false);
      AddObjectProperty("LiqDImpCalcu", gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu, false, false);
      AddObjectProperty("encontrado", gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado, false, false);
   }

   public String getgxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo( )
   {
      return gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo ;
   }

   public void setgxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo( String value )
   {
      gxTv_Sdtsdt_detalle_sdt_detalleItem_N = (byte)(0) ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu( )
   {
      return gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu ;
   }

   public void setgxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_detalle_sdt_detalleItem_N = (byte)(0) ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu = value ;
   }

   public boolean getgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado( )
   {
      return gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado ;
   }

   public void setgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado( boolean value )
   {
      gxTv_Sdtsdt_detalle_sdt_detalleItem_N = (byte)(0) ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo = "" ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_N = (byte)(1) ;
      gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_detalle_sdt_detalleItem_N ;
   }

   public web.Sdtsdt_detalle_sdt_detalleItem Clone( )
   {
      return (web.Sdtsdt_detalle_sdt_detalleItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_detalle_sdt_detalleItem struct )
   {
      setgxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo(struct.getConcodigo());
      setgxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu(struct.getLiqdimpcalcu());
      setgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado(struct.getEncontrado());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_detalle_sdt_detalleItem getStruct( )
   {
      web.StructSdtsdt_detalle_sdt_detalleItem struct = new web.StructSdtsdt_detalle_sdt_detalleItem ();
      struct.setConcodigo(getgxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo());
      struct.setLiqdimpcalcu(getgxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu());
      struct.setEncontrado(getgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_detalle_sdt_detalleItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_detalle_sdt_detalleItem_Liqdimpcalcu ;
   protected String gxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado ;
   protected boolean readElement ;
   protected boolean formatError ;
}

