package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem extends GxUserType
{
   public Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem( )
   {
      this(  new ModelContext(Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem.class));
   }

   public Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem( ModelContext context )
   {
      super( context, "Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem");
   }

   public Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem( int remoteHandle ,
                                                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem");
   }

   public Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem( StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CatCodigo") )
            {
               gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SueldoBasico") )
            {
               gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Periodo") )
            {
               gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo = GXutil.nullDate() ;
                  gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N = (byte)(0) ;
                  gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerMes") )
            {
               gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerAno") )
            {
               gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano = (short)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdt_liq_retroactivas.sdt_liq_retroactivasItem" ;
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
      oWriter.writeElement("CatCodigo", gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SueldoBasico", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Periodo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo)) && ( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPeriodo", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("TLiqCod", gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerMes", GXutil.trim( GXutil.str( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerAno", GXutil.trim( GXutil.str( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("CatCodigo", gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo, false, false);
      AddObjectProperty("SueldoBasico", gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico, false, false);
      AddObjectProperty("Periodo", gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPeriodo", sDateCnv, false, false);
      AddObjectProperty("TLiqCod", gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod, false, false);
      AddObjectProperty("LiqPerMes", gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes, false, false);
      AddObjectProperty("LiqPerAno", gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano, false, false);
   }

   public String getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo ;
   }

   public void setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo( String value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico ;
   }

   public void setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico = value ;
   }

   public int getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo ;
   }

   public void setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo( int value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo ;
   }

   public void setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo( java.util.Date value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo = value ;
   }

   public String getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod ;
   }

   public void setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod( String value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod = value ;
   }

   public byte getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes ;
   }

   public void setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes( byte value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes = value ;
   }

   public short getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano ;
   }

   public void setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano( short value )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo = "" ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N = (byte)(1) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo = GXutil.nullDate() ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N = (byte)(1) ;
      gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N ;
   }

   public web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem Clone( )
   {
      return (web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem struct )
   {
      setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo(struct.getCatcodigo());
      setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico(struct.getSueldobasico());
      setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo(struct.getPeriodo());
      if ( struct.gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N == 0 )
      {
         setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo(struct.getLiqperiodo());
      }
      setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod(struct.getTliqcod());
      setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes(struct.getLiqpermes());
      setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano(struct.getLiqperano());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem getStruct( )
   {
      web.StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem struct = new web.StructSdtsdt_liq_retroactivas_sdt_liq_retroactivasItem ();
      struct.setCatcodigo(getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo());
      struct.setSueldobasico(getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico());
      struct.setPeriodo(getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo());
      if ( gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N == 0 )
      {
         struct.setLiqperiodo(getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo());
      }
      struct.setTliqcod(getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod());
      struct.setLiqpermes(getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes());
      struct.setLiqperano(getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_N ;
   protected byte gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo_N ;
   protected byte gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes ;
   protected short gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo ;
   protected java.math.BigDecimal gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico ;
   protected String gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo ;
   protected String gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo ;
   protected boolean readElement ;
   protected boolean formatError ;
}

