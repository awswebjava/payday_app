package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_liquidacion_sdt_liquidacionItem extends GxUserType
{
   public Sdtsdt_liquidacion_sdt_liquidacionItem( )
   {
      this(  new ModelContext(Sdtsdt_liquidacion_sdt_liquidacionItem.class));
   }

   public Sdtsdt_liquidacion_sdt_liquidacionItem( ModelContext context )
   {
      super( context, "Sdtsdt_liquidacion_sdt_liquidacionItem");
   }

   public Sdtsdt_liquidacion_sdt_liquidacionItem( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_liquidacion_sdt_liquidacionItem");
   }

   public Sdtsdt_liquidacion_sdt_liquidacionItem( StructSdtsdt_liquidacion_sdt_liquidacionItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo = GXutil.nullDate() ;
                  gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N = (byte)(0) ;
                  gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "incluir") )
            {
               gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "sdt_liquidacion.sdt_liquidacionItem" ;
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
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo)) && ( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPeriodo", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("incluir", GXutil.booltostr( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir));
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
      AddObjectProperty("LiqNro", gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPeriodo", sDateCnv, false, false);
      AddObjectProperty("incluir", gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir, false, false);
   }

   public int getgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro( )
   {
      return gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro ;
   }

   public void setgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro( int value )
   {
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo( )
   {
      return gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo ;
   }

   public void setgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo( java.util.Date value )
   {
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo = value ;
   }

   public boolean getgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir( )
   {
      return gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir ;
   }

   public void setgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir( boolean value )
   {
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N = (byte)(0) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N = (byte)(1) ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo = GXutil.nullDate() ;
      gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N ;
   }

   public web.Sdtsdt_liquidacion_sdt_liquidacionItem Clone( )
   {
      return (web.Sdtsdt_liquidacion_sdt_liquidacionItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_liquidacion_sdt_liquidacionItem struct )
   {
      setgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro(struct.getLiqnro());
      if ( struct.gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N == 0 )
      {
         setgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo(struct.getLiqperiodo());
      }
      setgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir(struct.getIncluir());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_liquidacion_sdt_liquidacionItem getStruct( )
   {
      web.StructSdtsdt_liquidacion_sdt_liquidacionItem struct = new web.StructSdtsdt_liquidacion_sdt_liquidacionItem ();
      struct.setLiqnro(getgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro());
      if ( gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N == 0 )
      {
         struct.setLiqperiodo(getgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo());
      }
      struct.setIncluir(getgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_N ;
   protected byte gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqperiodo ;
   protected boolean gxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Incluir ;
   protected boolean readElement ;
   protected boolean formatError ;
}

