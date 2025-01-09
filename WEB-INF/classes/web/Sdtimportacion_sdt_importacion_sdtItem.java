package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtimportacion_sdt_importacion_sdtItem extends GxUserType
{
   public Sdtimportacion_sdt_importacion_sdtItem( )
   {
      this(  new ModelContext(Sdtimportacion_sdt_importacion_sdtItem.class));
   }

   public Sdtimportacion_sdt_importacion_sdtItem( ModelContext context )
   {
      super( context, "Sdtimportacion_sdt_importacion_sdtItem");
   }

   public Sdtimportacion_sdt_importacion_sdtItem( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtimportacion_sdt_importacion_sdtItem");
   }

   public Sdtimportacion_sdt_importacion_sdtItem( StructSdtimportacion_sdt_importacion_sdtItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ImpLiqDetPer") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDescrip") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqClase") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFrecPag") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqTipoTarifa") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombre") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPeriodo") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo = GXutil.nullDate() ;
                  gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N = (byte)(0) ;
                  gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerMes") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerAno") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Sec") )
            {
               gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Legajos") )
            {
               if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos == null )
               {
                  gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem>(web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem.class, "importacion_sdt.importacion_sdtItem.LegajosItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos.readxmlcollection(oReader, "Legajos", "LegajosItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Legajos") )
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
         sName = "importacion_sdt.importacion_sdtItem" ;
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
      oWriter.writeElement("ImpLiqDetPer", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDescrip", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqClase", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqFrecPag", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqTipoTarifa", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqCod", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNombre", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo)) && ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N == 1 ) )
      {
         oWriter.writeElement("LiqPeriodo", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPeriodo", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LiqPerMes", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerAno", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Sec", GXutil.trim( GXutil.str( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos != null )
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
         gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos.writexmlcollection(oWriter, "Legajos", sNameSpace1, "LegajosItem", sNameSpace1);
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
      AddObjectProperty("ImpLiqDetPer", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper, false, false);
      AddObjectProperty("LiqDescrip", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip, false, false);
      AddObjectProperty("LiqClase", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase, false, false);
      AddObjectProperty("LiqFrecPag", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag, false, false);
      AddObjectProperty("LiqTipoTarifa", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa, false, false);
      AddObjectProperty("TLiqCod", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod, false, false);
      AddObjectProperty("LiqNombre", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPeriodo", sDateCnv, false, false);
      AddObjectProperty("LiqPerMes", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes, false, false);
      AddObjectProperty("LiqPerAno", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano, false, false);
      AddObjectProperty("LiqNro", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro, false, false);
      AddObjectProperty("Sec", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec, false, false);
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos != null )
      {
         AddObjectProperty("Legajos", gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos, false, false);
      }
   }

   public String getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper = value ;
   }

   public String getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip = value ;
   }

   public byte getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase( byte value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase = value ;
   }

   public byte getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag( byte value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag = value ;
   }

   public String getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa = value ;
   }

   public String getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod = value ;
   }

   public String getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre( String value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre = value ;
   }

   public java.util.Date getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo( java.util.Date value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo = value ;
   }

   public byte getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes( byte value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes = value ;
   }

   public short getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano( short value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano = value ;
   }

   public int getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro( int value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro = value ;
   }

   public short getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec( short value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec = value ;
   }

   public GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem> getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos( )
   {
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos == null )
      {
         gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem>(web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem.class, "importacion_sdt.importacion_sdtItem.LegajosItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos( GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem> value )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(0) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos = value ;
   }

   public void setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_SetNull( )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N = (byte)(1) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos = null ;
   }

   public boolean getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_IsNull( )
   {
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_N = (byte)(1) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre = "" ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo = GXutil.nullDate() ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N = (byte)(1) ;
      gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtimportacion_sdt_importacion_sdtItem_N ;
   }

   public web.Sdtimportacion_sdt_importacion_sdtItem Clone( )
   {
      return (web.Sdtimportacion_sdt_importacion_sdtItem)(clone()) ;
   }

   public void setStruct( web.StructSdtimportacion_sdt_importacion_sdtItem struct )
   {
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper(struct.getImpliqdetper());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip(struct.getLiqdescrip());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase(struct.getLiqclase());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag(struct.getLiqfrecpag());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa(struct.getLiqtipotarifa());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod(struct.getTliqcod());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre(struct.getLiqnombre());
      if ( struct.gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N == 0 )
      {
         setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo(struct.getLiqperiodo());
      }
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes(struct.getLiqpermes());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano(struct.getLiqperano());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro(struct.getLiqnro());
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec(struct.getSec());
      GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_aux = new GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem>(web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem.class, "importacion_sdt.importacion_sdtItem.LegajosItem", "PayDay", remoteHandle);
      Vector<web.StructSdtimportacion_sdt_importacion_sdtItem_LegajosItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_aux1 = struct.getLegajos();
      if (gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_aux1.size(); i++)
         {
            gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_aux.add(new web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem(gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos(gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtimportacion_sdt_importacion_sdtItem getStruct( )
   {
      web.StructSdtimportacion_sdt_importacion_sdtItem struct = new web.StructSdtimportacion_sdt_importacion_sdtItem ();
      struct.setImpliqdetper(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper());
      struct.setLiqdescrip(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip());
      struct.setLiqclase(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase());
      struct.setLiqfrecpag(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag());
      struct.setLiqtipotarifa(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa());
      struct.setTliqcod(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod());
      struct.setLiqnombre(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre());
      if ( gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N == 0 )
      {
         struct.setLiqperiodo(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo());
      }
      struct.setLiqpermes(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes());
      struct.setLiqperano(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano());
      struct.setLiqnro(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro());
      struct.setSec(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec());
      struct.setLegajos(getgxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_N ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqclase ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqfrecpag ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo_N ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqpermes ;
   protected byte gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_N ;
   protected short gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperano ;
   protected short gxTv_Sdtimportacion_sdt_importacion_sdtItem_Sec ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnro ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Impliqdetper ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqtipotarifa ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Tliqcod ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqperiodo ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqdescrip ;
   protected String gxTv_Sdtimportacion_sdt_importacion_sdtItem_Liqnombre ;
   protected GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos_aux ;
   protected GXBaseCollection<web.Sdtimportacion_sdt_importacion_sdtItem_LegajosItem> gxTv_Sdtimportacion_sdt_importacion_sdtItem_Legajos=null ;
}

